package Greatest_Common_Divisor_of_Strings_1071;

public class Solution {
	public static void main(String[] args) {
		String str1="TAUXXTAUXXTAUXXTAUXXTAUXX";
		String str2="TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
		System.out.println(gcdOfStrings(str1,str2));
//		gcdOfStrings(str1,str2);
	}

	    public static String gcdOfStrings(String str1, String str2) {
	    	String s1=str1.length()>=str2.length() ? str1:str2;
	    	String s2=str1.length()<str2.length() ? str1:str2;
	    	
	        if(!s2.contains(s1.replace(s2, ""))) return "";
			else {
				int len=s2.length();
				for(int i=len-1; i>=2; i--) {
					if(s2.length() % i==0) {
						String t1=s2.substring(0,i);
						String t2=s2.substring(i,i*2);
						
						if(t1.equals(t2)) return t1;
					}
				}
				return str2;
			}
	    }
}
