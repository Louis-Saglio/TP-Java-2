package beans;

public class SecondCycle extends Etudiant {

    private Support support;

    public SecondCycle(String nom, long id, String matiere, int annee, Support support) {
        super(nom, id, matiere, annee);
        this.support = support;
    }

    @Override
    public String toString() {
        return super.toString() + " support: " + this.support + ";";
    }

    @Override
    public String getClassName() {
        return "SecondCycle";
    }
}
