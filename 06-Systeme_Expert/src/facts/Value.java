package facts;

public class Value {
    private String name;

    @Override
    public String toString() {
        return "Value{" +
                '\'' + name + '\'' +
                '}';
    }

    public Value(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
