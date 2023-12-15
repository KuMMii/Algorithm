package Easy.Reverse_Vowels_of_a_String_345;

public class Solution2 {
    public static void main(String[] args) {
        String s = "leetcode";
        code(s);
    }

    private static void code(String s) {

        StringBuilder sb = new StringBuilder(s);
        String[] word = new String[s.length()];
        word = s.split("");
        String vowels = "aeiouAEIOU";
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            //when the start pointer points vowel
            if (!vowels.contains(word[start])) {
                start++;
            }

            //when the end pointer points vowel
            if (!vowels.contains(word[end])) {
                end--;
            }

            if (start < end && vowels.contains(word[start]) && vowels.contains(word[end])) {
                sb.replace(start, start + 1, word[end]);
                sb.replace(end, end + 1, word[start]);
                start++;
                end--;
            }

        }

        System.out.println(sb.toString());

    }
}
