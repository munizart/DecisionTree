package structures;

import java.io.Serializable;

public class DecisionTree implements Serializable {
	private static final long serialVersionUID = -1022367217804723322L;
	
	private DecisionTree no;
	private DecisionTree yes;
	private String value;
	
	public DecisionTree (String initialChoice) {
		this.value = initialChoice;
	}
	
	public boolean isLeaf () {
		return this.yes == null && this.no == null;
	}
	
	public void addSplit (String question, String yesChoice, String noChoice) {
		this.value = question;
		this.no = new DecisionTree(noChoice);
		this.yes = new DecisionTree(yesChoice);
	}
	
	public String value () {
		return value;
	}

	public DecisionTree no () {
		return no;
	}
	
	public DecisionTree yes () {
		return yes;
	}
}
