package Medium.Max_Number_of_KSum_Pairs_1679;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4};
        int k = 2;

        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        int cnt = 0;

        int n = nums.length;

        for (int i = 0; i <= n - 2; i++) {
            if (k > nums[i] && nums[i] != 0) {
                for (int j = i + 1; j <= n - 1; j++) {
                    if (nums[i] + nums[j] == k && nums[j] != 0) {
                        nums[i] = 0;
                        nums[j] = 0;
                        cnt++;
                        break;
                    }
                }
            }
        }


        return cnt;
    }
}
