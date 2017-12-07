package beans;

import java.util.ArrayList;

public class Rule {

    private ArrayList<Fact> facts;
    private Fact conclusion;

    public Rule(ArrayList<Fact> facts, Fact conclusion) {
        this.facts = facts;
        this.conclusion = conclusion;
    }

    public AnswerEnum scan(ArrayList<Fact> data) {
        for (Fact fact : facts) {
            if (!data.contains(fact)) {
                return AnswerEnum.Unknown;
            }
            for (Fact contrary : fact.getContraries()) {
                if (data.contains(contrary)) {
                    return AnswerEnum.False;
                }
            }
        }
        return AnswerEnum.True;
    }

    public Fact getConclusion() {
        return conclusion;
    }

    public ArrayList<Rule> init() {

        return null;
    }
}
