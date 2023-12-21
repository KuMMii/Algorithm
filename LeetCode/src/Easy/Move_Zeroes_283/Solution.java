package Easy.Move_Zeroes_283;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0; //zero pointer, non-zero pointer
        int n = nums.length;
        //loop until any pointer is at the end
        while (p1 < n && p2 < n) {
            while (nums[p1] != 0 && p1 < n - 1) p1++;
            while ((nums[p2] == 0 || p1 >= p2) && p2 < n - 1) p2++;

            if (nums[p1] == 0 && nums[p2] != 0) {
                int tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = tmp;

            }
            p1++;
            p2++;

//            System.out.println("p1 = " + p1);
//            System.out.println("p2 = " + p2);
        }
        System.out.println("nums = " + Arrays.toString(nums));

    }
}
