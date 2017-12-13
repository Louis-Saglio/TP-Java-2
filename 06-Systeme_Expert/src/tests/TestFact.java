package tests;

import facts.Fact;
import facts.Property;
import facts.Value;
import facts.Values;

public class TestFact {

    public TestFact() {
        this.testCheck();
    }

    public void testCheck() {
        Value value1 = new Value("noir");
        Value value2 = new Value("Blanc");
        Values values = new Values(value1, value2);
        Property property = new Property("couleur de la peau");
        new Fact(property, value1);
    }

    public static void main(String[] args) {
        new TestFact();
    }

}
