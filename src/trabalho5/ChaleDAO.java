package trabalho5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChaleDAO {
	
	private Connection connection;

    public ChaleDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Chale chale) {
        String sql = "INSERT INTO Chale (localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, chale.getLocalizacao());
            stmt.setInt(2, chale.getCapacidade());
            stmt.setDouble(3, chale.getValorAltaEstacao());
            stmt.setDouble(4, chale.getValorBaixaEstacao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
