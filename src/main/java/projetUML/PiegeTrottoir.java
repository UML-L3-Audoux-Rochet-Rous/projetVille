package projetUML;

public class PiegeTrottoir extends Piege{

    @Override
    public void modifPiege(Personnage personnage) {
        if (typePiege.equals("Peau de Banane")){
            personnage.setVie(personnage.getVie()-3);
        }

        else if(typePiege.equals("Poussette")){
            personnage.setMoral(personnage.getMoral()-2);
        }
        else if(typePiege.equals("Dejection canine")){
            personnage.setSatiete(personnage.getSatiete()-1);
        }
    }
}
