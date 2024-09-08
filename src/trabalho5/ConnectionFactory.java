package trabalho5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	 public Connection getConnection() {
	        try {
	            return DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/sistema_hospedagem", "root", "Mexico0503@");
	        } catch (SQLException e) {
	            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
	        }
	    }

}
