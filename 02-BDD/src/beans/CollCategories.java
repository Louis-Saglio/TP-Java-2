package beans;

import connectors.MariaDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CollCategories extends ArrayList<Categorie> {

    private int curseur = 0;

    public CollCategories() {
        MariaDB mariaDB = new MariaDB("heritage");
        ResultSet resultSet = mariaDB.requete("SELECT * FROM Categorie;");
        try {
            while (resultSet.next()) {
                Categorie categorie = new Categorie(
                        resultSet.getInt("codeCategorie"),
                        resultSet.getString("nomCategorie")
                );
                this.add(categorie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getCurseur() {
        return curseur;
    }

    public void setCurseur(int curseur) {
        if (curseur < this.size() && curseur >= 0) {
            this.curseur = curseur;
        }
    }

    public Categorie CategorieCourrante(){
        return this.get(this.curseur);
    }

    public boolean estPremier() {
        return this.curseur == 0;
    }

    public boolean estDernier() {
        return this.curseur == this.size() - 1;
    }

    public String infoCurseur() {
        return "Enregistrement " + (this.curseur + 1) + " / " + (this.size());
    }

    public void suivant() {
        this.setCurseur(curseur + 1);
    }

    public void precedent() {
        this.setCurseur(curseur - 1);
    }

    public void debut() {
        this.setCurseur(0);
    }

    public void fin() {
        this.setCurseur(this.size() - 1);
    }

}
