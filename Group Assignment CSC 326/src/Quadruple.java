import java.util.LinkedList;

public class Quadruple {
	// Linked list to store address code
	LinkedList<String> addressCode = new LinkedList<String>();

	// Method to create quadruple table
	public String[][] CreateQuadTable(String userInput) {
		Three_Address_Code TAC_obj = new Three_Address_Code();

		String[] splitedInput = userInput.split(" ");
		addressCode = TAC_obj.ThreeAddressCodeOf(userInput);

		int addressCodeLength = addressCode.size();
		String[][] splitedAddressCode = new String[addressCodeLength][3];
		String[][] quadrupTable = new String[4][addressCodeLength];
		int lastElementIndexTAC = addressCodeLength - 1;

		for (int i = 0; i < addressCodeLength; i++) {
			splitedAddressCode[i] = addressCode.get(i).split(" ");
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < lastElementIndexTAC; j++) {
				if (i == 0) {
					if (j == 0) {
						quadrupTable[i][j] = splitedAddressCode[j][2];
					} else {
						quadrupTable[i][j] = splitedAddressCode[j][1];
					}
					if (splitedAddressCode[j][2].equals("-")) {
						quadrupTable[i][j] = "uminus";
					}
				} else if (i == 1) {
					if (j == 0) {
						quadrupTable[i][j] = splitedAddressCode[j][3];
					} else {
						quadrupTable[i][j] = splitedAddressCode[j][2];
					}
				} else if (i == 2) {
					if (j == 0) {
						quadrupTable[i][j] = splitedAddressCode[j][1];
					} else {
					quadrupTable[i][j] = splitedAddressCode[j][0];
					}
				} else if (i == 3) {
					quadrupTable[i][j] = "t" + (j + 1);
				}
			}
		}

		quadrupTable[0][lastElementIndexTAC] = "=";
		quadrupTable[1][lastElementIndexTAC] = splitedAddressCode[lastElementIndexTAC][0];
		quadrupTable[3][lastElementIndexTAC] = splitedInput[0];

		return quadrupTable;
	}

	// Method to display quadruple table
	public void DisplayQuadTable(String input) {
		String[][] quadrupleTable = CreateQuadTable(input);
		int itr = 0;
		int tableLength_r = quadrupleTable.length;
		int tableLength_c = quadrupleTable[1].length;

		System.out.println("No\t OP\t Arg1\t Arg2\t Result");

		for (int i = 0; i < tableLength_c; i++) {
			System.out.print("(" + itr + ")");
			for (int j = 0; j < tableLength_r; j++) {
				System.out.print("\t" + quadrupleTable[j][i]);

				if (j == tableLength_r - 1) {
					itr++;
					System.out.println();
				}
			}
		}
	}
}
