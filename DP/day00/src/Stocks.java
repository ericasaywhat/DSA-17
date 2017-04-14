public class Stocks {

    public int maxProfit(int[] prices) {
        int min = -1;
        int max = -1;
        int maxInd = 0;
        for (int i = 0; i < prices.length; i++) {
            if(max == -1 || prices[i]>=max){
                maxInd = i;
                max = prices[i];
            }
        }
        for (int i = 0; i < prices.length ; i++) {
            if(i<= maxInd && (min == -1 || prices[i]<=min)) min = prices[i];
        }

        if(min == -1 && max == -1) return 0;
        return max - min;
    }

    public int maxProfitWithK(int[] prices, int k) {
        int totalProfit = 0;
        while(k>0){
            int min = -1;
            int max = -1;
            int maxInd = 0;
            int minInd = 0;
            for (int i = 0; i < prices.length ; i++) {
                if(prices[i] >=0 && (min == -1 || prices[i]<=min)){
                    min = prices[i];
                    minInd = i;
                }
            }
            prices[minInd] = -1;
            for (int i = 0; i < prices.length; i++) {
                if(i>= minInd &&(max == -1 || prices[i]>=max)){
                    maxInd = i;
                    max = prices[i];
                }
            }
            prices[maxInd] = -1;

            if(min != -1 && max != -1) totalProfit +=(max-min);
            k--;
        }
        return totalProfit;
    }

}
