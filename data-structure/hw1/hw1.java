import java.time.temporal.TemporalAccessor;
import java.util.*;

class Expression {
	static double Eval(Vector<String> infix) throws Exception {
		Vector<String> postfix = new Vector<String>();
		Stack<String> stack = new Stack<String>();
		String tmp = "";
		infix_print(infix);

		for (int i = 0; i < infix.size(); i++) {
			if (isNumeric(infix.elementAt(i))) {
				postfix.add(infix.elementAt(i));
				token_stack_print(infix.elementAt(i), stack_print(stack));
			} else {
				if (infix.elementAt(i).equals("(") || stack.isEmpty()) {
					stack.push(infix.elementAt(i));
					token_stack_print(infix.elementAt(i), stack_print(stack));
				} else if (infix.elementAt(i).equals(")")) {
					tmp = stack.pop();
					postfix.add(tmp);
					while (!(tmp.equals("("))) {
						tmp = stack.pop();
						if (!(tmp.equals("("))) {
							postfix.add(tmp);
						}
					}

					token_stack_print(infix.elementAt(i), stack_print(stack));
				} else {
					if (!(stack.isEmpty()) && get_weight(infix.elementAt(i)) > get_weight(stack.peek())) {
						stack.push(infix.elementAt(i));
						token_stack_print(infix.elementAt(i), stack_print(stack));
					} else {

						while (!(stack.isEmpty()) && get_weight(infix.elementAt(i)) <= get_weight(stack.peek())) {
							tmp = stack.pop();
							postfix.add(tmp);
						}
						stack.push(infix.elementAt(i));
						token_stack_print(infix.elementAt(i), stack_print(stack));
					}
				}
			}

		}
		while (!(stack.isEmpty())) {
			tmp = stack.pop();
			postfix.add(tmp);
		}
		postfix_print(postfix);

		String text = "";

		for (int i = 0; i < postfix.size(); i++) {
			text += postfix.elementAt(i);
		}
		// NEED TO IMPLEMENT
		return calc(text);
	}

	static void infix_print(Vector<String> infix) {
		System.out.print("infix expression : [");
		for (int i = 0; i < infix.size(); i++) {
			if (infix.elementAt(i).equals(",")) {
				continue;
			} else {
				if (i != 0) {
					System.out.print("  ");
				}
				System.out.print(infix.elementAt(i));
			}
		}
		System.out.println("]");
	}

	static void postfix_print(Vector<String> infix) {
		System.out.print("Postfix expression : [");
		for (int i = 0; i < infix.size(); i++) {
			if (infix.elementAt(i).equals(",")) {
				continue;
			} else {
				if (i != 0) {
					System.out.print("  ");
				}
				System.out.print(infix.elementAt(i));
			}
		}
		System.out.println("]");
	}

	static void token_stack_print(String infix, String stack) {
		System.out.println("Token : " + infix);
		System.out.println("Stack : " + stack);

	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	static String stack_print(Stack<String> s) {
		Stack<String> copy = new Stack<String>();
		Stack<String> copy2 = new Stack<String>();
		String temp = "";
		copy.addAll(s);
		while (!copy.isEmpty()) {
			copy2.push(copy.pop());
		}
		while (!copy2.isEmpty()) {
			temp += copy2.pop() + " ";
		}
		return temp;
	}

	static int get_weight(String o) {
		if (o.equals("*") || o.equals("/")) {
			return 9;
		} else if (o.equals("+") || o.equals("-")) {
			return 7;
		} else if (o.equals("(")) {
			return 5;
		} else {
			return -1;
		}
	}

	private static String cp = "";

	static double calc(String p) {
		Stack<Double> S = new Stack<Double>();
		cp = p;
		double opr1, opr2, val;
		char testCh;
		// System.out.println(p);
		// System.out.println(cp);
		// System.out.println(p.length());
		
		for (int i = 0; i < p.length(); i++) {
			testCh = cp.charAt(i);
			// System.out.println(testCh);
			if (testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/') {
				val = testCh - '0';
				S.push(val);
				
			} else {
				opr2 = S.pop();
				opr1 = S.pop();
				switch (testCh) {
				case '+':
					S.push(opr1 + opr2);
					break;
				case '-':
					S.push(opr1 - opr2);
					break;
				case '*':
					S.push(opr1 * opr2);
					break;
				case '/':
					S.push(opr1 / opr2);
					break;
				}
			}
		}
		return S.pop();
	}

};
