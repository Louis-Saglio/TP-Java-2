package beans;

public class PremierCycle extends Etudiant {

    public PremierCycle(String nom, long id, String matiere, int annee) {
        super(nom, id, matiere, annee);
    }

    @Override
    public String getClassName() {
        return "PremierCycle";
    }
}
