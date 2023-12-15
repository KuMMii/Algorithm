package Easy.Can_Place_Flowers_605;

public class canplaceflowers_better {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        //n>0
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftEmptyPot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean rightEmptyPot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (leftEmptyPot && rightEmptyPot) {
                    flowerbed[i] = 1;
                    n--;
                }

                if (n == 0) return true;


            }
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
