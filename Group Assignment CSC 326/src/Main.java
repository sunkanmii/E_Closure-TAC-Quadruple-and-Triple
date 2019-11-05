import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		E_Closure e_closure_obj = new E_Closure();
		Three_Address_Code TAC_obj = new Three_Address_Code();
		Quadruple Quad_obj = new Quadruple();
		Triple trip_obj = new Triple();

		LinkedList<String>[] states = e_closure_obj.CreateLinkedLists();
		// e_closure_obj.DisplayEClosureTable(states, "a/aa");
		//
		// TAC_obj.DisplayAddressCode("a = b + c * d / e");
		// Quad_obj.DisplayQuadTable("a = b + c * d / e");
		trip_obj.DisplayTripTable("a = b + c * d / e * f / q");
	}
}
