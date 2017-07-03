package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;

import helpers.Helper;
import models.TreeModel;
import structures.DecisionTree;

public class MainComponent extends JFrame {

	private TreeModel model;

	private DecisionTree initialTree;
	
	public MainComponent() {
		getContentPane().setBackground(Color.WHITE);
		this.model = new TreeModel();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(375,280);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel cardPanel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		getContentPane().add(cardPanel, gbc_panel);
		cardPanel.setLayout(new CardLayout(0, 0));
		
		CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
		
		QuestionComponent questionComponent = new QuestionComponent();
		cardPanel.add(questionComponent, "questionPage");
		
		NewKnowlageComponent knowlageComponent = new NewKnowlageComponent();
		cardPanel.add(knowlageComponent, "knowlagePage");
		
		WinComponent win = new WinComponent();
		cardPanel.add(win, "winLosePage");
		

		Consumer<TreeModel> updateQuestion = (updatedModel) -> {
			String question = updatedModel.isQuestion() ? updatedModel.getValue() : "Voce pensou em: " + updatedModel.getValue();
			questionComponent.updateQuestion.accept(question);
		};
		
		model.addChangeListener(updateQuestion.andThen(this::updateModel));

		questionComponent.addNoListener.accept(e -> {
			if (this.model.isQuestion()) {
				this.model.no();
			} else {
				knowlageComponent.updateThing(this.model.getValue());
				cardLayout.show(cardPanel, "knowlagePage");
			}
		});
		
		questionComponent.addYesListener.accept(e -> {
			if (this.model.isQuestion()) {
				this.model.yes();
			} else {
				win.won();
				cardLayout.show(cardPanel, "winLosePage");
			}
		});
		
		knowlageComponent.addListener(event -> {
			model.addQuestion(event.get("question"), event.get("yes"), event.get("no"));
			
			win.lose();
			cardLayout.show(cardPanel, "winLosePage");
		});
		
		win.addPlayAgainListener(e -> {
			this.model.init(this.initialTree);
			cardLayout.show(cardPanel, "questionPage");
		});
		
		win.addSaveListener(e -> {
			JFileChooser chooser = getFileChooser();
			int chooserState = chooser.showSaveDialog(this);
			if (chooserState == JFileChooser.APPROVE_OPTION) {
				try {
					Helper.save(initialTree, chooser.getSelectedFile());
				} catch (IOException e1) {
					popUpException(e1);
				}
			}
		});
		
		this.model.init(getInitialTree());
		
		JOptionPane.showMessageDialog(this, "Pense em uma coisa");
		
		setVisible(true);
	}
	
	private void popUpException(Exception e) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getLocalizedMessage());
	}

	private DecisionTree getInitialTree() {
		int response = JOptionPane.showOptionDialog(this, "Deseja carregar uma arvore salva?", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (response == JOptionPane.YES_OPTION) {
			try {
				this.initialTree = getTreeFromFile();
			} catch (ClassNotFoundException | IOException e) {
				popUpException(e);
				this.initialTree = getInitialTree();
			}
		}
		
		if (response == JOptionPane.NO_OPTION) {
			this.initialTree = getTreeFromJPanel();
		}
		
		if (this.initialTree == null) {
			this.initialTree = new DecisionTree(null);
			Timer t = new Timer(10, (e) -> {
				WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
				getToolkit().getSystemEventQueue().postEvent(wev);
				setVisible(false);
				dispose();
			});
			t.setRepeats(false);
			t.start();
		}
		
		return this.initialTree;
	}

	private DecisionTree getTreeFromJPanel() {
		String initialValue = JOptionPane.showInputDialog(null, "Digite o valor inicial", "Nova arvore", JOptionPane.QUESTION_MESSAGE);
		if (initialValue == null) {
			return getInitialTree();
		} else {
			return new DecisionTree(initialValue);	
		} 
	}

	private DecisionTree getTreeFromFile() throws ClassNotFoundException, IOException {
		JFileChooser chooser = getFileChooser();
		int chooserState = chooser.showOpenDialog(this);
		
		if (chooserState == JFileChooser.APPROVE_OPTION) {
			return Helper.load(chooser.getSelectedFile());
		} else {
			return getTreeFromJPanel();
		}
	}

	private void updateModel(TreeModel model) {
		this.model = model;
	}
	
	private JFileChooser getFileChooser(){
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "Arvore de decisão";
			}
			@Override
			public boolean accept(File f) {
				return f.isFile() ? f.getName().endsWith(".tree") : true;
			}
		});
		
		return chooser;
	}
}
