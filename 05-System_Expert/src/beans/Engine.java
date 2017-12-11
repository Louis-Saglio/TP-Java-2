package beans;

import java.util.ArrayList;

public class Engine {

    private ArrayList<Fact> reality;
    private ArrayList<Fact> potentialFacts;
    private ArrayList<Fact> error;
    private ArrayList<Rule> rules;

    private Engine() {
        ArrayList<Property> properties = Property.init();
        this.potentialFacts = Fact.init(properties);
        this.createReality();
        this.createError();
        this.createRules();
    }

    private void createReality() {
        this.reality = new ArrayList<>();
        this.reality.add(this.potentialFacts.get(0));
        this.reality.add(this.potentialFacts.get(1));
        this.reality.add(this.potentialFacts.get(this.potentialFacts.size() - 1));
    }

    private void createError() {
        this.error = new ArrayList<>();
//        this.error.add(potentialFacts.get(1));
    }

    private void createRules() {
        this.rules = new ArrayList<>();

        ArrayList<Fact> facts1 = new ArrayList<>();
        facts1.add(this.potentialFacts.get(0));
        facts1.add(this.potentialFacts.get(1));
        Rule rule1 = new Rule(facts1, this.potentialFacts.get(0));
        this.rules.add(rule1);
    }

    public void scanRules() {
        System.out.println("\nScan des règles...\n");
        ArrayList<Rule> falseRules = new ArrayList<>();
        for (Rule rule : rules) {
            AnswerEnum answer = rule.scan(reality, error);
            if (answer == AnswerEnum.True) {
                System.out.println("On ajoute " + rule.getConclusion() + " à la liste des faits vrais");
                reality.add(rule.getConclusion());
            } else if (answer == AnswerEnum.False) {
                System.out.println("La règle " + rule + " ne sera jamais vraie");
                falseRules.add(rule);
            }
        }
        rules.removeAll(falseRules);
    }

    public static void main(String[] args) {
        Engine engine = new Engine();
        System.out.println("Liste des faits potentiels");
        System.out.println(engine.potentialFacts);
        System.out.println("\nListe des faits réels");
        System.out.println(engine.reality);
        System.out.println("\nListe des faits faux");
        System.out.println(engine.error);
        System.out.println("\nListe des règles");
        System.out.println(engine.rules);
        engine.scanRules();
        System.out.println("\nListe des faits réels");
        System.out.println(engine.reality);
        System.out.println("\nListe des faits faux");
        System.out.println(engine.error);
        System.out.println("\nListe des règles");
        System.out.println(engine.rules);
    }

}
