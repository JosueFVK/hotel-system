package trabalho5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChaleForm extends JFrame {
	
	private static final long serialVersionUID = 1L;

    private JTextField localizacaoField;
    private JTextField capacidadeField;
    private JTextField valorAltaEstacaoField;
    private JTextField valorBaixaEstacaoField;
    private JButton salvarButton;

    public ChaleForm() {
        setTitle("Cadastro de Chale");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        localizacaoField = new JTextField(20);
        capacidadeField = new JTextField(5);
        valorAltaEstacaoField = new JTextField(10);
        valorBaixaEstacaoField = new JTextField(10);
        salvarButton = new JButton("Salvar");

        add(new JLabel("Localização:"));
        add(localizacaoField);
        add(new JLabel("Capacidade:"));
        add(capacidadeField);
        add(new JLabel("Valor Alta Estação:"));
        add(valorAltaEstacaoField);
        add(new JLabel("Valor Baixa Estação:"));
        add(valorBaixaEstacaoField);
        add(salvarButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chale chale = new Chale();
                chale.setLocalizacao(localizacaoField.getText());
                chale.setCapacidade(Integer.parseInt(capacidadeField.getText()));
                chale.setValorAltaEstacao(Double.parseDouble(valorAltaEstacaoField.getText()));
                chale.setValorBaixaEstacao(Double.parseDouble(valorBaixaEstacaoField.getText()));

                ChaleDAO dao = new ChaleDAO();
                dao.adiciona(chale);

                JOptionPane.showMessageDialog(null, "Chale salvo com sucesso!");
            }
        });
    }

}
