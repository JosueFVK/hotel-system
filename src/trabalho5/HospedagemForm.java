package trabalho5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospedagemForm  extends JFrame{
	
	private static final long serialVersionUID = 1L;

    private JTextField codClienteField;
    private JTextField codChaleField;
    private JTextField dataInicioField;
    private JTextField dataFimField;
    private JTextField qtdPessoasField;
    private JTextField descontoField;
    private JTextField valorFinalField;
    private JButton salvarButton;

    public HospedagemForm() {
        setTitle("Cadastro de Hospedagem");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        codClienteField = new JTextField(5);
        codChaleField = new JTextField(5);
        dataInicioField = new JTextField(10);
        dataFimField = new JTextField(10);
        qtdPessoasField = new JTextField(5);
        descontoField = new JTextField(10);
        valorFinalField = new JTextField(10);
        salvarButton = new JButton("Salvar");

        add(new JLabel("Código Cliente:"));
        add(codClienteField);
        add(new JLabel("Código Chale:"));
        add(codChaleField);
        add(new JLabel("Data Início:"));
        add(dataInicioField);
        add(new JLabel("Data Fim:"));
        add(dataFimField);
        add(new JLabel("Quantidade de Pessoas:"));
        add(qtdPessoasField);
        add(new JLabel("Desconto:"));
        add(descontoField);
        add(new JLabel("Valor Final:"));
        add(valorFinalField);
        add(salvarButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setCodCliente(Integer.parseInt(codClienteField.getText()));
                hospedagem.setCodChale(Integer.parseInt(codChaleField.getText()));
                hospedagem.setDataInicio(dataInicioField.getText());
                hospedagem.setDataFim(dataFimField.getText());
                hospedagem.setQtdPessoas(Integer.parseInt(qtdPessoasField.getText()));
                hospedagem.setDesconto(Double.parseDouble(descontoField.getText()));
                hospedagem.setValorFinal(Double.parseDouble(valorFinalField.getText()));

                HospedagemDAO dao = new HospedagemDAO();
                dao.adiciona(hospedagem);

                JOptionPane.showMessageDialog(null, "Hospedagem salva com sucesso!");
            }
        });
    }

}
