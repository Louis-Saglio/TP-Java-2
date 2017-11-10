package beans;


public class Etudiant {

    private String nom;
    private long id;
    private String matiere;
    private int annee;

    public Etudiant(String nom, long id, String matiere, int annee) {
        this.nom = nom;
        this.id = id;
        this.matiere = matiere;
        this.annee = annee;
    }

    public String getClassName(){
        return "Etudiant";
    }

    @Override
    public String toString() {
        return "[" + this.getClassName() + "] nom: " + this.nom + "; id: " + this.id + ";";
    }
}
