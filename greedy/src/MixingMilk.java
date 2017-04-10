import java.util.ArrayList;
import java.util.Collections;

public class MixingMilk {
    public static int solve(int M, int N, int[] units, int[] price) {
        ArrayList<Integer> copyPrice = new ArrayList<>();
        int totalPrice = 0;
        for(int i : price) copyPrice.add(i);
//        int filler = Collections.max(copyPrice) + 1;
        while(M > 0) {
            int filler = Collections.max(copyPrice) + 1;

            int minPrice = Collections.min(copyPrice);
            int index = copyPrice.indexOf(minPrice);
            if(units[index] < M && units[index] > 0) {
                totalPrice += minPrice*units[index];
                M -= units[index];
                copyPrice.remove(index);
                copyPrice.add(index, filler);
                units[index] = -1;
            } else {
                totalPrice += minPrice*M;
                return totalPrice;
            }

        }


        return totalPrice;
    }
}
