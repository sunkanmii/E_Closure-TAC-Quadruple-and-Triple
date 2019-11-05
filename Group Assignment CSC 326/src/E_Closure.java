import java.util.Collections;
import java.util.LinkedList;

public class E_Closure {
	LinkedList<LinkedList<String>> states_1 = new LinkedList<LinkedList<String>>();

	static int number_of_states = 1;

	/**
	 * 
	 * Method to create Linked List for states. This is called first before any
	 * other method in this class
	 */
	public LinkedList<String>[] CreateLinkedLists() {
		LinkedList<String>[] states_2 = new LinkedList[number_of_states];

		for (int i = 0; i < number_of_states; i++) {
			states_2[i] = new LinkedList<String>();
		}

		for (int i = 0; i < number_of_states; i++) {
			states_2[i].add(Integer.toString(i));

			states_1.add(states_2[i]);
		}

		return states_2;
	}

	// Method to check user's alphabets
	public String StringChecker(String userAlphabet) {
		String newUserAlphabet = "";

		newUserAlphabet = userAlphabet.replace("*", "");
		newUserAlphabet = userAlphabet.replace("/", "");
		newUserAlphabet = userAlphabet.replace("(", "");
		newUserAlphabet = userAlphabet.replace(")", "");

		int alphabet_length = newUserAlphabet.length();
		boolean openBracket_inAlphabet = userAlphabet.contains("(");
		boolean asterisk_inAlphabet = userAlphabet.contains("*");
		boolean separator_inAlphabet = userAlphabet.contains("/");
		boolean asterisk_n_separator_inAlphabet = asterisk_inAlphabet && separator_inAlphabet;

		if (alphabet_length >= 1 && asterisk_n_separator_inAlphabet && openBracket_inAlphabet) {
			number_of_states = number_of_states + alphabet_length;
			return "case 6";
		} else if (alphabet_length >= 1 && separator_inAlphabet && openBracket_inAlphabet) {
			number_of_states = number_of_states + alphabet_length;
			return "case 5";
		} else if (alphabet_length > 1 && asterisk_n_separator_inAlphabet) {
			number_of_states = number_of_states + alphabet_length;
			return "case 4";
		}
		else if (alphabet_length > 1 && separator_inAlphabet) {
			number_of_states = number_of_states + alphabet_length + 2;
			return "case 3";
		} else if (alphabet_length >= 1 && asterisk_inAlphabet) {
			number_of_states = number_of_states + alphabet_length + 1;
			return "case 2";
		}
		else {
			number_of_states = number_of_states + alphabet_length;
			return "case 1";
		}
	}

	// Method to create default e-closure table
	public LinkedList<String>[] E_Closure_T(LinkedList<String>[] states) {
		for (int i = 1; i < states.length; i++) {
			for (int j = i; j < states.length; j++) {
				states[i - 1].add(Integer.toString(j));
			}
		}

		return states;
	}

	// Method that creates e-closure table
	public LinkedList<String>[] E_Closure_T(LinkedList<String>[] states, String userAlphabet) {

		E_Closure e_closure_obj = new E_Closure();

		String inputCase = e_closure_obj.StringChecker(userAlphabet);

		states = e_closure_obj.CreateLinkedLists();

		int states_length = states.length;

		if (inputCase.contains("1") == true) {
			// State remains the same
		}
		else if (inputCase.contains("2") == true) {
			int indexOfAsterisk = userAlphabet.indexOf("*");
			int thirdElementForAsterisk = indexOfAsterisk + 1;
			int lastElementForAsterisk = indexOfAsterisk + 2;

			for (int i = indexOfAsterisk; i < states_length; i++) {
				for (int j = i; j < thirdElementForAsterisk; j++) {
					states[i - 1].add(Integer.toString(j));
				}

				if (i == thirdElementForAsterisk) {
					for (int j = i; j < lastElementForAsterisk; j++) {
						states[i].add(Integer.toString(j - 1));
						states[i].add(Integer.toString(j + 1));
					}

					Collections.sort(states[i]);
				}

				if (i == lastElementForAsterisk) {
					states[indexOfAsterisk - 1].add(Integer.toString(i));
				}
			}
		}
		else if (inputCase.contains("3") == true) {
			String[] separatedAlp = userAlphabet.split("/");
			int lengthFirstString = separatedAlp[0].length();

			for (int i = 1; i < states_length; i++) {
				if (i == 1) {
					states[i - 1].add(Integer.toString(i));
					states[i - 1].add(Integer.toString(lengthFirstString + 2));
				} else if (i == lengthFirstString + 1) {
					states[i].add(Integer.toString(states_length - 1));
				} else if (i == states_length - 1) {
					states[i - 1].add(Integer.toString(i));
				}
			}
		}

		return states;
	}

	// Outputs e-closure table created.
	public void DisplayEClosureTable(LinkedList<String>[] states, String userAlphabet) {
		E_Closure e_closure_obj = new E_Closure();
		LinkedList<String>[] new_states = e_closure_obj.E_Closure_T(states, userAlphabet);

		System.out.println("State\t| E-Closure(s)");

		for (int i = 0; i < new_states.length; i++) {
			System.out.print(i + "\t| ");
			for (int j = 0; j < new_states[i].size(); j++) {
				if (j == new_states[i].size() - 1) {
					System.out.print(new_states[i].get(j));
				} else {
					System.out.print(new_states[i].get(j) + ", ");
				}
			}
			System.out.println();
		}

	}
}
