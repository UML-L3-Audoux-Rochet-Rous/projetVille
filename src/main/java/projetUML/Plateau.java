package projetUML;

import java.awt.event.KeyEvent;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.lang.*;

public class Plateau extends Case {

private Case [][] plateau;
private int barX;
private int barY;
private int univX;
private int univY;
private int biblioX;
private int biblioY;
private int fastX;
private int fastY;
private int maisonX;
private int maisonY;

public Plateau(String typeCase) {
    super(typeCase);
}

public Plateau(Personnage personnage){
    Random rand = new Random();
    Random rand2 = new Random();
    List<String> givenList = new ArrayList<>(Arrays.asList("Bar" , "Bibliotheque", "FastFood","Maison","Universite"));
    List<String> routeTrottoir = new ArrayList<>(Arrays.asList("Route","Trottoir"));
    plateau = new Case[10][10];
    int taille = 8;
    int randomX = rand.nextInt(taille);
    int randomY  = rand.nextInt(taille);
    while(givenList.size() != 0){
        int randomIndex = rand.nextInt(givenList.size());
        while (plateau[randomX][randomY] != null) {
            randomX = rand.nextInt(taille);
            randomY = rand.nextInt(taille);
        }
        plateau[randomX][randomY] = new Case(givenList.get(randomIndex));
        givenList.remove(randomIndex);
    }
    for (int x = 0 ; x < plateau.length; x++) {
        for (int y = 0; y < plateau.length; y++) {
            if(plateau[x][y] != null && !plateau[x][y].getTypeCase().equals(".") && !plateau[x][y].getTypeCase().equals("#")) { //OK
                if (x == 0 && y == 0) {
                    int randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x + 1][y] = new Case("Route");
                    randomIndex = randomIndex - 1;
                    plateau[x][y+1] = new Case("Trottoir");

                }
                 else if(x ==0 ){
                    int randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x][y+1] = new Case("Trottoir");
                    randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x][y-1] = new Case(routeTrottoir.get(randomIndex));
                    randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x+1][y] = new Case(routeTrottoir.get(randomIndex));
                }
               else if(y ==0){
                    int randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x][y+1] = new Case(routeTrottoir.get(randomIndex));
                    randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x-1][y] = new Case(routeTrottoir.get(randomIndex));
                    randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x+1][y] = new Case(routeTrottoir.get(randomIndex));
                }
                else{
                    int randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x+1][y] = new Case(routeTrottoir.get(randomIndex));
                    randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x-1][y] = new Case(routeTrottoir.get(randomIndex));
                    randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x][y+1] = new Case(routeTrottoir.get(randomIndex));
                    randomIndex = rand.nextInt(routeTrottoir.size());
                    plateau[x][y-1] = new Case(routeTrottoir.get(randomIndex));
                }
            }
            else if(plateau[x][y] == null){
                int randomIndex = rand.nextInt(routeTrottoir.size());
                plateau[x][y] = new Case(routeTrottoir.get(randomIndex));
            }
        }
    }
    for (int i = 0; i < plateau.length; i++) {
        for (int j = 0; j < plateau.length; j++) {
            String aCase = plateau[i][j].getTypeCase();
            if ("B".equals(aCase)) {
                barX = i;
                barY = j;
            } else if ("U".equals(aCase)) {
                univX = i;
                univY = j;
            } else if ("BU".equals(aCase)) {
                biblioX = i;
                biblioY = j;
            } else if ("BK".equals(aCase)) {
                fastX = i;
                fastY = j;
            } else if ("M".equals(aCase)) {
                maisonX = i;
                maisonY = j;
            }
        }
    }
    personnage.setPersoX(maisonX);
    personnage.setPersoY(maisonY);
}

public void affiche(){
    for (int i = 0; i < plateau.length; i++){
        for (int j = 0; j < plateau.length; j++) {
            System.out.print(plateau[i][j].getTypeCase() + "");
        }
        System.out.println();
    }
}


public void deplacement(Personnage personnage, MoyenTransport moyenTransport){
    String pos = "Debut";
    String previousPos = "";
    String previousSymb = "";
    while(!pos.equals("Arret")){ // AJOUTER MOYEN TRANSPORT
        System.out.println("Utiliser Z Q S D pour vous deplacer dans la ville");
        Scanner user = new Scanner(System.in);
        pos = user.nextLine();
        if ("Z".equals(pos)) {
            previousPos = pos;
            int X = personnage.getPersoX() -1;
            if((moyenTransport.getMoyenTransport().equals("Voiture") || moyenTransport.getMoyenTransport().equals("Velo")) && plateau[X][personnage.getPersoY()].getTypeCase().equals(".")){
                personnage.setPersoX(personnage.getPersoX() - 1);
                moyenTransport.deplacer(personnage);
                /*if(plateau[personnage.getPersoX()-1][personnage.getPersoY()].getTypeCase().equals("V")){
                    plateau[personnage.getPersoX()-1][personnage.getPersoY()].setTypeCase(previousSymb);
                }
                previousSymb = plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase();*/
                plateau[personnage.getPersoX()][personnage.getPersoY()].setTypeCase("V");
            }
            else if(moyenTransport.getMoyenTransport().equals("A Pied") && plateau[X][personnage.getPersoY()].getTypeCase().equals("#")){
                personnage.setPersoX(personnage.getPersoX() - 1);
                moyenTransport.deplacer(personnage);
                plateau[personnage.getPersoX()][personnage.getPersoY()].setTypeCase("V");
            }
            else if(!plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals(".") && !plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals("#")){
                personnage.setPersoX(personnage.getPersoX() - 1);
                moyenTransport.deplacer(personnage);
                seRessourcer(personnage);
            }
            else {
                System.out.println("pas bon moyen de transport");
                String transport = "";
                System.out.println("Voulez vous changer de moyen de transport ? ");
                transport = user.nextLine();
                moyenTransport.setMoyenTransport(transport);
                moyenTransport.deplacer(personnage);
            }
        } else if ("S".equals(pos)) {
            int X = personnage.getPersoX() +1;
            if((moyenTransport.getMoyenTransport().equals("Voiture") || moyenTransport.getMoyenTransport().equals("Velo")) && plateau[X][personnage.getPersoY()].getTypeCase().equals(".")){
                personnage.setPersoX(personnage.getPersoX() + 1);
                moyenTransport.deplacer(personnage);
                plateau[personnage.getPersoX()][personnage.getPersoY()].setTypeCase("V");
            }
            else if(moyenTransport.getMoyenTransport().equals("A Pied") && plateau[X][personnage.getPersoY()].getTypeCase().equals("#")){
                personnage.setPersoX(personnage.getPersoX() + 1);
                moyenTransport.deplacer(personnage);
                plateau[personnage.getPersoX()][personnage.getPersoY()].setTypeCase("V");
            }
            else if(!plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals(".") && !plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals("#")){
                personnage.setPersoX(personnage.getPersoX() + 1);
                moyenTransport.deplacer(personnage);
                seRessourcer(personnage);
            }
            else {
                System.out.println("pas bon moyen de transport");
                String transport = "";
                System.out.println("Voulez vous changer de moyen de transport ? ");
                transport = user.nextLine();
                moyenTransport.setMoyenTransport(transport);
                moyenTransport.deplacer(personnage);
            }
        } else if ("Q".equals(pos)) {
            int Y = personnage.getPersoY() -1;
            if((moyenTransport.getMoyenTransport().equals("Voiture") || moyenTransport.getMoyenTransport().equals("Velo")) && plateau[personnage.getPersoX()][Y].getTypeCase().equals(".")){
                personnage.setPersoY(personnage.getPersoY() - 1);
                moyenTransport.deplacer(personnage);
                plateau[personnage.getPersoX()][personnage.getPersoY()].setTypeCase("V");
            }
            else if(moyenTransport.getMoyenTransport().equals("A Pied") && plateau[personnage.getPersoX()][Y].getTypeCase().equals("#")){
                personnage.setPersoY(personnage.getPersoY() - 1);
                moyenTransport.deplacer(personnage);
                plateau[personnage.getPersoX()][personnage.getPersoY()].setTypeCase("V");
            }
            else if(!plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals(".") && !plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals("#")){
                personnage.setPersoX(personnage.getPersoY() - 1);
                moyenTransport.deplacer(personnage);
                seRessourcer(personnage);
            }
            else {
                System.out.println("pas bon moyen de transport");
                String transport = "";
                System.out.println("Voulez vous changer de moyen de transport ? ");
                transport = user.nextLine();
                moyenTransport.setMoyenTransport(transport);
                moyenTransport.deplacer(personnage);
            }
        } else if ("D".equals(pos)) {
            int Y = personnage.getPersoY() +1;
            if((moyenTransport.getMoyenTransport().equals("Voiture") || moyenTransport.getMoyenTransport().equals("Velo")) && plateau[personnage.getPersoX()][Y].getTypeCase().equals(".")){
                personnage.setPersoY(personnage.getPersoY() + 1);
                moyenTransport.deplacer(personnage);
                plateau[personnage.getPersoX()][personnage.getPersoY()].setTypeCase("V");
            }
            else if(moyenTransport.getMoyenTransport().equals("A Pied") && plateau[personnage.getPersoX()][Y].getTypeCase().equals("#")){
                personnage.setPersoY(personnage.getPersoY() + 1);
                moyenTransport.deplacer(personnage);
                plateau[personnage.getPersoX()][personnage.getPersoY()].setTypeCase("V");
            }
            else if(!plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals(".") && !plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals("#")){
                personnage.setPersoX(personnage.getPersoY() + 1);
                moyenTransport.deplacer(personnage);
                seRessourcer(personnage);
            }
            else {
                System.out.println("pas bon moyen de transport");
                String transport = "";
                System.out.println("Voulez vous changer de moyen de transport ? ");
                transport = user.nextLine();
                moyenTransport.setMoyenTransport(transport);
                moyenTransport.deplacer(personnage);
            }
        }
        /*else if("".equals(pos) && !previousPos.equals("")){
            if ("Z".equals(previousPos)) {
                personnage.setPersoX(personnage.getPersoX() + 1);
                moyenTransport.deplacer(personnage);
            } else if ("S".equals(previousPos)) {
                personnage.setPersoX(personnage.getPersoX() - 1);
                moyenTransport.deplacer(personnage);
            } else if ("Q".equals(previousPos)) {
                personnage.setPersoY(personnage.getPersoY() - 1);
                moyenTransport.deplacer(personnage);
            } else if ("D".equals(previousPos)) {
                personnage.setPersoY(personnage.getPersoY() + 1);
                moyenTransport.deplacer(personnage);
            }
        }*/
        if(personnage.getPersoX() == barX && personnage.getPersoY() == barY && !plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals(".") && !plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase().equals("#") ){
            plateau[barX][barY].batiment.ressourcer(personnage);
        }
        else if(personnage.getPersoX() == univX && personnage.getPersoY() == univY){
            plateau[univY][univY].batiment.ressourcer(personnage);
        }
        else if(personnage.getPersoX() == biblioX && personnage.getPersoY() == biblioY){
            plateau[biblioX][biblioY].batiment.ressourcer(personnage);
        }
        else if(personnage.getPersoX() == fastX && personnage.getPersoY() == fastY){
            plateau[fastX][fastY].batiment.ressourcer(personnage);
        }
        affiche();
        System.out.println("Vous vous trouvez sur : " + plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase());
        personnage.affiche();
    }
}

public void seRessourcer(Personnage personnage){
    if(personnage.getPersoX() == barX && personnage.getPersoY() == barY){
        plateau[barX][barY].batiment.ressourcer(personnage);
    }
    else if(personnage.getPersoX() == univX && personnage.getPersoY() == univY){
        plateau[univY][univY].batiment.ressourcer(personnage);
    }
    else if(personnage.getPersoX() == biblioX && personnage.getPersoY() == biblioY){
        plateau[biblioX][biblioY].batiment.ressourcer(personnage);
    }
    else if(personnage.getPersoX() == fastX && personnage.getPersoY() == fastY){
        plateau[fastX][fastY].batiment.ressourcer(personnage);
    }
}
}
