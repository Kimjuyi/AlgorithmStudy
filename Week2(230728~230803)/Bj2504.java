import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        int result = 0;
        int answer = 1;
        int temp = 1;
        
        for(int i = 0; i < input.length() - 1; i++) {
            if(input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                temp *= 2;
            }
            
            if(input.charAt(i) == '[') {
            	stack.push(input.charAt(i));
            	temp *= 3;
            }
            
            if(input.charAt(i) == ')') {
                if(stack.peek() == '(') {
                    answer = 2 * temp;
                    if(input.charAt(i + 1) == '(' || input.charAt(i + 1) == '[') {
                        result += answer;
                        temp /= 2;
                    }
                }
                else {
                    result = 0;
                    break;
                }
                stack.pop();
            }
            
            if(input.charAt(i) == ']') {
                if(stack.peek() == '[') {
                    answer = 3 * temp;
                    if(input.charAt(i + 1) == '(' || input.charAt(i + 1) == '[') {
                        result += answer;
                        temp /= 3;
                    }
                }
                else {
                    result = 0;
                    break;
                }
                stack.pop();
            }
        }
        
//        for(int i = 0; i < input.length() - 1; i++) {
//        	if(input.charAt(i) == '(' || input.charAt(i) == '[') {
//        		stack.push(input.charAt(i));
//        	}
//        	
//        	if(input.charAt(i) == ')') {
//        		if(stack.peek() == '(') {
//        			answer = 2 * answer;
//        			if(input.charAt(i + 1) == '(' || input.charAt(i + 1) == '[') {
//        				result += answer;
//        				answer = 1;
//        			}
//        		}
//        		else {
//        			result = 0;
//        			break;
//        		}
//        		stack.pop();
//        	}
//        	
//        	if(input.charAt(i) == ']') {
//        		if(stack.peek() == '[') {
//        			answer = 3 * answer;
//        			if(input.charAt(i + 1) == '(' || input.charAt(i + 1) == '[') {
//        				result += answer;
//        				answer = 1;
//        			}
//        		}
//        		else {
//        			result = 0;
//        			break;
//        		}
//        		stack.pop();
//        	}
//        }
        
        System.out.println(result);

    }

}