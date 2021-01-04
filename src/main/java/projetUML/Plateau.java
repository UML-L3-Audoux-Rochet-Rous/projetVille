package projetUML;

import java.util.Scanner;

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
        this.plateau = new Case[][]{
                {new Case("Bar"), new Case("Trottoir"), new Case("Route"), new Case("Route"), new Case("Trottoir")},
                {new Case("Universite"), new Case("Trottoir"), new Case("Route"), new Case("Route"), new Case("Trottoir")},
                {new Case("Bibliotheque"), new Case("Trottoir"), new Case("Route"), new Case("Route"), new Case("Trottoir")},
                {new Case("FastFood"), new Case("Trottoir"), new Case("Route"), new Case("Route"), new Case("Trottoir")},
                {new Case("Maison"), new Case("Trottoir"), new Case("Route"), new Case("Route"), new Case("Trottoir")},
        };
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                switch (plateau[i][j].getTypeCase()){
                    case "Bar":
                        barX = i;
                        barY = j;
                        break;
                    case "Universite":
                        univX = i;
                        univY = j;
                        break;
                    case "Bibliotheque":
                        biblioX = i;
                        biblioY = j;
                        break;
                    case "FastFood":
                        fastX = i;
                        fastY = j;
                        break;
                    case "Maison":
                        maisonX = i;
                        maisonY = j;
                        break;
                }
            }
        }
        personnage.setPersoX(maisonX);
        personnage.setPersoY(maisonY);
        System.out.println(personnage.getPersoX() + " " + personnage.getPersoY());
    }


    public void deplacement(Personnage personnage){
        String pos = "Debut";
        while(pos != "Arret"){
            System.out.println("Utiliser Z Q S D pour vous deplacer dans la ville");
            Scanner user = new Scanner(System.in);
            pos = user.nextLine();
            switch (pos){
                case "Z":
                    personnage.setPersoX(personnage.getPersoX()+1);
                    break;
                case "S":
                    personnage.setPersoX(personnage.getPersoX()-1);
                    break;
                case "Q":
                    personnage.setPersoY(personnage.getPersoY()-1);
                    break;
                case "D":
                    personnage.setPersoY(personnage.getPersoY()+1);
                    break;
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
