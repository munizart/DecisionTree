package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewKnowlageComponent extends JPanel {
	private JTextField questionTextField;
	private JTextField thingTextField;
	private JLabel txtAwnser1;

	/**
	 * Create the panel.
	 */
	public NewKnowlageComponent() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNoQueVoc = new JLabel("No que você pensou?");
		GridBagConstraints gbc_lblNoQueVoc = new GridBagConstraints();
		gbc_lblNoQueVoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoQueVoc.gridx = 1;
		gbc_lblNoQueVoc.gridy = 1;
		add(lblNoQueVoc, gbc_lblNoQueVoc);
		lblNoQueVoc.setHorizontalAlignment(SwingConstants.LEFT);
		
		thingTextField = new JTextField();
		GridBagConstraints gbc_thingTextField = new GridBagConstraints();
		gbc_thingTextField.insets = new Insets(0, 0, 5, 5);
		gbc_thingTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_thingTextField.gridx = 1;
		gbc_thingTextField.gridy = 2;
		add(thingTextField, gbc_thingTextField);
		thingTextField.setColumns(10);
		
		JLabel lblQualADiferena = new JLabel("Formule uma pergunta que diferencie eles");
		GridBagConstraints gbc_lblQualADiferena = new GridBagConstraints();
		gbc_lblQualADiferena.insets = new Insets(0, 0, 5, 5);
		gbc_lblQualADiferena.gridx = 1;
		gbc_lblQualADiferena.gridy = 3;
		add(lblQualADiferena, gbc_lblQualADiferena);
		
		questionTextField = new JTextField();
		GridBagConstraints gbc_questionTextField = new GridBagConstraints();
		gbc_questionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_questionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_questionTextField.gridx = 1;
		gbc_questionTextField.gridy = 4;
		add(questionTextField, gbc_questionTextField);
		questionTextField.setColumns(10);
		
		JLabel lblExemplo = new JLabel("Exemplo:");
		GridBagConstraints gbc_lblExemplo = new GridBagConstraints();
		gbc_lblExemplo.insets = new Insets(0, 0, 5, 5);
		gbc_lblExemplo.anchor = GridBagConstraints.WEST;
		gbc_lblExemplo.gridx = 1;
		gbc_lblExemplo.gridy = 5;
		add(lblExemplo, gbc_lblExemplo);
		
		JLabel lblQuestion = new JLabel("Digite uma pergunta.");
		GridBagConstraints gbc_lblQuestion = new GridBagConstraints();
		gbc_lblQuestion.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuestion.gridx = 1;
		gbc_lblQuestion.gridy = 6;
		add(lblQuestion, gbc_lblQuestion);
		lblQuestion.setEnabled(false);
		
		JPanel awnser1Panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) awnser1Panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		awnser1Panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_awnser1Panel = new GridBagConstraints();
		gbc_awnser1Panel.insets = new Insets(0, 0, 5, 5);
		gbc_awnser1Panel.fill = GridBagConstraints.BOTH;
		gbc_awnser1Panel.gridx = 1;
		gbc_awnser1Panel.gridy = 7;
		add(awnser1Panel, gbc_awnser1Panel);
		
		JComboBox<String> y_n = new JComboBox<>();
		y_n.setModel(new DefaultComboBoxModel<>(new String[] {"Sim", "Não"}));
		y_n.setEditable(false);
		awnser1Panel.add(y_n);
		
		txtAwnser1 = new JLabel();
		awnser1Panel.add(txtAwnser1);
		
		JPanel awnser2Panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) awnser2Panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		awnser2Panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_awnser2Panel = new GridBagConstraints();
		gbc_awnser2Panel.insets = new Insets(0, 0, 5, 5);
		gbc_awnser2Panel.fill = GridBagConstraints.BOTH;
		gbc_awnser2Panel.gridx = 1;
		gbc_awnser2Panel.gridy = 8;
		add(awnser2Panel, gbc_awnser2Panel);
		
		JComboBox<String> n_y = new JComboBox<>();
		awnser2Panel.add(n_y);
		n_y.setModel(new DefaultComboBoxModel<>(new String[] {"Sim", "Não"}));
		n_y.setEditable(false);
		n_y.setEnabled(false);
		n_y.setSelectedItem("Não");
		
		JLabel txtAwnser2 = new JLabel();
		txtAwnser2.setText("Digite no que você pensou");
		awnser2Panel.add(txtAwnser2);
		txtAwnser2.setEnabled(false);
		
		JButton btnPronto = new JButton("Pronto");
		GridBagConstraints gbc_btnPronto = new GridBagConstraints();
		gbc_btnPronto.insets = new Insets(0, 0, 0, 5);
		gbc_btnPronto.gridx = 1;
		gbc_btnPronto.gridy = 9;
		add(btnPronto, gbc_btnPronto);
		btnPronto.setEnabled(false);
	
		ActionListener updateBnt = (e) -> {
			btnPronto.setEnabled(txtAwnser2.isEnabled() && lblQuestion.isEnabled());
		};
		
		questionTextField.addCaretListener(e -> {
			if (questionTextField.getText().isEmpty()) {
				lblQuestion.setText("Digite no que você pensou");
				lblQuestion.setEnabled(false);
			} else {
				lblQuestion.setText(questionTextField.getText());
				lblQuestion.setEnabled(true);
			}
			
			updateBnt.actionPerformed(null);
		});
		
		thingTextField.addCaretListener(e -> {
			if (thingTextField.getText().isEmpty()) {
				txtAwnser2.setText("Digite uma pergunta");
				txtAwnser2.setEnabled(false);
			} else {
				txtAwnser2.setText(thingTextField.getText());
				txtAwnser2.setEnabled(true);
			}
			
			updateBnt.actionPerformed(null);
		});
		
		y_n.addActionListener(e -> {
			if ("Sim".equals(y_n.getSelectedItem())) {
				n_y.setSelectedItem("Não");
			} else {
				n_y.setSelectedItem("Sim");
			}
		});
	
		
		btnPronto.addActionListener(e -> {
			Map<String, String> event = new HashMap<>();
			String awnser1 = txtAwnser1.getText();
			event.put("question", questionTextField.getText());			
			if ("Sim".equals(y_n.getSelectedItem())) {
				event.put("yes", awnser1);
				event.put("no", thingTextField.getText());
			} else {
				event.put("no", awnser1);
				event.put("yes", thingTextField.getText());
			}

			listeners.forEach(listener -> {
				listener.accept(event);
			});
		});
		
		this.updateThing = thing -> {
			txtAwnser1.setText(thing);
			thingTextField.setText("");
			questionTextField.setText("");
			txtAwnser2.setText("Digite uma pergunta");
			txtAwnser2.setEnabled(false);
			lblQuestion.setText("Digite no que você pensou");
			lblQuestion.setEnabled(false);
		};

	}
	
	private ArrayList<Consumer<Map<String, String>>> listeners = new ArrayList<>();
	
	private Consumer<String> updateThing;
	
	public void addListener(Consumer<Map<String, String>> listener) {
		listeners.add(listener);
	}
	
	public void updateThing(String thing) {
		this.updateThing.accept(thing);
	}

}
