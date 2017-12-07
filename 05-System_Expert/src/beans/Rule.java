package beans;

import java.util.ArrayList;

public class Rule {

    private ArrayList<Fact> facts;
    private Fact conclusion;

    public Rule(ArrayList<Fact> facts, Fact conclusion) {
        this.facts = facts;
        this.conclusion = conclusion;
    }

    public AnswerEnum scan(ArrayList<Fact> reality, ArrayList<Fact> error) {
        for (Fact fact : facts) {
            for (Fact contrary : fact.getContraries()) {
                System.out.println(contrary);
                if (reality.contains(contrary)) {
                    System.out.println(fact.getProperty().getName() + " n'est pas " + fact.getValue() + " mais " + contrary.getValue());
                    return AnswerEnum.False;
                }
            }
            if (error.contains(fact)) {
                System.out.println(
                        "La majeure : \"" + fact.getProperty().getName() + " du sujet est " + fact.getValue() + "\" est fausse"
                );
                return AnswerEnum.False;
            } else if (!reality.contains(fact)) {
                System.out.println(
                        "La majeure : " + fact.getProperty().getName() + " du sujet est " + fact.getValue() + " est indéterminée"
                );
                return AnswerEnum.Unknown;
            }
        }
        System.out.println("Toute les majeures de cette règle sont vraies");
        return AnswerEnum.True;
    }

    public Fact getConclusion() {
        return conclusion;
    }

    public ArrayList<Rule> init(ArrayList<Fact> facts) {
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(new Rule(facts, facts.get(0)));
        return rules;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "facts=" + facts +
                ", conclusion=" + conclusion +
                '}';
    }
}
