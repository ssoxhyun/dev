package day03.ws;

import java.util.Scanner;
import java.util.Stack;

public class SWEA1218 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			Stack<Character> stack = new Stack<Character>();
			
			int num = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				if(c == ')' && stack.peek() == '(') stack.pop();
				else if(c == ']' && stack.peek() == '[') stack.pop();
				else if(c == '}' && stack.peek() == '{') stack.pop();
				else if(c == '>' && stack.peek() == '<') stack.pop();
				else {
					stack.push(c);
				}
			}
		if(stack.isEmpty())	
			System.out.printf("#%d %d\n",t,1);
		else 
			System.out.printf("#%d %d\n",t,0);
		
		}

	}

}
