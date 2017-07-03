package views;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

import javax.swing.JButton;
import java.awt.FlowLayout;

public class WinComponent extends JPanel {
	private JButton playAgainButton;
	private JButton savaButton;
	private JLabel txtStatus;
	public WinComponent() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		txtStatus = new JLabel();
		GridBagConstraints gbc_txtStatus = new GridBagConstraints();
		gbc_txtStatus.insets = new Insets(0, 0, 5, 5);
		gbc_txtStatus.gridx = 1;
		gbc_txtStatus.gridy = 1;
		add(txtStatus, gbc_txtStatus);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		playAgainButton = new JButton("Jogar de novo");
		panel.add(playAgainButton);
		
		savaButton = new JButton("Salvar arvore");
		panel.add(savaButton);
	}

	public void addSaveListener(Consumer<ActionEvent> listener) {
		savaButton.addActionListener(listener::accept);
	}
	
	public void addPlayAgainListener(Consumer<ActionEvent> listener) {
		playAgainButton.addActionListener(listener::accept);
	}

	public void lose() {
		updateStatus(false);
	}
	
	public void won() {
		updateStatus(true);
	}
	
	private void updateStatus(boolean won) {
		if (won) {
			txtStatus.setText("Acertei!");
		} else {
			txtStatus.setText("Obrigado por adicionar mais conhecimento!");
		}
	}
}
