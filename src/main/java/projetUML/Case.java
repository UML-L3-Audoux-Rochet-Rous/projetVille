package projetUML;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Case {

    public String typeCase;
    public Batiment batiment;
    public Trottoir trottoir;
    public Route route;
    public Piege piegeRoute;

    public Case(String typeCase) {
        List<String> PiegeRoute = new ArrayList<>(Arrays.asList("Feu Rouge","Police","Nid de poule"));
        this.typeCase = typeCase;
        if ("Bar".equals(typeCase)) {
            batiment = new Bar();
        } else if ("Bibliotheque".equals(typeCase)) {
            batiment = new Bibliotheque();
        } else if ("FastFood".equals(typeCase)) {
            batiment = new FastFood();
        } else if ("Maison".equals(typeCase)) {
            batiment = new Maison();
        } else if ("Universite".equals(typeCase)) {
            batiment = new Universite();
        } else if ("Route".equals(typeCase)) {
            Random chance = new Random();
            int piege = chance.nextInt(100);
            if (piege <= 80){
                piegeRoute = new PiegeRoute("Police");
            }
            route = new Route();
        } else if ("Trottoir".equals(typeCase)) {
            trottoir = new Trottoir();
        }
    }

    public Case() {
    }

    public String getTypeCase() {
        return switch (typeCase) {
            case "Bar" -> "B";
            case "Bibliotheque" -> "BU";
            case "FastFood" -> "BK";
            case "Maison" -> "M";
            case "Universite" -> "U";
            case "Route" -> ".";
            case "Trottoir" -> "#";
            default -> typeCase;
        };
    }

    public void setTypeCase(String typeCase) {
        this.typeCase = typeCase;
    }
}
