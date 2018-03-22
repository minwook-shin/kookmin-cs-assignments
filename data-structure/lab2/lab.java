import java.util.*;

/**
 * Lab 002 
 * @version 1.0
 * @author Sanghwan Lee
 * @id 20181234
 */

class LabTest {
	public static void main(String[] args) {
		int n;
		int m;
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.err.println("Enter m n :");
			n = scanner.nextInt();
			m = scanner.nextInt();
			
			
			if(n == 0){
				scanner.close();
				break;
			}
			System.out.printf("Combination(%s, %s) :",n, m);
			System.out.println(" " + Combi(n, m));
		}
	}

	static int Combi(int n, int m) {
		if (m==n || m==0)
         return 1;
       else return Combi(n-1,m-1) + Combi(n-1, m);
	}

	
}

