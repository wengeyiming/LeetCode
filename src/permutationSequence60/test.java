package permutationSequence60;

//�����Ŀ�����ȫ���У�ע���SubSet������Ӽ��Ĳ�ͬ��������ĺܺã�ֵ���Ժ��о�
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
		//�����ȫ���Բ�Ҫ 
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
					//���渴λ�Ĳ���ɾ���ˡ���Ϊ��һ�����ҵġ�
					//�����ɾ������sb.length()==n��ʱ������������ǿ��������,�������غ��û��,ԭ��δ֪(��Ϊִ������ݷ�����һ���sb�����������)��
					//sb.deleteCharAt(sb.length()-1);
					//���flag��λ,����һ������ֻ��֮ǰ�����������ٶ�һ�飬�ᵼ��sb����쳣�ĳ�
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
