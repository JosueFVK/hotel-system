package trabalho5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditHospedagemForm extends JFrame{
	private static final long serialVersionUID = 1L;

    private JTextField idField;
    private JTextField clienteIdField;
    private JTextField chaleIdField;
    private JTextField dataInicioField;
    private JTextField dataFimField;
    private JTextField qtdPessoasField;
    private JTextField descontoField;
    private JTextField valorFinalField;
    private JButton salvarButton;
    private JButton buscarButton;

    public EditHospedagemForm() {
        setTitle("Editar Hospedagem");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 5, 5));

        add(new JLabel("ID da Hospedagem:"));
        idField = new JTextField(10);
        add(idField);

        buscarButton = new JButton("Buscar");
        add(buscarButton);

        add(new JLabel("ID do Cliente"));
        clienteIdField = new JTextField(10);
        add(clienteIdField);

        add(new JLabel("ID do Chalé"));
        chaleIdField = new JTextField(10);
        add(chaleIdField);

        add(new JLabel("Data Início"));
        dataInicioField = new JTextField(10);
        add(dataInicioField);

        add(new JLabel("Data Fim"));
        dataFimField = new JTextField(10);
        add(dataFimField);

        add(new JLabel("Quantidade de Pessoas"));
        qtdPessoasField = new JTextField(10);
        add(qtdPessoasField);

        add(new JLabel("Desconto"));
        descontoField = new JTextField(10);
        add(descontoField);

        add(new JLabel("Valor Final"));
        valorFinalField = new JTextField(10);
        add(valorFinalField);

        salvarButton = new JButton("Salvar");
        add(salvarButton);

        buscarButton.addActionListener(e -> buscarHospedagem());
        salvarButton.addActionListener(e -> salvarHospedagem());
    }

    private void buscarHospedagem() {
        int hospedagemId = Integer.parseInt(idField.getText());
        try (Connection connection = new ConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM Hospedagem WHERE codHospedagem = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, hospedagemId);
            var rs = stmt.executeQuery();

            if (rs.next()) {
                clienteIdField.setText(String.valueOf(rs.getInt("codCliente")));
                chaleIdField.setText(String.valueOf(rs.getInt("codChale")));
                dataInicioField.setText(rs.getString("dataInicio"));
                dataFimField.setText(rs.getString("dataFim"));
                qtdPessoasField.setText(String.valueOf(rs.getInt("qtdPessoas")));
                descontoField.setText(String.valueOf(rs.getDouble("desconto")));
                valorFinalField.setText(String.valueOf(rs.getDouble("valorFinal")));
            } else {
                JOptionPane.showMessageDialog(this, "Hospedagem não encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar hospedagem: " + e.getMessage());
        }
    }

    private void salvarHospedagem() {
        int hospedagemId = Integer.parseInt(idField.getText());
        int clienteId = Integer.parseInt(clienteIdField.getText());
        int chaleId = Integer.parseInt(chaleIdField.getText());
        String dataInicio = dataInicioField.getText();
        String dataFim = dataFimField.getText();
        int qtdPessoas = Integer.parseInt(qtdPessoasField.getText());
        double desconto = Double.parseDouble(descontoField.getText());
        double valorFinal = Double.parseDouble(valorFinalField.getText());

        try (Connection connection = new ConnectionFactory().getConnection()) {
            String sql = "UPDATE Hospedagem SET codCliente = ?, codChale = ?, dataInicio = ?, dataFim = ?, qtdPessoas = ?, desconto = ?, valorFinal = ? WHERE codHospedagem = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, clienteId);
            stmt.setInt(2, chaleId);
            stmt.setString(3, dataInicio);
            stmt.setString(4, dataFim);
            stmt.setInt(5, qtdPessoas);
            stmt.setDouble(6, desconto);
            stmt.setDouble(7, valorFinal);
            stmt.setInt(8, hospedagemId);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Hospedagem atualizada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao atualizar hospedagem: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EditHospedagemForm form = new EditHospedagemForm();
            form.setVisible(true);
        });
    }

}
