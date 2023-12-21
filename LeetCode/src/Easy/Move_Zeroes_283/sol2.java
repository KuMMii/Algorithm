package Easy.Move_Zeroes_283;

import java.util.Arrays;

public class sol2 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (p != i) {
                    int tmp = nums[p];
                    nums[p] = nums[i];
                    nums[i] = tmp;

                }
                p++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
