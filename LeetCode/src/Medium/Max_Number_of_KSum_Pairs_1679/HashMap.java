package Medium.Max_Number_of_KSum_Pairs_1679;

import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;

        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new java.util.HashMap<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = k - nums[i];
            if (map.containsKey(res)) {
                cnt++;
                if (map.get(res) == 1) map.remove(res);
                else map.put(res, map.get(res) - 1);
            } else {
                /*map.getOrDefault(map.get(nums[i]),0)+1
                this is because if nums[i] is in the map, get that value or put the value as 0 and add 1 to both of them.
                 */
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        return cnt;
    }

}
