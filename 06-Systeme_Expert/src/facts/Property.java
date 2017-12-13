package facts;

public class Property {
    private String name;
    private Values possibleValues;

    public Property(String name) {
        this.name = name;
        this.possibleValues = new Values();
    }

    public Values getPossibleValues() {
        return possibleValues;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", possibleValues=" + possibleValues +
                '}';
    }

    public String getName() {
        return name;
    }
}
