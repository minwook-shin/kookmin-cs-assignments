import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab6 {
	
	String replace_all_is_to_are(String str)
	{
		// (Test1)
		String target = str.replace("is", "are");
		
		return target;
		
	}
	
	String longest_word(String str) {
		String longestWord = null;
		StringTokenizer st = new StringTokenizer(str," ,.;:()");
		for (int i=0; i<st.countTokens(); i++) {
			String token = st.nextToken();	
			if (longestWord == null || token.length() > longestWord.length())
				longestWord = token;
		}
		// (Test2)
		
		return longestWord;
	}
		
	String find_value(String parameterList, String name)
	{
		String key = name;
		String value = parameterList;
		StringTokenizer st = new StringTokenizer(value,"&=");
		for (int i=0; i<st.countTokens()+1; i++) {
			key = st.nextToken();
			value = st.nextToken();
			if(key.equals(name)){
				return value;
			}
		// (Test3)
		}
		return value;
	}
	
	public static void main (String[] args) {
		
		Lab6 lab6 = new Lab6(); 
		
		// (Test1) change all "is" to "are" in the input string, and then return the result string.
		
		String str = "They is students. You is also student.";		
		System.out.println("(Test1) input string: \"" + str + "\"");
		System.out.println("(Test1) output string: \"" + lab6.replace_all_is_to_are(str) + "\"\n");
		
		
/*   [The following sentences are Sample input string for Test2 & 3]
----------- 
  My father had a small estate in Nottinghamshire; I was the third          
  of five sons. He sent me to Emanuel College in Cambridge at fourteen        
  years old, where I resided three years, and applied myself close to my      
  studies: but the charge of maintaining me (although I had a very            
  scanty allowance) being too great for a narrow fortune, I was bound         
  apprentice to Mr. James Bates, an eminent surgeon in London, with whom      
  I continued four years; and my father now and then sending me small         
  sums of money, I laid them out in learning navigation, and other parts      
  of the mathematics, useful to those who intend to travel, as I              
  always believed it would be some time or other my fortune to do.            
  When I left Mr. Bates, I went down to my father; where, by the              
  assistance of him and my uncle John, and some other relations, I got        
  forty pounds, and a promise of thirty pounds a year to maintain me          
  at Leyden: there I studied physic two years and seven months,               
  knowing it would be useful in long voyages.	
-------------  	
*/
		
		// (Test2) find out the longest word in the input sentences ended with ctrl-z
		
		Scanner sin = new Scanner(System.in);
		StringBuffer strin = new StringBuffer("");
		System.out.print("(Test2) Type in English sentences>>> ");
		String longestWord = null;
		try {
			while(true)
				strin = strin.append(sin.nextLine() + "\n");
		}
		catch (NoSuchElementException e) { // ctrl-z typing exception
		}
		String str2 = new String(strin);
		System.out.println("(Test2) input string: \n\"" + str2 + "\"");		
		System.out.println("(Test2) longest word: \"" + lab6.longest_word(str2) + "\"\n");
        		

		// (Test3) find out the pairs of parameter name & value in the web request message
		
		String webRequest = "http://oop.kookmin.ac.kr/save_gradeDB?student=honggildong&course=oop&score=A+";
		String parameterList = webRequest.substring(webRequest.indexOf('?')+1);
		System.out.println("(Test3) input parameterList: \"" + parameterList + "\"");		
		System.out.println("(Test3) parameter name=\"student\", value=\"" + lab6.find_value(parameterList, "student") + "\"");
		System.out.println("(Test3) parameter name=\"course\", value=\"" + lab6.find_value(parameterList, "course") + "\"");
		System.out.println("(Test3) parameter name=\"score\", value=\"" + lab6.find_value(parameterList, "score") + "\"");
		
	}
}
