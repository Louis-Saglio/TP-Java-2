package facts;

public class Fact {
    private Property property;
    private Value value;

    public Fact(Property property, Value value) {
        this.property = property;
        this.value = value;
        this.property.getPossibleValues().add(value);
        this.check();
    }

    private void check() {
        assert this.property.getPossibleValues().contains(value);
    }

    @Override
    public String toString() {
        return "Fact{" + property.getName() + " est " + value.getName() + '}';
    }
}
