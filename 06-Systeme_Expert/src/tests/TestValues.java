package tests;

import facts.Value;
import facts.Values;

public class TestValues {
    public TestValues() {
        Values values = new Values("a", "b", "c");
        Value value = new Value("d");
        values.add(value);
        System.out.println(values);
        System.out.println(values.filter(value));
    }

    public static void main(String[] args) {
        new TestValues();
    }
}
