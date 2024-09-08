package trabalho5;

public class TestaChaleDAO {
	public static void main(String[] args) {
		 Chale chale = new Chale();
	        chale.setLocalizacao("Chale 1");
	        chale.setCapacidade(4);
	        chale.setValorAltaEstacao(250.0);
	        chale.setValorBaixaEstacao(150.0);

	        ChaleDAO dao = new ChaleDAO();
	        dao.adiciona(chale);

	        System.out.println("Chale inserido com sucesso!");
	}

}
