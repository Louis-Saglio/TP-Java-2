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
}
