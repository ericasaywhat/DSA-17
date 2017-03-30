import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CoinsOnAClock {

    private static void backtrackCoins(char[] sublist, List<Integer> possible, List<char[]> answers, List<Character> clock) {
        if (possible.isEmpty()) {
            if (!answers.contains(sublist)) answers.add(Arrays.copyOf(sublist, sublist.length));
            return;
        }
//        for (int i = 0; i < possible.size(); i++) {
//            int num = possible.get(i);
//            if(){
//                sublist.add(num);
//                possible.remove(i);
//                backtrackCoins(sublist, possible, answers, clock);
//                sublist.remove(sublist.indexOf(num));
//                possible.add(i, num);
//            }
//        }
        return;
    }

    private static List<Integer> createList(int pennies, int nickels, int dimes, List<Integer> al){
        if((pennies == 0){
            if (nickels == 0){
                al.add(10);
                return createList(pennies, nickels, dimes-1, al);
                if (dimes == 0){
                    return al;
                }
            }
        }
    }

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        List<char[]> answers = new LinkedList<>();
        ArrayList<Integer> possible = new ArrayList<>();
        for(int i = 1; i<=pennies; i++)
        backtrackCoins();


        // TODO
        return null;
    }

}
