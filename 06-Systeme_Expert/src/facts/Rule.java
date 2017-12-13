package facts;

public class Rule {

    private Propositions majors;
    private Proposition conclusion;

    @Override
    public String toString() {
        return "Rule{" +
                "majors=" + majors +
                ", conclusion=" + conclusion +
                '}';
    }

    public Rule(Propositions majors, Proposition conclusion) {
        this.majors = majors;
        this.conclusion = conclusion;
    }
}
