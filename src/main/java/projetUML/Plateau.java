package projetUML;

import java.util.*;

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
        List<String> givenList = new ArrayList<>(Arrays.asList("Bar" , "Bibliotheque", "FastFood","Maison","Route","Trottoir","Universite"));
        plateau = new Case[10][10];
        for (int x = 0 ; x <plateau.length; x++){
            for (int y = 0; y < plateau.length; y++){
                int randomIndex = rand.nextInt(givenList.size());
                plateau[x][y] = new Case(givenList.get(randomIndex));
                System.out.println(givenList);
                if(givenList.get(randomIndex).equals("Bar") || givenList.get(randomIndex).equals("Bibliotheque") || givenList.get(randomIndex).equals("FastFood") ||
                        givenList.get(randomIndex).equals("Maison") || givenList.get(randomIndex).equals("Universite")){
                    givenList.remove(randomIndex);
                }
                if(plateau[x][y] == null){
                    randomIndex = rand.nextInt(givenList.size());
                    plateau[x][y] = new Case(givenList.get(randomIndex));
                }
            }
        }
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                switch (plateau[i][j].getTypeCase()) {
                    case "Bar" -> {
                        barX = i;
                        barY = j;
                    }
                    case "Universite" -> {
                        univX = i;
                        univY = j;
                    }
                    case "Bibliotheque" -> {
                        biblioX = i;
                        biblioY = j;
                    }
                    case "FastFood" -> {
                        fastX = i;
                        fastY = j;
                    }
                    case "Maison" -> {
                        maisonX = i;
                        maisonY = j;
                    }
                }
            }
        }
        personnage.setPersoX(maisonX);
        personnage.setPersoY(maisonY);
        System.out.println(personnage.getPersoX() + " " + personnage.getPersoY());
    }

    public void affiche(){
        for (int i = 0; i < plateau.length; i++){
            for (int j = 0; j < plateau.length; j++) {
                System.out.print(plateau[i][j].getTypeCase() + "    \t");
            }
            System.out.println();
        }
    }


    public void deplacement(Personnage personnage, MoyenTransport moyenTransport){
        String pos = "Debut";
        while(!pos.equals("Arret")){ // AJOUTER MOYEN TRANSPORT
            System.out.println("Utiliser Z Q S D pour vous deplacer dans la ville");
            Scanner user = new Scanner(System.in);
            pos = user.nextLine();
            switch (pos) {
                case "Z" -> {
                    personnage.setPersoX(personnage.getPersoX() + 1);
                    moyenTransport.deplacer(personnage);
                }
                case "S" -> {
                    personnage.setPersoX(personnage.getPersoX() - 1);
                    moyenTransport.deplacer(personnage);
                }
                case "Q" -> {
                    personnage.setPersoY(personnage.getPersoY() - 1);
                    moyenTransport.deplacer(personnage);
                }
                case "D" -> {
                    personnage.setPersoY(personnage.getPersoY() + 1);
                    moyenTransport.deplacer(personnage);
                }
            }
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
            System.out.println(personnage.getPersoX() + " " + personnage.getPersoY());
            personnage.affiche();
            System.out.println(plateau[personnage.getPersoX()][personnage.getPersoY()].getTypeCase());
        }
    }
}
