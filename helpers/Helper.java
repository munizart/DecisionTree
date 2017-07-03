package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import structures.DecisionTree;

public class Helper {

	public static void save(DecisionTree tree, File path) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(path);
		ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
		
		objStream.writeObject(tree);
		objStream.close();
		
		fileStream.close();
		
	}
	
	public static DecisionTree load(File file) throws IOException, ClassNotFoundException {
		FileInputStream fileStream = new FileInputStream(file);
		ObjectInputStream objStream = new ObjectInputStream(fileStream);
		
		return (DecisionTree) objStream.readObject();
	}

}
