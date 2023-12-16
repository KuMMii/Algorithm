package Medium.Increasing_Triplet_Subsequence_334;

public class Solution {

    static int minIdx, min, n, size;

    public static void main(String[] args) {
        int[] nums = {20, 100, 10, 12, 5, 13};

        System.out.println(increasingTriplet(nums));
    }

    private static boolean increasingTriplet(int[] nums) {
        //return false if the array is shorter than 3
        int n = nums.length;
        if (n < 3) return false;

        int p1 = 0;

        while (p1 >= n - 2) {


            p1++;
        }

        return false;

    }


}
