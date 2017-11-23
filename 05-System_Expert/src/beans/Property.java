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
}
