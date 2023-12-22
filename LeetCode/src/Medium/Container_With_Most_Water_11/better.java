package Medium.Container_With_Most_Water_11;

public class better {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxSize = 0;

        while (left < right) {
            maxSize = Math.max(maxSize, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return maxSize;
    }
}
