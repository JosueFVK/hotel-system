package trabalho5;

public class TestaHospedagemDAO {
	public static void main(String[] args) {
		Hospedagem hospedagem = new Hospedagem();
        hospedagem.setCodCliente(1); // Certifique-se de que esse cliente existe no banco
        hospedagem.setCodChale(1);   // Certifique-se de que esse chale existe no banco
        hospedagem.setDataInicio("2024-10-01");
        hospedagem.setDataFim("2024-10-07");
        hospedagem.setQtdPessoas(2);
        hospedagem.setDesconto(10.0);
        hospedagem.setValorFinal(1400.0);

        HospedagemDAO dao = new HospedagemDAO();
        dao.adiciona(hospedagem);

        System.out.println("Hospedagem inserida com sucesso!");
	}

}
