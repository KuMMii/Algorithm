package Medium.Max_Number_of_KSum_Pairs_1679;

import java.util.Arrays;

public class Order {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;

        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        int cnt = 0;
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (k <= nums[i]) break;
            while (j > i) {
                int sum = nums[i] + nums[j];
                if (sum == k) {
                    cnt++;
                    break;
                } else if (sum > k) j--;
                else i++;
            }
            i++;
            j--;

        }


        return cnt;
    }
}
