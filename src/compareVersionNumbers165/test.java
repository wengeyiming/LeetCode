package compareVersionNumbers165;

public class test {
	public static void main(String[] args) {
		String version1 = new String("1.3.3");
		String version2 = new String("1.3.2");
		System.out.println(compareVersion(version1, version2));
	}
	
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length,v2.length);
        for(int i=0;i<len;i++){
            int c1 = 0;
            int c2 = 0;
            if(v1.length>i) c1 = Integer.parseInt(v1[i]);
            if(v2.length>i) c2 = Integer.parseInt(v2[i]);            
            if(c1>c2) return 1;
            if(c2>c1) return -1;
        }
        return 0;
    }
	
	/*
    public static int compareVersion(String version1, String version2) {
        char[] v1 = version1.trim().toCharArray();
        char[] v2 = version2.trim().toCharArray();
        
        int i = 0;
        while(v1.length > i && v2.length > i) {
        	if(v1[i] > v2[i]) return 1;
        	else if(v1[i] < v2[i]) return -1;
        	else {
        		i++;
        		continue;
        	}
        }
        
        if(v1.length > i) {
        	while(v1.length > i) {
        		if(v1[i] != '0') return 1;
        		i++;
        	}
        }
        
        if(v2.length > i) {
        	while(v2.length > i) {
        		if(v2[i] != '0') return -1;
        		i++;
        	}
        }
        
        return 0;
    }
    */
}
