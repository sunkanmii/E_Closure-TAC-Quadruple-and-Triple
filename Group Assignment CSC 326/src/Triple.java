import java.util.LinkedList;

public class Triple {
	LinkedList<String> addressCode = new LinkedList<String>();

	public String[][] CreateTripTable(String userInput) {
		Three_Address_Code TAC_obj = new Three_Address_Code();

		String[] splitedInput = userInput.split(" ");
		addressCode = TAC_obj.ThreeAddressCodeOf(userInput);

		int addressCodeLength = addressCode.size();
		String[][] splitedAddressCode = new String[addressCodeLength][3];
		String[][] tripTable = new String[3][addressCodeLength];
		int lastElementIndexTAC = addressCodeLength - 1;
		String finalArg1 = "";

		for (int i = 0; i < addressCodeLength; i++) {
			splitedAddressCode[i] = addressCode.get(i).split(" ");
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < lastElementIndexTAC; j++) {
				if (i == 0) {
					if (j == 0) {
						tripTable[i][j] = splitedAddressCode[j][2];
					} else {
						tripTable[i][j] = splitedAddressCode[j][1];
					}
					if (splitedAddressCode[j][2].equals("-")) {
						tripTable[i][j] = "uminus";
					}
				} else if (i == 1) {
					if (j == 0) {
						tripTable[i][j] = splitedAddressCode[j][1];
					} else {
						tripTable[i][j] = "(" + (j - 1) + ")";
						finalArg1 = "(" + j + ")";
					}
				} else if (i == 2) {
					if (j == 0) {
						tripTable[i][j] = splitedAddressCode[j][3];
					} else {
						tripTable[i][j] = splitedAddressCode[j][2];
					}
				}
			}
		}

		tripTable[0][lastElementIndexTAC] = "=";
		tripTable[1][lastElementIndexTAC] = finalArg1;

		return tripTable;
	}

	public void DisplayTripTable(String input) {
		String[][] tripleTable = CreateTripTable(input);
		int itr = 0;
		int tableLength_r = tripleTable.length;
		int tableLength_c = tripleTable[1].length;

		System.out.println("No\t OP\t Arg1\t Arg2");

		for (int i = 0; i < tableLength_c; i++) {
			System.out.print("(" + itr + ")");
			for (int j = 0; j < tableLength_r; j++) {
				System.out.print("\t" + tripleTable[j][i]);

				if (j == tableLength_r - 1) {
					itr++;
					System.out.println();
				}
			}
		}
	}
}
