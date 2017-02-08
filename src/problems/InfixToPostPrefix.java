package problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostPrefix {
	
	public static char[] infixToPostfix(char arr[]) {
		
		Stack<Object> operators = new Stack<Object>();
		List<Object> postfixed = new ArrayList<>();
		
		for(int i=0; i<arr.length; i++) {
			if(!operations(arr[i]) ) {
				if(arr[i] == '(') {
					operators.push(arr[i]);
				} else  if(arr[i] == ')'){
					while(!operators.isEmpty() && operators.peek() != (Object)'(') {
							postfixed.add(operators.pop());
					}
					if(!operators.isEmpty()) {
						operators.pop();
					}
				} else {
					postfixed.add(arr[i]);
				}
			} else {
				if(!operators.isEmpty()  && getPrecedence(arr[i]) <= getPrecedence(operators.peek())) {
					postfixed.add(operators.pop());
				}
				operators.push(arr[i]);
			}
		}
		while(!operators.isEmpty()) {
			if(operators.peek() == (Object)'(' || operators.peek() == (Object)')'){
				operators.pop();
			} else {
				postfixed.add(operators.pop());
			}
		}
		System.out.println(Arrays.toString(postfixed.toArray()));
		
		char[] finalArr = new char[postfixed.toArray().length];
		for(int i=0; i< postfixed.toArray().length; i++) {
			finalArr[i] = (char) postfixed.toArray()[i];
		}
		return finalArr;
	}
	
	public static void infixToPrefix(char arr[]) {
		
		char[] temp = reverseArray(arr);
		System.out.println(temp);
		char[] temp1 = infixToPostfix(temp);
		System.out.println(temp1);
		char[] finalArr = reverseArray(temp1);
		System.out.println(finalArr);
	}
	
	public static char[] reverseArray(char arr[]) {
		
		int i = 0;
		int j = arr.length-1;
		while(i<j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		for(i=0; i< arr.length; i++) {
			if(arr[i] == '(') {
				arr[i] = ')';
			} else if(arr[i] == ')') {
				arr[i] = '(';
			} 
		}
		
		return arr;
	}
	
	public static boolean operations(Object x) {
		
		String ops = "^/*+-";
		for(Object o : ops.toCharArray()) {
			if( o == x) {
				return true;
			} 
		}
		return false;
	}
	
	private static int getPrecedence(Object ch) {
        switch ((char)ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }
	
	public static int state(Stack<Object> stack, Object x) {
		
		char ops[] = {'/', '*', '+', '-' };
		int y = 0;
		if(stack.empty()) {
			y = 1;
		} else {
			if(stack.peek() == x) {
				y =  1;
			} else if(Arrays.binarySearch(ops, (char)x) >= 2 && Arrays.binarySearch(ops, (char) stack.peek()) < 2 && Arrays.binarySearch(ops, (char) stack.peek()) >= 0 ) {
				y = 0;
			} else if(Arrays.binarySearch(ops, (char) stack.peek()) <= Arrays.binarySearch(ops, (char)x)) {
				y = 1;
			} else {
				y = 1;
			}
		}
		return y;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String equation = "((A+B)*C)*D-(E-F)*(G+H)";
		infixToPostfix(equation.toCharArray());
		infixToPrefix(equation.toCharArray());

	}

}
