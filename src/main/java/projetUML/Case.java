package projetUML;

public class Case {

    public String typeCase;
    public Batiment batiment;
    public Route route;
    public Trottoir trottoir;

    public Case(String typeCase) {
        this.typeCase = typeCase;
        if (typeCase.equals("Bar")){
            batiment = new Bar();
        }
        else if (typeCase.equals("Bibliotheque")){
            batiment = new Bibliotheque();
        }
        else if (typeCase.equals("FastFood")){
            batiment = new FastFood();
        }
        else if (typeCase.equals("Maison")){
            batiment = new Maison();
        }
        else if (typeCase.equals("Universite")){
            batiment = new Universite();
        }

        else if(typeCase.equals("Route")){
            route = new Route();
        }
        else if (typeCase.equals("Trottoir")){
            trottoir = new Trottoir();
        }
    }

    public Case() {
    }

    public String getTypeCase() {
        return typeCase;
    }
}
