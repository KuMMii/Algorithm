package Reverse_Vowels_of_a_String_345;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        code(s);
    }

    private static void code(String s) {
        List<Integer> listForIdx = new ArrayList<>();
        List<Character> listForChar = new ArrayList<>();

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' ||s.charAt(i) == 'e' ||s.charAt(i) == 'i' ||s.charAt(i) == 'o' ||s.charAt(i) == 'u'
                    || s.charAt(i) =='A' || s.charAt(i) =='E' || s.charAt(i) =='I' ||s.charAt(i) == 'O' || s.charAt(i) =='U') {
                listForIdx.add(i);
                listForChar.add(s.charAt(i));
            }
        }//for

        //reverse the list of char
        Collections.reverse(listForChar);

        for (int i = 0; i < listForIdx.size(); i++) {
            int idx = listForIdx.get(i);
            sb.replace(idx, idx+1, listForChar.get(i).toString());
        }

        System.out.println(sb.toString());

    }
}
