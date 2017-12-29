import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

class Result {
	int min;
	double average;
}

class ClassStatus {
	int enroll[] = new int[10];
	double avg[] = new double[10];
}

class Alphabet {
	int sAlpha[] = new int[26];
	int lAlpha[] = new int[26];
	int extra;
}

public class Lab3 {
    
	// (Exercise)
	public int max(int[] intArray) {
		
		int max = intArray[0];
		
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] > max) 
				max = intArray[i];
		}
		
		return max;
	}
	
	
	// (Test1) -- (hint) sample program (3-2) & the above (Exercise)
	public Result min_avg(int[] intArray)
	{
		
		Result r = new Result();
		int min = intArray[0];
		
		for (int i = 0; i < intArray.length; i++)
		{
			if (intArray[i] < min)
				min = intArray[i];
		}
		double sum=0;
		for(int i=0; i<intArray.length; i++)
		{
			sum=sum+intArray[i];
		}
		
		r.min = min;
		r.average = sum/intArray.length;
		
		return r;
	}
	
	
	// (Test2)
	public int count_in_Range(double lower, double upper, double[] dArray) 
	{
		int count=0; 
		
		for (int k = 0; k < dArray.length; k++) 
		{
			if((lower<=dArray[k]) & (dArray[k]<=upper))
			{
			count++ ; //  if lower <= dArray[k] <= upper, k=0...dArray.length
			}
		}
		
		return count;
    }
	
	// (Test3) height(unit: cm), weight(unit: kg)
	public ClassStatus class_Status(double oopScore[][]) 
	{
		
		ClassStatus s = new ClassStatus();
		
		
		for(int i=0; i < oopScore.length; i++)
		{
			double sum=0.0;
			for(int j=0; j < oopScore[i].length; j++) 
			{
				sum += oopScore[i][j];		
			}
			s.avg[i]=sum/(oopScore[i].length);
		}
		
		
		s.enroll[0]=oopScore.length;
		s.enroll[1]=oopScore[1].length;
		s.enroll[2]=oopScore[2].length;
		s.enroll[3]=oopScore[3].length;

		return s;
	}
	
	// (Test4) transform string array to int array
	public int[] stringToInt(String[] str) 
	{
		
		int res[] = new int[str.length];
		
		try 
		{
			for (int i = 0; i < str.length; i++) 
			{
				res[i] = (int) Double.parseDouble(str[i]); //<<edit here
			}
		}
		catch (NumberFormatException e) 
		{
			System.out.println("  --> (exception) error in changing string to integer(parseInt()).");
		}	
		
		return res;
	}
	
	// (Test5) alphabet counting
	public Alphabet countAlphabet(String str) 
	{
		Alphabet alp = new Alphabet(); 

		// str.charAt(i)  --> the character at i-th location in String str
		char a = 'a';
		for (int i = 0; i < 26; i++)
		{
			int sum =0;
			for (int j = 0; j < str.length(); j++) 
			{
				if (str.charAt(j)==a)
				{
				sum++;
				}
			}
			alp.sAlpha[i] = sum;
			a =(char)(a+1);
		}
		char A = 'A';
		for (int i = 0; i < 26; i++)
		{
			int sum =0;
			for (int j = 0; j < str.length(); j++) 
			{
				if (str.charAt(j)==A)
				{
				sum++;
				}
			}
			alp.lAlpha[i] = sum;
			A =(char)(A+1);
		}
		int sum =0;
		for (int j = 0; j < str.length(); j++) 
		{
			if ((str.charAt(j)=='?')|(str.charAt(j)=='!')|(str.charAt(j)=='.')|(str.charAt(j)==','))
				sum++;
			if ('0'<= str.charAt(j) && str.charAt(j) <= '9' )
				sum++;
		}
		alp.extra = sum;
		return alp;
    }
	
	public static void main(String[] args) {

		int i;
		double d;
		
		Lab3 lab3 = new Lab3();

		// (Exercise) the maximum value in the array
		int arr[] = { 5, 7, 9, 4, 2, 3 };
		System.out.print("\n(ex: input) : { ");
		for(i=0; i<arr.length; i++) 
			if(i<arr.length-1) System.out.print(arr[i] + ", ");
			else System.out.println(arr[i] + " }");
		i = lab3.max(arr); // sum() 메소드호출, input: { 5, 7, 9, 4, 2, 3 }, answer: 9
		System.out.println("(ex) the maximum value is " + i); 
		
		// (Test1) minimum and average value in the array --- 5 points
		System.out.print("\n\n(test1: input) : { ");
		for(i=0; i<arr.length; i++) 
			if(i<arr.length-1) System.out.print(arr[i] + ", ");
			else System.out.println(arr[i] + " }");
		Result r = lab3.min_avg(arr); // min_avg() call, input: { 5, 7, 9, 4, 2, 3 }, answer: min(2), avg(5.0)
		System.out.println("(test1) MIN=" + r.min + ", AVERAGE=" + r.average);
		
		// (Test2) the number of values inside of the range --- 5 points
		double score[] = { 86.5, 54.3, 93.2, 60.0, 73.9, 42.3, 58.5, 61.2, 80.0, 96.5 };
		System.out.print("\n\n(test2: input) : { ");
		for(i=0; i<score.length; i++) 
			if(i<score.length-1) System.out.print(score[i] + ", ");
			else System.out.println(score[i] + " }");
		i = lab3.count_in_Range(60.0, 80.0, score); // input: score[0..9], answer: 4
		System.out.println("(test2) # of values in the range (60.0, 80.0) is " + i); 
				
		// (Test3) OOP class statistics --- 5 points
		double oopScore[][] = { {75.9, 94.5, 82.6, 64.5},
								{47.3, 25.9, 88.4, 99.6, 72.3},
								{63.2, 59.8, 83.4},
								{93.2, 36.7, 66.3, 59.8, 46.9, 86.6, 75.3} } ;
		System.out.print("\n\n(test3: input) :     { \n");
		for(i=0; i<oopScore.length; i++) 
		{
			System.out.print("\t\t\t{ ");
			for(int j=0; j<oopScore[i].length; j++)
				if(j<oopScore[i].length-1) System.out.print("\"" + oopScore[i][j] + "\", ");
				else System.out.println("\"" + oopScore[i][j] + "\" }");
		}
		System.out.println("\t\t     }");
		ClassStatus c = lab3.class_Status(oopScore); // input: oopScore[0..3][], answer: { {4, 5, 3, 7}, {79.375, 66.7, 68.8, 66.4} }
		System.out.println("(test3: output) OOP classes: " + oopScore.length); 
		for (i = 0; i < oopScore.length; i++)
			System.out.println("  [class" + (i+1) + "] : " + "# of students=" + c.enroll[i] + ", average=" + c.avg[i]);
		System.out.println("\n");
		
		// (Test4) elapsed time computation --- 5 points
		String[] stringNumber= {"23", "12.67", "998", "3.141592"};
		System.out.print("(test4: input) : { ");
		for(i=0; i<stringNumber.length; i++) 
			if(i<stringNumber.length-1) System.out.print("\"" + stringNumber[i] + "\", ");
			else System.out.println("\"" + stringNumber[i] + "\" }");
		int iArr[] = lab3.stringToInt(stringNumber); // input: {"23", "12", "998", "3.141592"}, answer: {23, 12, 998, 3}
		System.out.print("(test4: output) the result is [");	
		for (i = 0; i < iArr.length; i++)
		{
			System.out.print(iArr[i]);
			if(i!=iArr.length-1) System.out.print(", ");
			else System.out.println("]");
		}

		// (Test5) alphabet statistics in an English sentence. --- 10 points
		String str = "This is a test sentence used in Object Oriented Programming. How are you today? Can you clear this Test5?";
		System.out.println("\n\n(test5: input string) : \"" + str + "\"");
		Alphabet a = lab3.countAlphabet(str);
		
		  // (answer)
		  // a.sAlpha[i] = {6, 1, 3, 3, 11, 0, 2, 2, 6, 1, 0, 1, 2, 6, 5, 0, 0, 5, 7, 8, 3, 0, 1, 0, 3, 0}
		  // a.lAlpha[i] = {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0}
		  // a.extra = 4

		System.out.println("(test5: output) # of extra character = " + a.extra);	
		System.out.print("(test5: output) # of small size alpha = [");	
		for (i = 0; i < 26; i++)
		{
			System.out.print(a.sAlpha[i]);
			if(i!=25) System.out.print(", ");
			else System.out.println("]");
		}
		System.out.print("(test5: output) # of large size alpha = [");	
		for (i = 0; i < 26; i++)
		{
			System.out.print(a.lAlpha[i]);
			if(i!=25) System.out.print(", ");
			else System.out.println("]");
		}
				
	}

}
