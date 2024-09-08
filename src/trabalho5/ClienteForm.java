package trabalho5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteForm extends JFrame {

    private static final long serialVersionUID = 1L; // Adicionando serialVersionUID

    private JTextField nomeField;
    private JTextField rgField;
    private JTextField enderecoField;
    private JTextField bairroField;
    private JTextField cidadeField;
    private JTextField estadoField;
    private JTextField cepField;
    private JButton salvarButton;

    public ClienteForm() {
        setTitle("Cadastro de Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        nomeField = new JTextField(20);
        rgField = new JTextField(20);
        enderecoField = new JTextField(20);
        bairroField = new JTextField(20);
        cidadeField = new JTextField(20);
        estadoField = new JTextField(2);
        cepField = new JTextField(8);
        salvarButton = new JButton("Salvar");

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("RG:"));
        add(rgField);
        add(new JLabel("Endereço:"));
        add(enderecoField);
        add(new JLabel("Bairro:"));
        add(bairroField);
        add(new JLabel("Cidade:"));
        add(cidadeField);
        add(new JLabel("Estado:"));
        add(estadoField);
        add(new JLabel("CEP:"));
        add(cepField);
        add(salvarButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.setNomeCliente(nomeField.getText());
                cliente.setRgCliente(rgField.getText());
                cliente.setEnderecoCliente(enderecoField.getText());
                cliente.setBairroCliente(bairroField.getText());
                cliente.setCidadeCliente(cidadeField.getText());
                cliente.setEstadoCliente(estadoField.getText());
                cliente.setCEPCliente(cepField.getText());

                ClienteDAO dao = new ClienteDAO();
                dao.adiciona(cliente);

                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
            }
        });
    }

    public static void main(String[] args) {
        ClienteForm form = new ClienteForm();
        form.setVisible(true);
    }
}
