package Medium.Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length_1456;

public class Solution {
    public static void main(String[] args) {
        String s = "rythms";
        int k = 4;
        System.out.println(maxVowels(s, k));
    }

    private static int maxVowels(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int max = 0;
        String vowels = "aeiou";
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(chars[i]) >= 0) cnt++;

        }//for i
        max = Math.max(cnt, max);

        for (int i = k; i < n; i++) {
            if (vowels.indexOf(chars[i - k]) >= 0) cnt--;
            if (vowels.indexOf(chars[i]) >= 0) cnt++;

            max = Math.max(cnt, max);
        }

        return max;
    }
}
