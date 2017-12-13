package tests;

import data_reader.Reader;

public class TestReader {

    public TestReader() {
    }

    public void testPropositionReader() {
        Reader reader = new Reader("/home/louis/Projects/Java/TP-Java-2/06-Systeme_Expert/data/rules.xml");
        System.out.println(reader.readPropositions());
    }

    public void testRuleReader() {
        Reader reader = new Reader("/home/louis/Projects/Java/TP-Java-2/06-Systeme_Expert/data/rules.xml");
        reader.readPropositions();
    }

    public static void main(String[] args) {
        new TestReader().testPropositionReader();
    }
}
