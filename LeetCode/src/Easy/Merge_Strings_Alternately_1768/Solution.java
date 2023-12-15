package Easy.Merge_Strings_Alternately_1768;

public class Solution {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "qrs";
        mergeAlternately(word1, word2);
    }

    public static void mergeAlternately(String word1, String word2) {
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        StringBuilder ans = new StringBuilder();

        int l = sb1.length() <= sb2.length() ? sb1.length() : sb2.length();

        for (int i = 0; i < l; i++) {
            ans.append(sb1.charAt(i)).append(sb2.charAt(i));
        }

        if (sb1.length() != sb2.length()) {
            StringBuilder tmp = sb1.length() < sb2.length() ? sb2 : sb1;
            ans.append(tmp.substring(l));
        }


        System.out.println(ans);
    }
}
