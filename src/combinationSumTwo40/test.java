package combinationSumTwo40;

//�����һ����������һ������û�ظ���ÿ��λ�õ����ֿ���ʹ������Ρ������Ŀ���������ظ�������ÿ��λ�õ�����ֻ��ʹ��һ��
import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] candidates = new int[]{1,1,1,6};
		int target = 8;
		List<List<Integer>> list = combinationSum(candidates, target);
		
		for(List<Integer> subs : list) {
			for(Integer s : subs) {
				System.out.print(s);
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> list = new ArrayList<>();
    	List<Integer> sub = new ArrayList<Integer>();   	
    	Arrays.sort(candidates);
    	int[] flag = new int[candidates.length];
    	findByBackTracking(candidates,target,list,0,sub,0, flag);
    	return list;
    }	
    
    public static void findByBackTracking(int[] candidates, int target, List<List<Integer>> list, int sum, List<Integer> sub, 
    		int start, int[] flag) {
    	if(sum > target) {
    		return;
    	} else if(sum == target) {
    		//��֪��Ϊ��Ҫ�½�һ��List������ӽ�ȥ
    		List<Integer> found = new ArrayList<Integer>(sub);
    		list.add(found);
    		return;
    	} else {
    		Integer last = null;
    		//Ҫע�ⲻ���ظ�,����Ҫ����һ��ѭ����ʼ����ʼλ,���˼·Ҫע��һ�£����Ժ�����Ľ�����⡣
    		for(int i=start; i<candidates.length; i++) { 			
    			if(flag[i]==0 && (last == null || last != candidates[i])) {
    				sub.add(candidates[i]); 
    				flag[i] = 1;
    				//ע�������������flag�������i+1,��Ӧ������ֻ����һ��,������flag�����Ч��
    				findByBackTracking(candidates,target,list,sum+candidates[i],sub,i, flag);
    				//�������ʵ�����Ѿ������һ�νڵ�Ļ��������ˡ�����Ҫ��¼һ�¸ջ��ݵĽڵ�����֣������һ���ڵ��������ͬ�������������ظ�
    				//Ϊ�β���flag���飺ԭ�������Ǹ����ܲ���
    				flag[i] = 0;
    				last = sub.remove(sub.size()-1);
    			}
    		}
    	}
    }  
    
    /*
    public static void findByBackTracking(int[] candidates, int target, List<List<Integer>> list, int sum, List<Integer> sub, 
    		int start) {
    	if(sum > target) {
    		return;
    	} else if(sum == target) {
    		//��֪��Ϊ��Ҫ�½�һ��List������ӽ�ȥ
    		List<Integer> found = new ArrayList<Integer>(sub);
    		list.add(found);
    		return;
    	} else {
    		Integer last = null;
    		//Ҫע�ⲻ���ظ�,����Ҫ����һ��ѭ����ʼ����ʼλ,���˼·Ҫע��һ�£����Ժ�����Ľ�����⡣
    		for(int i=start; i<candidates.length; i++) { 			
    			if(last == null || last != candidates[i]) {
    				sub.add(candidates[i]); 
    				//ע��������i+1,��Ӧ������ֻ����һ��
    				//ע��������i+1,��Ӧ������ֻ����һ��,������flag�����Ч��
    				findByBackTracking(candidates,target,list,sum+candidates[i],sub,i+1);
    				//�������ʵ�����Ѿ������һ�νڵ�Ļ��������ˡ�����Ҫ��¼һ�¸ջ��ݵĽڵ�����֣������һ���ڵ��������ͬ�������������ظ�
    				//Ϊ�β���flag���飺ԭ�������Ǹ����ܲ���
    				last = sub.remove(sub.size()-1);
    			}
    		}
    	}
    } 
    */
}


