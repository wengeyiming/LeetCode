package permutationSequence60;

//这个题目是输出全排列，注意和SubSet题输出子集的不同。此题出的很好，值得以后研究
import java.util.*;
public class test {
	public static void main(String[] args) {
		String s = getPermutation(3,1);
		System.out.print(s);
	}
	
    public static String getPermutation(int n, int k) {
	    if ( k > factorial(n) || k <= 0) return null;
		int[] flag = new int[n];
		StringBuilder sb = new StringBuilder("");
		findByBackTracking(n,k,sb,flag);		
		return sb.toString();       
    }
    
	public static void findByBackTracking(int n, int k, StringBuilder sb, int[] flag) {
		//这段完全可以不要 
		/*
		if(sb.length() == n) {
			System.out.println(sb);
			return;
		}
		*/
		int times = 1;
		int factor = factorial(n-1-sb.length());
		for(int i=1; i<=n; i++) {
			if(flag[i-1] == 0) {
				if(k<=times*factor) {
					sb.append(i);
					flag[i-1]=1;
					findByBackTracking(n,k-(times-1)*factor,sb,flag);			
					//下面复位的操作删除了。因为是一次性找的。
					//如果不删除，当sb.length()==n的时候立刻输出还是可以输出的,不过返回后就没了,原理未知(因为执行完回溯返回上一层把sb里的又消除了)。
					//sb.deleteCharAt(sb.length()-1);
					//如果flag归位,则下一层回溯又会把之前读到的数字再读一遍，会导致sb结果异常的长
					//flag[i-1]=0;
				} else {
					times++;
				}
			}
		}
	}

    private static int factorial (int n) {
        int res = 1;
        while (n > 1) {
            res *= n;
            n--;
        }
        return res;
    }   

}
