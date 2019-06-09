package usandoSQLiteComJava;

import java.sql.*;

public class SQLiteJDBCDriverConnection {
	private static void connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {

            System.out.println("Conexão realizada !!!!");

            Statement statement = connection.createStatement();

            // criando uma tabela
            statement.execute("CREATE TABLE IF NOT EXISTS RC_TEST( ID INTEGER, NOME VARCHAR )");

            // inserindo registros
            statement.execute("INSERT INTO RC_TEST( ID, NOME) VALUES (1, 'Rubens'), (2, 'Rubenito')");

            // lendo os registros
            PreparedStatement stmt = connection.prepareStatement("select * from RC_TEST");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");

                System.out.println( id + " - " + nome);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
