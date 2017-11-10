package connectors;

import java.sql.*;
import java.util.Objects;

public class MariaDB {

    private Connection connection;
    private Statement statement;

    public MariaDB(String baseName) {
        this("127.0.0.1", baseName, "root", "159753Ukicz!");
    }

    public MariaDB(String ipServeur, String baseName, String login, String password) {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://" + ipServeur + ":3306/" + baseName,
                    login,
                    password
            );
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isTableName(String dataBase) throws SQLException {
        DatabaseMetaData databaseMetaData = this.connection.getMetaData();
        ResultSet rs = databaseMetaData.getTables(null, null, "%", null);
        while (rs.next()){
            String tableName = rs.getString(3);
            if (Objects.equals(dataBase, tableName))
                return true;
        }
        return false;
    }

    public ResultSet requete(String sql) {
        try {
            if (this.isTableName(sql))
                sql = "SELECT * FROM " + sql;
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public int update(String sql) throws SQLException {
        return this.statement.executeUpdate(sql);
    }

    public int insereAI(String sql) throws SQLException {
        this.statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public String printProduit(ResultSet resultSet) throws SQLException {
        String rep = "";
        while (resultSet.next()){
            int codeProduit = resultSet.getInt("codeProduit");
            String nomProduit = resultSet.getString("nomProduit");
            float prix = resultSet.getFloat("prixProduit");
            int categorie = resultSet.getInt("codeCategorie");
            rep += "- [" + codeProduit + "] " + nomProduit + " : " + prix + "€ categorie [" + categorie + "]\n";
        }
        return rep;
    }

}
