package splitArrayintoFibonacciSequence842;

import java.util.*;

public class test {
	public static void main(String[] args) {
		String s = new String("11235813");
		List<Integer> list = splitIntoFibonacci(s);
		for (Integer n : list) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static List<Integer> splitIntoFibonacci(String S) {
		List<Integer> list = new ArrayList<>();
		findByBackTracking(S, 0, list);
		return list;
	}

	//这个不仅要添加list，还要进行条件判断，所以用boolean最合适
	private static boolean findByBackTracking(String s, int start, List<Integer> list) {
		if (start >= s.length() && list.size() >= 3) {
			return true;
		}
		for (int i = start; i < s.length(); i++) {
			if (s.charAt(start) == '0' && i > start) {
				break;
			}
			long num = Long.parseLong(s.substring(start, i + 1));
			if (num > Integer.MAX_VALUE) {
				break;
			}
			int size = list.size();
			// early termination
			if (size >= 2 && num > list.get(size - 1) + list.get(size - 2)) {
				break;
			}			
			if(size < 2 || num == list.get(size - 1) + list.get(size - 2)) {
				list.add((int)num);
				if(findByBackTracking(s, i+1, list)) {
					return true;
				}
				list.remove(list.size()-1);
			}
		}
		return false;
	}
}
