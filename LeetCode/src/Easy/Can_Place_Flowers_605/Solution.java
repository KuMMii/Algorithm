package Easy.Can_Place_Flowers_605;

public class Solution {


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean[] check = new boolean[flowerbed.length];
        for (int i = 0; i < flowerbed.length; i++) {
            //1이면 true로 만들거임
            if (flowerbed[i] == 1) {
                //맨끝 애들 예외처리(1개 이상일 때)
                if (flowerbed.length > 1) {
                    if (i == 0) {
                        check[0] = true;
                        check[1] = true;
                    } else if (i == flowerbed.length - 1) {
                        check[flowerbed.length - 1] = true;
                        check[flowerbed.length - 2] = true;
                    } else {
                        check[i - 1] = true;
                        check[i] = true;
                        check[i + 1] = true;
                    }
                } else {
                    check[i] = true;
                }
            }
        }//for

        for (int i = 0; i < n; i++) {
            boolean planted = false;
            int idx = 0;
            while (idx != flowerbed.length) {
                //false 면 심기
                if (check[idx] == false) {
                    check[idx] = true;
                    if (idx > 0) check[idx - 1] = true;
                    if (idx < flowerbed.length - 1) check[idx + 1] = true;

                    planted = true;
//                    System.out.println("Arrays.toString(check) = " + Arrays.toString(check));
                    break;
                }


                idx++;
                if (idx == flowerbed.length && planted == false) {
//                    System.out.println("dd");
                    return false;
                }
            }


        }//for

        return true;
    }

    public static void main(String[] args) {
        int[] array = {
                1
        };
        System.out.println(canPlaceFlowers(array, 0));
    }
}
