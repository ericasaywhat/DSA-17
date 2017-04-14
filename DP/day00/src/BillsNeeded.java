public class BillsNeeded {

    public int billsNeeded(int N, int[] billDenominations) {
        int[] memo = new int[N+1];
        for (int i = 0; i < memo.length; i++) memo[i] = -1;

        return billsNeededHelper(N, billDenominations, memo);
    }

    private int billsNeededHelper (int N, int[] billDenominations, int[] memo) {
        if(N==0) return 0;
        if(memo[N] != -1) return memo[N];

        int n = -1;
        for (int i = 0; i < billDenominations.length ; i++) {
            int nextSum = N-billDenominations[i];
            if((nextSum>=0) &&(n ==-1|| billsNeededHelper(nextSum, billDenominations, memo)< n))
                n=billsNeededHelper(nextSum, billDenominations, memo);
        }

        memo[N] = n+1 ; // min(DP[n-billdnominations]) +1

        return n+1;

    }


}
