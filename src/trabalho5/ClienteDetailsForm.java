package trabalho5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDetailsForm extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField clienteIdField;
    private JButton mostrarButton;
    private JButton editarClienteButton;
    private JButton editarHospedagemButton;
    private JTextArea clienteDetailsArea;
    private JTextArea hospedagemDetailsArea;

    public ClienteDetailsForm() {
        setTitle("Detalhes do Cliente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("ID do Cliente:"));
        clienteIdField = new JTextField(10);
        topPanel.add(clienteIdField);
        mostrarButton = new JButton("Mostrar Detalhes");
        topPanel.add(mostrarButton);

        editarClienteButton = new JButton("Editar Cliente");
        topPanel.add(editarClienteButton);
        
        editarHospedagemButton = new JButton("Editar Hospedagem");
        topPanel.add(editarHospedagemButton);

        JPanel clientePanel = new JPanel();
        clientePanel.setLayout(new BorderLayout());
        clientePanel.setBorder(BorderFactory.createTitledBorder("Detalhes do Cliente"));
        clienteDetailsArea = new JTextArea(10, 50);
        clienteDetailsArea.setEditable(false);
        clienteDetailsArea.setLineWrap(true);
        clienteDetailsArea.setWrapStyleWord(true);
        clientePanel.add(new JScrollPane(clienteDetailsArea), BorderLayout.CENTER);

        JPanel hospedagemPanel = new JPanel();
        hospedagemPanel.setLayout(new BorderLayout());
        hospedagemPanel.setBorder(BorderFactory.createTitledBorder("Detalhes da Hospedagem"));
        hospedagemDetailsArea = new JTextArea(10, 50);
        hospedagemDetailsArea.setEditable(false);
        hospedagemDetailsArea.setLineWrap(true);
        hospedagemDetailsArea.setWrapStyleWord(true);
        hospedagemPanel.add(new JScrollPane(hospedagemDetailsArea), BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(clientePanel, BorderLayout.WEST);
        add(hospedagemPanel, BorderLayout.CENTER);

        mostrarButton.addActionListener(e -> mostrarDetalhes());
        editarClienteButton.addActionListener(e -> new EditClienteForm().setVisible(true));
        editarHospedagemButton.addActionListener(e -> new EditHospedagemForm().setVisible(true));
    }

    private void mostrarDetalhes() {
        int clienteId = Integer.parseInt(clienteIdField.getText());
        StringBuilder clienteDetails = new StringBuilder();
        StringBuilder hospedagemDetails = new StringBuilder();

        try (Connection connection = new ConnectionFactory().getConnection()) {
            // Buscar detalhes do cliente
            String sqlCliente = "SELECT * FROM Cliente WHERE codCliente = ?";
            PreparedStatement stmtCliente = connection.prepareStatement(sqlCliente);
            stmtCliente.setInt(1, clienteId);
            ResultSet rsCliente = stmtCliente.executeQuery();

            if (rsCliente.next()) {
                clienteDetails.append("Nome: ").append(rsCliente.getString("nomeCliente")).append("\n");
                clienteDetails.append("RG: ").append(rsCliente.getString("rgCliente")).append("\n");
                clienteDetails.append("Endereço: ").append(rsCliente.getString("enderecoCliente")).append("\n");
                clienteDetails.append("Bairro: ").append(rsCliente.getString("bairroCliente")).append("\n");
                clienteDetails.append("Cidade: ").append(rsCliente.getString("cidadeCliente")).append("\n");
                clienteDetails.append("Estado: ").append(rsCliente.getString("estadoCliente")).append("\n");
                clienteDetails.append("CEP: ").append(rsCliente.getString("CEPCliente")).append("\n");
            } else {
                clienteDetails.append("Cliente não encontrado.\n");
            }

            // Buscar detalhes das hospedagens
            String sqlHospedagem = "SELECT * FROM Hospedagem WHERE codCliente = ?";
            PreparedStatement stmtHospedagem = connection.prepareStatement(sqlHospedagem);
            stmtHospedagem.setInt(1, clienteId);
            ResultSet rsHospedagem = stmtHospedagem.executeQuery();

            boolean hasHospedagem = false;
            while (rsHospedagem.next()) {
                hasHospedagem = true;
                hospedagemDetails.append("Código Hospedagem: ").append(rsHospedagem.getInt("codHospedagem")).append("\n");
                hospedagemDetails.append("Código Chale: ").append(rsHospedagem.getInt("codChale")).append("\n");
                hospedagemDetails.append("Data Início: ").append(rsHospedagem.getString("dataInicio")).append("\n");
                hospedagemDetails.append("Data Fim: ").append(rsHospedagem.getString("dataFim")).append("\n");
                hospedagemDetails.append("Quantidade de Pessoas: ").append(rsHospedagem.getInt("qtdPessoas")).append("\n");
                hospedagemDetails.append("Desconto: ").append(rsHospedagem.getDouble("desconto")).append("\n");
                hospedagemDetails.append("Valor Final: ").append(rsHospedagem.getDouble("valorFinal")).append("\n\n");
            }

            if (!hasHospedagem) {
                hospedagemDetails.append("Nenhuma hospedagem encontrada para este cliente.\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            clienteDetails.append("Erro ao buscar detalhes: ").append(e.getMessage()).append("\n");
            hospedagemDetails.append("Erro ao buscar detalhes: ").append(e.getMessage()).append("\n");
        }

        clienteDetailsArea.setText(clienteDetails.toString());
        hospedagemDetailsArea.setText(hospedagemDetails.toString());
    }

    public static void main(String[] args) {
        ClienteDetailsForm form = new ClienteDetailsForm();
        form.setVisible(true);
    }
}
