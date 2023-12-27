package Medium.Max_Consecutive_Ones_III_1004;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        longestOnes(nums, k);
    }

    private static int longestOnes(int[] nums, int k) {
        int[] idxArr = new int[nums.length];
        int idxCnt = 0;
        int max = 0;

        //1. check ans save 0's index at an array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                idxArr[idxCnt++] = i;
            }
        }//for

        //2. sliding window
        int[] zeros = new int[k];
        for (int i = 0; i < k; i++) {
            zeros[i] = idxArr[i];
        }
        max=Math.max(max,slidingWindow(zeros,nums));

        for (int i = k; i < idxCnt; i++) {
            zeros[i]
        }

        return max;
    }

    private static int slidingWindow(int[] zeros, int[] nums) {
        int cnt=0;
        int max=0;

        for (int idx : zeros) {
            nums[idx]=1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1) cnt++;
            else cnt=0;
            max = Math.max(max, cnt);
        }

        return max;

    }

}
