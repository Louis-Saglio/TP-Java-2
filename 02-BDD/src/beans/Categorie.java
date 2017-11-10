package beans;

public class Categorie {
    private int codeCategorie;
    private String nomCategorie;

    public Categorie(int codeCategorie, String nomCategorie) {
        this.codeCategorie = codeCategorie;
        this.nomCategorie = nomCategorie;
    }

    public int getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(int codeCategorie) {
        this.codeCategorie = codeCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Override
    public String toString() {
        return "[" + this.codeCategorie + "] " + this.nomCategorie;
    }
}
