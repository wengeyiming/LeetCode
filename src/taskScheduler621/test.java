package taskScheduler621;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		char[] tasks = new char[]{'A','A','A','B','B','B'};
		System.out.println(leastInterval(tasks, 2));
	}
	
    public static int leastInterval(char[] tasks, int n) {
        int[] letter = new int[26];
        for(int i=0; i<tasks.length; i++) {
        	letter[tasks[i]-'A']++;
        }
        Arrays.sort(letter);
        int num = 25;
        int max = letter[25];
        for(int i=letter.length-1; i>=0; i--) {
        	if(letter[i] != max) {
        		break;
        	} else {
        		num--;
        	}
        }
        return Math.max(tasks.length, (n+1)*(max-1)+25-num);

    }
}
