import java.util.*;

/**
 * Lab 001 
 * @version 1.0
 * @author Sanghwan Lee
 */

class LabTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// System.err.print("echo > ");
		while (true) {
			String s = scanner.next();
			if (s.equals("quit")) {
				scanner.close();
				break;
			}
			String s1 = s + " !!";
			System.out.println(s1);
		}
	}
}