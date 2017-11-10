package launch;

import java.sql.*;

@SuppressWarnings("ALL")
public class Test02_Monolithique {

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
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int nbChamps = resultSetMetaData.getColumnCount();
            System.out.println("Trouvé " + nbChamps + " champs");
            for (int i = 1; i <=nbChamps ; i++) {
                String nomChamps = resultSetMetaData.getColumnName(i);
                String typeChamps = resultSetMetaData.getColumnTypeName(i);
                int tailleColonne = resultSetMetaData.getColumnDisplaySize(i);
                boolean isAutoIncrement = resultSetMetaData.isAutoIncrement(i);
                System.out.println("- " + nomChamps + " de type " + typeChamps + "(" + tailleColonne + ") " + (isAutoIncrement?"A_i":""));
            }
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
