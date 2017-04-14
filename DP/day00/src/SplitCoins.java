public class SplitCoins {

    private static int min(int x, int y){
        if(x<=y) return x;
        else return y;
    }

    public static int splitCoins(int[] coins) {
        int totalSum = 0;
        for (int i = 0; i < coins.length ; i++) totalSum+= coins[i];
        int[][] memo = new int[coins.length][totalSum];
        for (int i = 0; i <coins.length ; i++) {
            for (int j = 0; j < totalSum ; j++) memo[i][j] = -1;
        }
        return splitCoinsHelper(coins, memo, 0, 0, totalSum);
    }

    private static int splitCoinsHelper(int[] coins, int[][] memo, int i, int s, int totalSum){
        if (i == coins.length-1) return Math.abs(2*s-totalSum);
        if (memo[i][s] != -1) return memo[i][s];
        int answer = min(splitCoinsHelper(coins, memo, i+1, s, totalSum), splitCoinsHelper(coins, memo, i+1,s+coins[i],totalSum));
        memo[i][s] = answer;

        return answer;
    }



}

