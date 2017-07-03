package models;

import java.util.ArrayList;
import java.util.function.Consumer;

import structures.DecisionTree;

public class TreeModel {
	private DecisionTree tree;
	private ArrayList<Consumer<TreeModel>> listeners = new ArrayList<>();
	
	public void init(DecisionTree state) {
		this.tree = state;
		notifyListeners();
	}
	
	public void yes() {
		this.tree = this.tree.yes();
		notifyListeners();
	}
	
	public void no() {
		this.tree = this.tree.no();
		notifyListeners();
	}
	
	public boolean isQuestion() {
		return !this.tree.isLeaf();
	}
	
	public String getValue() {
		return tree.value();
	}
	
	public void addQuestion (String question, String yes, String no) {
		if (!this.isQuestion()) {
			this.tree.addSplit(question, yes, no);
		}
	}
	
	public void addChangeListener(Consumer<TreeModel> listener) {
		this.listeners.add(listener);
	}
	
	public void notifyListeners() {
		this.listeners.forEach(l -> l.accept(this));
	}
}
