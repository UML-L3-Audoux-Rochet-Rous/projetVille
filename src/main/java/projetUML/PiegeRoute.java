package projetUML;

public class PiegeRoute extends Piege{

    @Override
    public void modifPiege(Personnage personnage) {
        if (typePiege == "Feu Rouge"){
            personnage.setVie(personnage.getVie()-1);
        }

        else if(typePiege == "Police"){
            personnage.setMoral(personnage.getMoral()-1);
        }
        else if(typePiege == "Nid de poule"){
            personnage.setHydratation(personnage.getHydratation()-2);
            personnage.setSatiete(personnage.getSatiete()-2);
        }
    }
}
