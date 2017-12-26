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

    public Facts getContraries() {
        Facts rep = new Facts();
        for (Value value1 : this.property.filter(this.value)) {
            rep.add(new Fact(this.property, value1));
        }
        return rep;
    }
}
