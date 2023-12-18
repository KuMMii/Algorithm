package Medium.String_Compression_443;

public class Solution {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'a', 'a'};

        System.out.println(compress(chars));
    }

    private static int compress(char[] chars) {
        int n = chars.length;

        if (n == 1) return 1;


        StringBuilder s = new StringBuilder();
        int p1 = 0;

        outer:
        while (p1 < n) {
            s.append(chars[p1]);
            //if the pointer is at the end of the array, just finish the loop
            if (p1 >= n - 1) break;

            int cnt = 1;
            int p2 = p1 + 1;

            while (true) {
                //if they are consecutive repeating chars and p2 is not at the end
                if (chars[p1] == chars[p2] && p2 < n - 1) {
                    p2++;
                    cnt++;
                } else if (chars[p1] == chars[p2] && p2 >= n - 1) {
                    cnt++;
                    if (cnt != 1) s.append(cnt);
                    break outer;
                }
                //if not
                else {
                    if (cnt != 1) s.append(cnt);
                    p1 = p2;
                    break;
                }
            }//while for p2
        }// while for p1

        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }


        return s.length();
    }
}
