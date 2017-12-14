package data_reader;

import facts.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Reader extends SAXBuilder{

    private Document document;
    private Propositions propositions;
    private Rules rules;

    public Reader(String file) {
        try {
            this.document = this.build(new File(file));
        } catch (JDOMException | IOException e) {
            System.out.println("Problème lors de la lecture du fichier " + file);
        }
        this.propositions = new Propositions();
        this.rules = new Rules();
    }

    public Propositions readPropositions() {
        for (Element proposition : this.document.getRootElement().getChild("propositions").getChildren("proposition")) {

            Attribute attribute = proposition.getAttribute("property");
            String property_name = attribute.getValue();
            Property property = new Property(property_name);

            Fact fact = new Fact(property, new Value(proposition.getAttribute("value").getValue()));

            boolean state = proposition.getAttribute("state").getValue().equals("true");

            try {
                propositions.add(new Proposition(fact, state, proposition.getAttribute("id").getIntValue()));
            } catch (DataConversionException e) {
                System.out.println("Impossible de convertir " + proposition.getAttribute("id") + " en int");
                System.exit(1);
            }
        }
        return propositions;
    }

    public Rules readRules() throws DataConversionException {

        Element rules = this.document.getRootElement().getChild("rules");

        for (Element ruleElement : rules.getChildren("rule")) {

            Propositions majors = new Propositions();
            for (Element majorElement : ruleElement.getChild("majors").getChildren("major")) {
                majors.add(this.propositions.getById(majorElement.getAttribute("proposition").getIntValue()));
            }

            Proposition conclusion = this.propositions.getById(ruleElement.getChild("conclusion").getAttribute("proposition").getIntValue());

            Rule rule = new Rule(majors, conclusion);
            this.rules.add(rule);
        }
        return this.rules;
    }

    public Propositions readTruth() {
        Propositions truth = new Propositions();
        List<Element> truthElements = this.document.getRootElement().getChild("truth").getChildren("proposition");
        for (Element element : truthElements) {
            try {
                truth.add(this.propositions.getById(element.getAttribute("id").getIntValue()));
            } catch (DataConversionException e) {
                System.out.println("Impossible de convertir " + element.getAttribute("id") + " en int");
                System.exit(1);
            }
        }
        return truth;
    }
}
