package facts;

public class Rule {

    private Propositions majors;
    private Proposition conclusion;

    public Rule(Propositions majors, Proposition conclusion) {
        this.majors = majors;
        this.conclusion = conclusion;
    }
}
