package Reverse_Vowels_of_a_String_345;

public class Solution3 {
    public static void main(String[] args) {
        String s = "leetcode";
        code(s);
    }

    private static void code(String s) {

        char[] word = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            //when the start pointer points vowel
            if (vowels.indexOf(word[start]) == -1) {
                start++;
            }

            //when the end pointer points vowel
            if (vowels.indexOf(word[end]) == -1) {
                end--;
            }

            if (start < end && vowels.indexOf(word[start]) != -1 && vowels.indexOf(word[end]) != -1) {
                char tmp = word[start];
                word[start] = word[end];
                word[end] = tmp;
                start++;
                end--;
            }

        }

        String ans = new String(word);
        System.out.println(ans);

    }
}
