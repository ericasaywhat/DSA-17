import java.util.*;


public class CoinsOnAClock {

    private static void backtrackCoins(int[] sublist, Map<Integer,Integer> possible, List<int[]> answers, int currentHour, int hoursInDay) {
        if ((possible.get(1) == 0 && possible.get(5) == 0)&& possible.get(10) == 0) {
            int[] copy = new int[sublist.length];
            System.arraycopy(sublist, 0, copy, 0, sublist.length);
            answers.add( copy);
            return;
        }
        if(sublist[currentHour%hoursInDay] != 0) return;

        for (int coinval : possible.keySet()) {
            if(possible.get(coinval) > 0){
                sublist[currentHour%hoursInDay] = coinval;
                possible.put(coinval, possible.get(coinval)-1);
                backtrackCoins(sublist, possible, answers, (currentHour+coinval)%hoursInDay, hoursInDay);
                sublist[currentHour%hoursInDay] = 0;
                possible.put(coinval,possible.get(coinval)+1);
            }


        }
        return;
    }

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        List<int[]> answers = new LinkedList<>();
        List<char[]> finalAnswer = new LinkedList<>();
        char[] finalCoins = new char[hoursInDay];
        Map<Integer,Integer> possible = new HashMap<>();

        possible.put(1,pennies);
        possible.put(5,nickels);
        possible.put(10,dimes);


        backtrackCoins(new int[hoursInDay], possible, answers,0, hoursInDay);

        //convert List char[] into int[]
        for(int[] coins : answers){
            for(int a = 0; a< coins.length; a++){
                if(coins[a] == 1) finalCoins[a] = 'p';
                if(coins[a] == 5) finalCoins[a] = 'n';
                if(coins[a] == 10) finalCoins[a] = 'd';
            }
            finalAnswer.add(Arrays.copyOf(finalCoins, finalCoins.length));
        }
        return finalAnswer;
    }

}
