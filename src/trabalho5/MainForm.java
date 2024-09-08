package trabalho5;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainForm extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainForm() {
        setTitle("Sistema de Cadastro");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.LIGHT_GRAY);

        JButton clienteButton = new JButton("Cadastrar Cliente");
        JButton chaleButton = new JButton("Cadastrar Chale");
        JButton hospedagemButton = new JButton("Cadastrar Hospedagem");
        JButton detalhesButton = new JButton("Detalhes do Cliente");
        

        clienteButton.setBackground(Color.WHITE);
        chaleButton.setBackground(Color.WHITE);
        hospedagemButton.setBackground(Color.WHITE);

        panel.add(clienteButton);
        panel.add(chaleButton);
        panel.add(hospedagemButton);
        panel.add(detalhesButton);

        add(panel, BorderLayout.CENTER);

        clienteButton.addActionListener(e -> {
            ClienteForm clienteForm = new ClienteForm();
            clienteForm.setVisible(true);
        });

        chaleButton.addActionListener(e -> {
            ChaleForm chaleForm = new ChaleForm();
            chaleForm.setVisible(true);
        });

        hospedagemButton.addActionListener(e -> {
            HospedagemForm hospedagemForm = new HospedagemForm();
            hospedagemForm.setVisible(true);
        });
        
        detalhesButton.addActionListener(e -> {
            ClienteDetailsForm detailsForm = new ClienteDetailsForm();
            detailsForm.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainForm mainForm = new MainForm();
            mainForm.setVisible(true);
        });
    }
}
