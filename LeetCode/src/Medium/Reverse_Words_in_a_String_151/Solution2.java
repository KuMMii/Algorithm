package Medium.Reverse_Words_in_a_String_151;

public class Solution2 {
    public static void main(String[] args) {
        String s = "  hello world  ";
        reverseWords(s);
    }

    public static String reverseWords(String s) {

        int n = s.length();

        //pointer 만들기
        int p1 = n - 1;

        //char[]
        char[] chars = s.toCharArray();

        //sb to return
        StringBuilder sb = new StringBuilder();

        //loop to the first of the s
        while (p1 >= 0) {
            if (chars[p1] == ' ') {
                p1--;
                continue;
            }
            //if it is not a space
            int p2 = p1 - 1;

            while (p2 >= 0 && chars[p2] != ' ') {
                p2--;
            }
            sb.append(s.substring(p2 + 1, p1 + 1));
            sb.append(' ');
            p1 = p2 - 1;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
