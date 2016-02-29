package interfaces.u6.capitals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import interfaces.bca.util.BCAArrayList;
import interfaces.bca.util.BCAList;

public class StateCapitalQuiz {

	public static BCAList loadStateList(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(fileName));
		BCAList list = new BCAArrayList();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] split = line.split("\t");
			StateCapital sc = new StateCapital(split[0], split[1]);
			list.add(sc);
		}
		in.close();
		return list;
	}

	/**
	 * This method runs the quiz. It does the following:<BR>
	 * 1) Asks the user to select a data file.<BR>
	 * 2) Creates a new StateCapitalList object using this file.<BR>
	 * 3) Loops until no states left or user presses cancel<BR>
	 * <tab> a) Getting a random state<BR>
	 * <tab> b) Asking the user the capital of the state.<BR>
	 * <tab> c) Removes the state if the user answer correctly.<BR>
	 * 
	 * Need GUI Help?<BR>
	 * Check out the following pages in the textbook: 55-56, 98-99, and 139-140.
	 * <BR>
	 * Review your code from the Rock, Paper, Scissors assignment. <BR>
	 * Finally, to use combo boxes, check out the Java API for JOptionPane.
	 * Review the six provided examples until you find exactly what you need.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		JOptionPane.showMessageDialog(null, "Welcome to the State Quiz Challenge!");
 
		Object[] possibleValues = { "states_small_test.txt", "states_all.txt", "states_central.txt", "states_east.txt",
				"states_west.txt", "states_south.txt" };

		String selectedFile = (String) JOptionPane.showInputDialog(null, "Which quiz file would you like to use?",
				"Input", JOptionPane.QUESTION_MESSAGE, null, possibleValues, possibleValues[0]);

		BCAList list = loadStateList(selectedFile);
		Random rand = new Random();

		int totalGuesses = 0;
		int correctCount = 0;
		String guess = "";
		while ((guess != null) && !list.isEmpty()) {
			int stateIndex = rand.nextInt(list.size());
			StateCapital sc = (StateCapital) list.get(stateIndex);

			guess = (String) JOptionPane.showInputDialog("What is the capital of " + sc.getState() + "?");

			String msg = "";
			if (guess != null) {
				totalGuesses++;

				if (guess.equalsIgnoreCase(sc.getCapital())) {
					correctCount++;
					msg = "Correct!";
					list.remove(stateIndex);
				} else {
					msg = "Incorrect. The capital is " + sc.getCapital();
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		}

		JOptionPane.showMessageDialog(null, "You named " + correctCount + " capitals in " + totalGuesses + " guesses.");
	}

}
