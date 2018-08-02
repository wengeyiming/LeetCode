package minimumWindowSubstring76;

public class test {
	public static void main(String[] args) {
		String s = new String("ADOBECODEBANC");
		String t = new String("ABC");
		System.out.println(minWindow(s,t));
	}

	public static String minWindow(String s, String t) {
		int s_len = s.length();
		int t_len = t.length();
		int ruler = t_len;

		int res = Integer.MAX_VALUE;
		int start = 0;

		int[] freq = new int[128];

		char[] c_s = s.toCharArray();
		char[] c_t = t.toCharArray();

		// count char in t
		for (char c : c_t)
			freq[c]++;

		int i = 0, j = 0;
		while (j < s_len) {
			//System.out.println("loop :   A: "+freq[65]+" ,B: "+freq[66]+" ,C: "+freq[67]);
			// whether ruler can expand
			if (freq[c_s[j++]]-- >= 1)
				ruler--;

			// if ruler == 0, it means all char in t has been contained in
			// window now
			while (ruler == 0) {
				
				System.out.println("loop :   i: "+i+" ,j: "+j);
				
				// choose min window
				if (res > j - i) {
					res = j - i;
					start = i;
				}

				// narrow left border
				if (freq[c_s[i++]]++ == 0)
					ruler++;
				
				//System.out.println("loop :   A: "+freq[65]+" ,B: "+freq[66]+" ,C: "+freq[67]);
			}
			
			System.out.println("i: "+i+" ,j: "+j);

		}

		return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
	}
}
