package excelSheetColumnTitle168;

public class test {
    public static void main(String[] args) {
    	System.out.println(convertToTitle(52));
    }
	
	public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder("");
        
        while(n>0){
        	n--;
        	sb.append((char)('A' + n%26));
        	n = n/26;
        	//System.out.println(" " + n);
        }
        
        
        return sb.reverse().toString();
    }
}
