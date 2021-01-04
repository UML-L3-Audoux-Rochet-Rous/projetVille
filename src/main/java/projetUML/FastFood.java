package projetUML;

public class FastFood extends Batiment {

    public FastFood() {
    }

    public String getNom(){
        return "Fast-Food";
    }

    public void ressourcer(Personnage personnage){
        personnage.setSatiete(personnage.getSatiete()+25);
        personnage.setHydratation(personnage.getHydratation()+10);
        personnage.setMoral(personnage.getMoral()+10);
        personnage.setVie(personnage.getVie()-5);
    }
}
