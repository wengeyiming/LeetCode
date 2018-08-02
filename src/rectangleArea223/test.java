package rectangleArea223;

public class test {
	public static void main(String[] args) {
		int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;
		System.out.println(computeArea(A, B, C, D, E, F, G, H));
	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int sumArea = (C-A)*(D-B) + (G-E)*(H-F);		
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        int overlap = 0;
        if(right > left && top > bottom)
             overlap = (right - left) * (top - bottom);
        
        return sumArea - overlap;
	}
	
	private static boolean isOverLapping(int A, int B, int C, int D, int E, int F, int G, int H) {
		
		
		
		
		return false;
	}
}
