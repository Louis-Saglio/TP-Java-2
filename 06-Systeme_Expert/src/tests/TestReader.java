package tests;

import data_reader.Reader;
import org.jdom2.DataConversionException;

public class TestReader {

    public TestReader() throws DataConversionException {
        this.testPropositionReader();
        this.testRuleReader();
        this.testTruthReader();
    }

    public void testPropositionReader() {
        Reader reader = new Reader("/home/louis/Projects/Java/TP-Java-2/06-Systeme_Expert/data/rules.xml");
        System.out.println(reader.readPropositions());
    }

    public void testRuleReader() throws DataConversionException {
        Reader reader = new Reader("/home/louis/Projects/Java/TP-Java-2/06-Systeme_Expert/data/rules.xml");
        reader.readPropositions();
        System.out.println(reader.readRules());
    }

    public void testTruthReader() {
        Reader reader = new Reader("/home/louis/Projects/Java/TP-Java-2/06-Systeme_Expert/data/rules.xml");
        reader.readPropositions();
        System.out.println(reader.readTruth());
    }

    public static void main(String[] args) throws DataConversionException {
        new TestReader();
    }
}
