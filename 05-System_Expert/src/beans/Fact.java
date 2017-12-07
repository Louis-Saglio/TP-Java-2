package beans;

import java.util.ArrayList;

public class Fact {
    private Property property;
    private String value;

    public Fact(Property property, String value) {
        this.property = property;
        this.value = value;
    }

    public String getQuestion() {
        return "Est-ce que " + this.property + " est " + this.value + " ?";
    }

    public ArrayList<Fact> getContraries() {
        ArrayList<Fact> contraries = new ArrayList<>();
        for (String value : this.property.getPotentialValues()) {
            contraries.add(new Fact(this.property, value));
        }
        return contraries;
    }

    public static ArrayList<Fact> init() {
        ArrayList<Fact> facts = new ArrayList<>();
        ArrayList<Property> properties = Property.init();
        for (Property property1 : properties) {
            facts.add(new Fact(property1, property1.getPotentialValues().get(0)));
        }
        return facts;
    }
}