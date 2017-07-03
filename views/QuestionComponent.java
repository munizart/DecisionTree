package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class QuestionComponent extends JPanel {

	public Consumer<String> updateQuestion;
	public Consumer<ActionListener> addNoListener;
	public Consumer<ActionListener> addYesListener;
	
	public QuestionComponent() {
		setBorder(null);
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 247, 247, 30, 0};
		gridBagLayout.rowHeights = new int[]{150, 50, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblQuestion = new JLabel();
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
		gbc_lblQuestion.fill = GridBagConstraints.BOTH;
		gbc_lblQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuestion.gridwidth = 2;
		gbc_lblQuestion.gridx = 1;
		gbc_lblQuestion.gridy = 0;
		add(lblQuestion, gbc_lblQuestion);
		
		JButton btnYes = new JButton("SIM");
		GridBagConstraints gbc_btnYes = new GridBagConstraints();
		gbc_btnYes.fill = GridBagConstraints.BOTH;
		gbc_btnYes.insets = new Insets(0, 0, 5, 5);
		gbc_btnYes.gridx = 1;
		gbc_btnYes.gridy = 1;
		add(btnYes, gbc_btnYes);


		JButton btnNo = new JButton("NÃO");
		GridBagConstraints gbc_btnNo = new GridBagConstraints();
		gbc_btnNo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNo.fill = GridBagConstraints.BOTH;
		gbc_btnNo.gridx = 2;
		gbc_btnNo.gridy = 1;
		add(btnNo, gbc_btnNo);
		
		this.updateQuestion = lblQuestion::setText;
		this.addNoListener = btnNo::addActionListener;
		this.addYesListener = btnYes::addActionListener;

	}

	
}
