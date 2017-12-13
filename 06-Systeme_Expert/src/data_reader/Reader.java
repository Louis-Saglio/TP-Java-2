package data_reader;

import facts.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;

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

    public Rules readRules() {
        for (Element rule : this.document.getRootElement().getChild("rules").getChildren("rule")) {
            System.out.println(rule);
        }
        return rules;
    }
}
