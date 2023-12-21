package Easy.Is_Subsequence_392;

public class Solution {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {

        //if s is null
        if (s.length() == 0) return true;
        //if t is shorter than s
        if (s.length() > t.length()) return false;


        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (sChar[i] == tChar[j]) i++;
            j++;

        }//while

        return i == s.length();
    }
}
