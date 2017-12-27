package facts;

public class Proposition {

    private Fact fact;
    private boolean state;
    private int id;

    public Proposition(Fact fact, boolean state, int id) {
        this.fact = fact;
        this.state = state;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Proposition{"  + fact + " est " + state +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public Propositions getContraries() {
        Propositions propositions = new Propositions();
        for (Fact contrary : this.fact.getContraries()) {
            propositions.add(new Proposition(contrary, true, (int) (Math.random() * 999999)));
//          todo: auto incrément curseur static
        }
        return propositions;
    }
}
