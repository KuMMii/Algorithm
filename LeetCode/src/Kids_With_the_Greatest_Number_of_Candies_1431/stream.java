package Kids_With_the_Greatest_Number_of_Candies_1431;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class stream {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max= Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(candy->candy+extraCandies>=max).collect(Collectors.toList());
    }

}
