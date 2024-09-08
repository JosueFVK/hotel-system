package trabalho5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HospedagemDAO {
	
	private Connection connection;

    public HospedagemDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Hospedagem hospedagem) {
        String sql = "INSERT INTO Hospedagem (codCliente, codChale, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, hospedagem.getCodCliente());
            stmt.setInt(2, hospedagem.getCodChale());
            stmt.setString(3, hospedagem.getDataInicio());
            stmt.setString(4, hospedagem.getDataFim());
            stmt.setInt(5, hospedagem.getQtdPessoas());
            stmt.setDouble(6, hospedagem.getDesconto());
            stmt.setDouble(7, hospedagem.getValorFinal());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
