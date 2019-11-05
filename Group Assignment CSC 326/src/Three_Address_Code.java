import java.util.LinkedList;

public class Three_Address_Code {
	String[] separatedUserInput;
	LinkedList<String> t = new LinkedList<String>();

	// Method returns TAC of user's input
	public LinkedList<String> ThreeAddressCodeOf(String userInput) {
		// Separate string with a space
		int count1 = 0;
		int count2 = 0;

		String prevAddressCode = "";
		String addressCode = "";

		separatedUserInput = userInput.split(" ");

		int inputLength = separatedUserInput.length;

		// Cases for when user input contains a
		// multiplication operand and a subtraction
		// operand together not done, and when user
		// input contains a square root.
		for (int i = 2; i < inputLength; i++) {
			count1++;

			addressCode = addressCode + " " + separatedUserInput[i];
			prevAddressCode = prevAddressCode + " " + separatedUserInput[i];

			if (count1 == 3) {
				t.add(addressCode);

				addressCode = "";
				count1 = 0;
				if (t.getLast().equals(prevAddressCode)) {
					count1++;
					count2++;
					addressCode = addressCode + "t" + count2;
					prevAddressCode = "";
					prevAddressCode = prevAddressCode + "t" + count2;
				}
			}
			if (i == inputLength - 1) {
				String finalAddressCode = "t" + count2;
				t.add(finalAddressCode);
			}
		}

		return t;
	}

	// Method to display TAC of user's input
	public void DisplayAddressCode(String userInput) {
		Three_Address_Code TAC_obj = new Three_Address_Code();

		LinkedList<String> TAC = TAC_obj.ThreeAddressCodeOf(userInput);
		String[] splitedString = userInput.split(" ");
		int TAC_length = TAC.size();

		for (int i = 0; i < TAC_length; i++) {
			if (i == TAC_length - 1) {
				System.out.println(splitedString[0] + " = " + TAC.get(i));
				continue;
			}
			else if (i > 0 && i < TAC_length - 1) {
				System.out.println("t" + (i + 1) + " = " + TAC.get(i));
				continue;
			}
			System.out.println("t" + (i + 1) + " =" + TAC.get(i));
		}
	}
}