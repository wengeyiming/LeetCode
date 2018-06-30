package baseballGame682;
import java.util.*;


//ø…“‘”√List<Integer> list = new ArrayList<>();
public class test {
	public static void main(String[] args) {
		String[] score = {"5","2","C","D","+"};
		
		System.out.println(calPoints(score));
	}
	
    public static int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> score = new Stack<Integer>();
        for(int i=0; i<ops.length; i++) {
        	if(ops[i].equals("+")) {
        		int top = score.pop();
        		sum = sum + top + score.peek();
        		int top1 = top+score.peek();
        		score.push(top);
        		score.push(top1);
        	} else if(ops[i].equals("D")) {
        		sum += 2*score.peek();
        		score.push(2*score.peek());
        	} else if(ops[i].equals("C")) {
        		sum -= score.peek();
        		score.pop();
        	} else {
        		sum += Integer.parseInt(ops[i]);
        		score.push(Integer.parseInt(ops[i]));
        	}
        }
        
        return sum;
    }
}
