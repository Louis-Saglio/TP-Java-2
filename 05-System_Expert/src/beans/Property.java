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

        ArrayList<String> couleurPeau = new ArrayList<>();
        couleurPeau.add("Noire");
        couleurPeau.add("Blanche");
        couleurPeau.add("Rouge");
        couleurPeau.add("Jaune");
        couleurPeau.add("Bronzée");
        properties.add(new Property("la couleur de la peau", couleurPeau));

        ArrayList<String> tailleMain = new ArrayList<>();
        tailleMain.add("Grande");
        tailleMain.add("Moyenne");
        tailleMain.add("Petite");
        properties.add(new Property("la taille des mains", tailleMain));

        ArrayList<String> sexe = new ArrayList<>();
        sexe.add("Homme");
        sexe.add("Femme");
        properties.add(new Property("le sexe", sexe));

        ArrayList<String> race = new ArrayList<>();
        race.add("Noire");
        race.add("Arabe");
        race.add("Latine");
        race.add("Germanique");
        race.add("Sud-asiatique");
        race.add("Juive");
        race.add("Amérindienne");
        race.add("Celtique");
        race.add("Basque");
        properties.add(new Property("la race", race));

        ArrayList<String> age = new ArrayList<>();
        age.add("Jeune");
        age.add("Mûr");
        age.add("Vieux");
        properties.add(new Property("l'âge", age));

        ArrayList<String> corpulence = new ArrayList<>();
        corpulence.add("Maigre");
        corpulence.add("Moyen");
        corpulence.add("Gros");
        properties.add(new Property("la corpulence", corpulence));

        return properties;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", potentialValues=" + potentialValues +
                '}';
    }
}
