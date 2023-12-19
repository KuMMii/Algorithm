package Medium.Move_Zeroes_283;

import java.util.Arrays;

public class sol3 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        int snowball = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowball++;
            } else if (snowball > 0) {
                int tmp = nums[i];
                nums[i] = nums[i - snowball];
                nums[i - snowball] = tmp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
