package beans;

import java.util.ArrayList;

public class Engine {

    private ArrayList<Fact> reality;
    private ArrayList<Fact> potentialFacts;
    private ArrayList<Rule> rules;

    public Engine() {
        this.potentialFacts = Fact.init();
        this.reality = new ArrayList<>();
        this.reality.add(this.potentialFacts.get(0));
        this.reality.add(this.potentialFacts.get(1));

        this.rules = new ArrayList<>();
    }

    public void scan() {
        ArrayList<Rule> falseRules = new ArrayList<>();
        for (Rule rule : rules) {
            AnswerEnum answer = rule.scan(reality);
            if (answer == AnswerEnum.True) {
                reality.add(rule.getConclusion());
            } else if (answer == AnswerEnum.False) {
                falseRules.add(rule);
            }
        }
        rules.removeAll(falseRules);
    }

    public static void main(String[] args) {

    }

}
