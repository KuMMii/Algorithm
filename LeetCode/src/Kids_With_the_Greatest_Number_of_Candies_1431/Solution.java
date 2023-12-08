package Kids_With_the_Greatest_Number_of_Candies_1431;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        candies =new int[]{2,3,5,1,3};
        extraCandies = 3;

        int MAX=0;
        for (int candy : candies) {
            MAX = Math.max(candy, MAX);
        }

        List<Boolean> ans=new ArrayList<>();

        for (int i=0; i<candies.length;i++) {
            if (candies[i]+extraCandies>=MAX) ans.add(i,true);
            else ans.add(i,false);
        }

        return ans;
    }
}