package trabalho5;

public class Hospedagem {
    private int codHospedagem;
    private int codCliente;  // Foreign Key para Cliente
    private int codChale;    // Foreign Key para Chale
    private String dataInicio;
    private String dataFim;
    private int qtdPessoas;
    private double desconto;
    private double valorFinal;
	public int getCodHospedagem() {
		return codHospedagem;
	}
	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCodChale() {
		return codChale;
	}
	public void setCodChale(int codChale) {
		this.codChale = codChale;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public int getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
    
    
    
}