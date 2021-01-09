package projetUML;

public class Case {

    public String typeCase;
    public Batiment batiment;

    public Case(String typeCase) {
        this.typeCase = typeCase;
        switch (typeCase) {
            case "Bar" -> batiment = new Bar();
            case "Bibliotheque" -> batiment = new Bibliotheque();
            case "FastFood" -> batiment = new FastFood();
            case "Maison" -> batiment = new Maison();
            case "Universite" -> batiment = new Universite();
            case "Route" -> batiment = new Route();
            case "Trottoir" -> batiment = new Trottoir();
        }
    }

    public Case() {
    }

    public String getTypeCase() {
        return typeCase;
    }


}
