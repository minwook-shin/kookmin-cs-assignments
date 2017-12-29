import java.util.Scanner;

class Time2 {
int day;
int second;
int minute;
int hour;
}

public class Lab2v2 {
    
	// (Exercise)
	public int sum(int n, int m) {
		return n + m;
		}
	
	// (Test1)
	public int average(int n, int m, int k) {
		return (n + m + k)/3; // return the average of three values (n, m, k)
		}
	
	// (Test2)
	public double circle_Area(double r) {
		final double PI = 3.14;
		
		return PI*r*r;  // return the area of the circle of radius "r"
	}
	
	// (Test3) height(unit: cm), weight(unit: kg)
	public double BMI_Index(double height, double weight) {

		return weight/(height*height/10000);  // return BMI index
	}
	
	// (Test4) transform the total elapsed time(second) to the normal time units(day, hour, minute, second)
	public Time2 time_Transform(int t) {
		Time2 et = new Time2();
		
		et.day = t/(60*60*24);
		et.hour = (t%(60*60*24))/(60*60);
		et.minute = (t/60)%60;
		et.second = t%60;
		
		return et;  // return Time object
	}
	
	// (Test5) inner range check
	public boolean inner_Range(int low, int high, int test_value) {
		boolean res; 
		
		res = (low<test_value)&(test_value<high) ; //  low <= test_value <= high   --> 'true'
		
		return res;
    }
	
	public static void main(String[] args) {

		int i;
		double d;
		Scanner a = new Scanner(System.in);
		Time2 time;
		
		Lab2v2 lab2 = new Lab2v2();

		// (Exercise) sum of two values
		i = lab2.sum(5, 10); // sum() 메소드호출, input: (5, 10), answer: 15
		System.out.println("(ex) the sum is " + i); 
		
		// (Test1) expression for average of 3 integers --- 5 points
		i = lab2.average(9, 12, 6); // input: (9, 12, 6), answer: 9
		System.out.println("\n(test1) the average is " + i);
		
		// (Test2) the area of the circle --- 5 points
		d = lab2.circle_Area(7.5); // input: (7.5), answer: 176.625
		System.out.println("\n(test2) the area is " + d); 
				
		// (Test3) BMI index --- 5 points
		System.out.println("\n(test3: input) type your age, weight(kg), height(cm)? ");
		int age = a.nextInt();
		double weight = a.nextDouble();
		double height = a.nextDouble();
		System.out.println("your age is " + age + ".");
		System.out.println("your weight is " + weight + "kg.");
		System.out.println("your height is " + height + "cm.");		
		d = lab2.BMI_Index(height, weight); // input: (170.0, 65.0), answer: 22.49
		System.out.println("(test3: output) BMI is " + d); 
		
		// (Test4) elapsed time computation --- 5 points
		System.out.println("\n(test4: input) type elapsed time(second)? ");
		int t = a.nextInt();
		time = lab2.time_Transform(t); // input: (100045), answer: "1day(s), 3hour(s), 47minute(s), 25second(s)."
		System.out.println("(test4: output) the elipsed time is " + time.day + "day(s), " + time.hour + "hour(s), " + time.minute + "minute(s), " + time.second + "second(s).");		

		// (Test5) inner range check --- 10 points
		System.out.println("\n(test5: input) type low, high, tested_value? ");
		int low = a.nextInt();
		int high = a.nextInt();
		int value = a.nextInt();
		boolean r = lab2.inner_Range(low, high, value);
		System.out.println("(test5: output) the result is " + r);	
		System.out.println("(test5: output) the value(" + value + ") is "  + 
		(r?"in":"out of")/* remove "???? ", this comment, and put the correct words(true -> "IN", false-> "OUT OF") using ternary(?:) operator expression here */  + 
		  " the range (" + low + ", " + high + ").");	
		// test_case(1): (input) (30, 40, 50) --> "the result is false", "the value(50) is OUT OF the range(30, 40)."
		// test_case(2): (input) (25, 32, 27) --> "the result is true", "the value(27) is IN the range(25, 32)."
				
	}

}
