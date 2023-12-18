package Medium.String_Compression_443;

public class betterOne {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'a', 'a'};

        System.out.println(compress(chars));
    }

    private static int compress(char[] chars) {
        int pointer = 0;
        int idx = 0;

        while (idx < chars.length) {
            int charLength = 1;
            while (chars[pointer] == chars[pointer + charLength] && pointer + charLength < chars.length) {
                charLength++;
            }
            chars[idx++] = chars[pointer];
            if (charLength > 1) {
                for (char c : String.valueOf(charLength).toCharArray()) {
                    chars[idx++] = c;
                }
            }
            pointer += charLength;
        }//while
        return idx;
    }
}
