package problems;

import java.util.Stack;

public class MatchedBrackets {
	
	public static void matchBrackets(String arr[]) {
		
		Stack<Object> brackets = new Stack<Object>();
		
		for(int i=0; i< arr.length; i++) {
			
			if(arr[i] == "{" || arr[i] == "(" || arr[i] == "[") {
				brackets.push(arr[i]);
			} else if(arr[i] == "}" || arr[i] == ")" || arr[i] == "]") {
				if(matched(brackets , arr[i])) {
					brackets.pop();
				} else {
					System.out.println("The brackets are not in order at all.");
					break;
				}
			}
			
			if(!brackets.isEmpty() && i == arr.length - 1 ) {
				System.out.println("All brackets are not in closed.");
			} 
			if(brackets.isEmpty() && i == arr.length - 1){
				System.out.println("All brackets are closed.");
			}				
		}
	}

	public static boolean matched(Stack<Object> stack, Object x) {
		
		Object closing = new Object();
		if(stack.isEmpty()) {
			return false;
		} else {
			if(stack.peek() == "{") {
				closing = "}";
			}
			if(stack.peek() == "(") {
				closing = ")";
			}
			if(stack.peek() == "[") {
				closing = "]";
			}
			return (x ==  closing);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = {"{","[","(",")","]","}","}"};	
		
		matchBrackets(arr);
		
	}

}
