package beans;

import java.util.ArrayList;

public class Property {
    private String name;
    private ArrayList<String> potentialValues;

    public Property(String name, ArrayList<String> potentialValues) {
        this.name = name;
        this.potentialValues = potentialValues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPotentialValues() {
        return potentialValues;
    }

    public void setPotentialValues(ArrayList<String> potentialValues) {
        this.potentialValues = potentialValues;
    }

    public static ArrayList<Property> init() {
        ArrayList<Property> properties = new ArrayList<>();

        ArrayList<String> couleursCheveux = new ArrayList<>();
        couleursCheveux.add("Blond");
        couleursCheveux.add("Brun");
        couleursCheveux.add("Noir");
        couleursCheveux.add("Blanc");
        properties.add(new Property("la couleur des cheveux", couleursCheveux));

        ArrayList<String> formeNez = new ArrayList<>();
        formeNez.add("Gros");
        formeNez.add("Petit");
        formeNez.add("Crochu");
        formeNez.add("Droit");
        properties.add(new Property("la forme du nez", formeNez));

        ArrayList<String> couleursYeux = new ArrayList<>();
        couleursYeux.add("Marron");
        couleursYeux.add("Bleu");
        couleursYeux.add("Vert");
        properties.add(new Property("la couleur des yeux", couleursYeux));

        return properties;
    }
}
