package projetUML;

import javax.swing.*;
import java.util.Random;

public class Main {

    public static Scene scene;

    public static void main(String[] args) {

        JFrame fenetre = new JFrame("Quand on arrive en ville");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);

        scene = new Scene();

        fenetre.setContentPane(scene);
        fenetre.setVisible(true);
    }
}
