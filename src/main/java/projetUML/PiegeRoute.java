package projetUML;

public class PiegeRoute extends Piege{

    public PiegeRoute(String typePiege){
        this.typePiege = typePiege;
    }

    public void modifPiege(Personnage personnage) {
        if (typePiege.equals("Feu Rouge")){
            personnage.setVie(personnage.getVie()-1);
        }

        else if(typePiege.equals("Police")){
            personnage.setMoral(personnage.getMoral()-1);
        }
        else if(typePiege.equals("Nid de poule")){
            personnage.setHydratation(personnage.getHydratation()-2);
            personnage.setSatiete(personnage.getSatiete()-2);
        }
    }
}
