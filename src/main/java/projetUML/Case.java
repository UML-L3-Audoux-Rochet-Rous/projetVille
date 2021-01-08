package projetUML;

public class Case {

    public String typeCase;
    public Batiment batiment;
    public Route route;
    public Trottoir trottoir;

    public Case(String typeCase) {
        this.typeCase = typeCase;
        switch (typeCase) {
            case "Bar" -> batiment = new Bar();
            case "Bibliotheque" -> batiment = new Bibliotheque();
            case "FastFood" -> batiment = new FastFood();
            case "Maison" -> batiment = new Maison();
            case "Universite" -> batiment = new Universite();
            case "Route" -> route = new Route();
            case "Trottoir" -> trottoir = new Trottoir();
        }
    }

    public Case() {
    }

    public String getTypeCase() {
        return typeCase;
    }
}
