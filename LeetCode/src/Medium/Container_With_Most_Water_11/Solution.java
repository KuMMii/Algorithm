package Medium.Container_With_Most_Water_11;

public class Solution {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {

        int n = height.length;

        //if the size of array is 2
        if (n == 2) {
            return Math.min(height[0], height[1]);
        }

        int maxP = Integer.MIN_VALUE;
        int maxSize = Integer.MIN_VALUE;

        //loop until before the end
        for (int p = 0; p <= n - 2; p++) {
            //if the stick is taller than the maxP
            if (maxP < height[p]) {
                for (int j = n - 1; j >= p + 1; j--) {
                    int size = (j - p) * Math.min(height[p], height[j]);
                    maxSize = Math.max(size, maxSize);
                    maxP = height[p];
                }
            }
        }

        return maxSize;

    }
}
