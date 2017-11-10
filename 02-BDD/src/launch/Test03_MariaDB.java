package launch;

import connectors.MariaDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test03_MariaDB {
    public static void main(String[] args) {
        MariaDB mariaDB = new MariaDB("heritage");
        try {

            // Test de requete (tableName)
            ResultSet selectedRows = mariaDB.requete("Produit");
            System.out.println(mariaDB.printProduit(selectedRows));

            // Test de requete (requete)
            selectedRows = mariaDB.requete("SELECT DISTINCT * FROM Produit WHERE nomProduit != 'test'");
            System.out.println(mariaDB.printProduit(selectedRows));

            // Test de update
            int nbrRowAffected = mariaDB.update(
                    "UPDATE Produit " +
                            "SET nomProduit = 'Nom modifié' " +
                            "WHERE codeProduit = 17;"
            );
            int nbrRowDeleted = mariaDB.update("DELETE FROM Produit WHERE nomProduit = 'insertion'");
            System.out.println("Nombre de ligne modifiée : " + (nbrRowAffected + nbrRowDeleted));

            // Test de insereAI
            int idInserted = mariaDB.insereAI("INSERT INTO Produit VALUES(null, 'insertion', 1, 55)");
            System.out.println("Produit insérée avec l'id :" + idInserted);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
