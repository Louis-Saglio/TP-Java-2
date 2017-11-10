package launch;

import java.sql.*;

public class Test01_Monolithique {

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/heritage",
                    "root",
                    "159753Ukicz!"
            );
            Statement statement = con.createStatement();
            String sql = "SELECT nomProduit, nomCategorie, prixProduit, codeProduit " +
                         "FROM Categorie " +
                         "JOIN Produit USING (codeCategorie)";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                String nomProduit = rs.getString("nomProduit");
                String nomCategorie = rs.getString("nomCategorie");
                float prixProduit = rs.getFloat("prixProduit");
                int codeProduit = rs.getInt("codeProduit");
                System.out.println("- " + codeProduit + " " + nomProduit + " : " + prixProduit + "€  (" + nomCategorie + ")");
            }
        } catch (SQLException exc) {
            System.err.println(exc.getMessage());
        }
    }
}
