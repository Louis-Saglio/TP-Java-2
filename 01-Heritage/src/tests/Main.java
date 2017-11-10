package tests;

import beans.Etudiant;
import beans.PremierCycle;
import beans.SecondCycle;
import beans.Support;

public class Main {
    public static void main(String[] args) {
        Etudiant etudiant = new Etudiant("Louis", 1, "Math", 2);
        System.out.println(etudiant);
        PremierCycle premierCycle = new PremierCycle("Toto", 2, "Français", 4);
        System.out.println(premierCycle);
        SecondCycle secondCycle = new SecondCycle("Lili", 3, "Philosophie", 5, Support.AssistantProfesseur);
        System.out.println(secondCycle);
    }
}
