package trabalho5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
	private Connection connection;
	
	public ClienteDAO() {
         this.connection = new ConnectionFactory().getConnection();;
    }
	
	public void adiciona(Cliente cliente) {
		 String sql = "INSERT INTO Cliente (nomeCliente, rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, CEPCliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
		 try {
		        PreparedStatement stmt = connection.prepareStatement(sql);
		        stmt.setString(1, cliente.getNomeCliente());
		        stmt.setString(2, cliente.getRgCliente());
		        stmt.setString(3, cliente.getEnderecoCliente());
		        stmt.setString(4, cliente.getBairroCliente());
		        stmt.setString(5, cliente.getCidadeCliente());
		        stmt.setString(6, cliente.getEstadoCliente());
		        stmt.setString(7, cliente.getCEPCliente());

		        stmt.execute();
		        stmt.close();
		    } catch (SQLException e) {
		        throw new RuntimeException(e);
		    }
    }
	

}
