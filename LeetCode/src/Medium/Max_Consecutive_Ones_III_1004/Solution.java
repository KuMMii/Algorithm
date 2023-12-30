package Medium.Max_Consecutive_Ones_III_1004;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    private static int longestOnes(int[] nums, int k) {
        int max = 0;
        int zeros = 0;
        int right;
        int left = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            if (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            if (zeros <= k) max = Math.max(max, right - left + 1);
        }

        return max;
    }


}
