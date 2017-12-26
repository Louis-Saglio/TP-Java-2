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
        return "Est-ce que " + this.property.getName() + " du sujet est " + this.value + " ?";
    }

    public ArrayList<Fact> getContraries() {
        ArrayList<Fact> contraries = new ArrayList<>();
        for (String value : this.property.getPotentialValues()) {
            if (!value.equals(this.value)) {
                contraries.add(new Fact(this.property, value));
            }
        }
        return contraries;
    }

    public static ArrayList<Fact> init(ArrayList<Property> properties) {
        ArrayList<Fact> facts = new ArrayList<>();
        for (Property property1 : properties) {
            facts.add(new Fact(property1, property1.getPotentialValues().get(0)));
        }
        facts.add(new Fact(properties.get(0), properties.get(0).getPotentialValues().get(1)));
        return facts;
    }

    public boolean equals(Fact fact) {
        return this.property == fact.property && this.value.equals(fact.value);
    }

    @Override
    public String toString() {
        return property.getName() + " du sujet est " + value;
    }

    public Property getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }
}