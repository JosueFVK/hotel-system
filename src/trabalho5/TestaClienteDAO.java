package trabalho5;

//import java.time.LocalDate;

public class TestaClienteDAO {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
        cliente.setNomeCliente("Jose ");
        cliente.setRgCliente("987654321");
        cliente.setEnderecoCliente("Rua B, 456");
        cliente.setBairroCliente("Oeste");
        cliente.setCidadeCliente("São Paulo");
        cliente.setEstadoCliente("SP");
        cliente.setCEPCliente("01001-342");
       
        ClienteDAO dao = new ClienteDAO();
        dao.adiciona(cliente);

        System.out.println("Cliente inserido com sucesso!");
	}

}
