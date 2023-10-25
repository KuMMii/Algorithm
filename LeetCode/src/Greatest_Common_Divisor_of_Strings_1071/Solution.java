package Greatest_Common_Divisor_of_Strings_1071;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		System.out.println(method("ABCDEF","ABC"));
		
	}

	private static String method(String str1, String str2) {
		if(!str2.contains(str1.replace(str2, ""))) return "";
		else {
			int len=str2.length();
			for(int i=len-1; i>=2; i--) {
				if(str2.length() % i==0) {
					String t1=str2.substring(0,i);
					String t2=str2.substring(i,i*2);
					if(t1.equals(t2)) return t1;
				}
			}
			return str2;
		}
	}
}
