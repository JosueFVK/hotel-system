package trabalho5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditClienteForm extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField idField;
    private JTextField nomeField;
    private JTextField rgField;
    private JTextField enderecoField;
    private JTextField bairroField;
    private JTextField cidadeField;
    private JTextField estadoField;
    private JTextField cepField;
    private JButton salvarButton;
    private JButton buscarButton;

    public EditClienteForm() {
        setTitle("Editar Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(10, 2, 5, 5));

        add(new JLabel("ID do Cliente:"));
        idField = new JTextField(10);
        add(idField);

        buscarButton = new JButton("Buscar");
        add(buscarButton);

        add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        add(nomeField);

        add(new JLabel("RG"));
        rgField = new JTextField(20);
        add(rgField);

        add(new JLabel("Endereço"));
        enderecoField = new JTextField(20);
        add(enderecoField);

        add(new JLabel("Bairro"));
        bairroField = new JTextField(20);
        add(bairroField);

        add(new JLabel("Cidade"));
        cidadeField = new JTextField(20);
        add(cidadeField);

        add(new JLabel("Estado"));
        estadoField = new JTextField(2);
        add(estadoField);

        add(new JLabel("CEP"));
        cepField = new JTextField(8);
        add(cepField);

        salvarButton = new JButton("Salvar");
        add(salvarButton);

        buscarButton.addActionListener(e -> buscarCliente());
        salvarButton.addActionListener(e -> salvarCliente());
    }

    private void buscarCliente() {
        int clienteId = Integer.parseInt(idField.getText());
        try (Connection connection = new ConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM Cliente WHERE codCliente = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, clienteId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nomeField.setText(rs.getString("nomeCliente"));
                rgField.setText(rs.getString("rgCliente"));
                enderecoField.setText(rs.getString("enderecoCliente"));
                bairroField.setText(rs.getString("bairroCliente"));
                cidadeField.setText(rs.getString("cidadeCliente"));
                estadoField.setText(rs.getString("estadoCliente"));
                cepField.setText(rs.getString("CEPCliente"));
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar cliente: " + e.getMessage());
        }
    }

    private void salvarCliente() {
        int clienteId = Integer.parseInt(idField.getText());
        String nome = nomeField.getText();
        String rg = rgField.getText();
        String endereco = enderecoField.getText();
        String bairro = bairroField.getText();
        String cidade = cidadeField.getText();
        String estado = estadoField.getText();
        String cep = cepField.getText();

        try (Connection connection = new ConnectionFactory().getConnection()) {
            String sql = "UPDATE Cliente SET nomeCliente = ?, rgCliente = ?, enderecoCliente = ?, bairroCliente = ?, cidadeCliente = ?, estadoCliente = ?, CEPCliente = ? WHERE codCliente = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, rg);
            stmt.setString(3, endereco);
            stmt.setString(4, bairro);
            stmt.setString(5, cidade);
            stmt.setString(6, estado);
            stmt.setString(7, cep);
            stmt.setInt(8, clienteId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma alteração realizada. Verifique o ID do cliente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EditClienteForm form = new EditClienteForm();
            form.setVisible(true);
        });
    }
}
