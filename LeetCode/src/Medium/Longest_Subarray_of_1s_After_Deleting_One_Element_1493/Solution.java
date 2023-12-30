package Medium.Longest_Subarray_of_1s_After_Deleting_One_Element_1493;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(longestSubarray(nums));
    }

    private static int longestSubarray(int[] nums) {
        int max = 0;
        int left = 0;
        int right;
        int zero = 0;

        //change a size of a window
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zero++;

            if (zero > 1) {
                if (nums[left] == 0) zero--;
                left++;
            }

            if (zero <= 1) max = Math.max(max, right - left);
        }


        return max == nums.length ? max - 1 : max;
    }
}
