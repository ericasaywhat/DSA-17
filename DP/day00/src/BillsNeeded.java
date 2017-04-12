import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BillsNeeded {

    int[] memo;

    private int billsNeededHelper (int N, int[] billDenominations, int[] memo) {
        int next;
        List<Integer> al = new ArrayList<>();
        if(N == 0) return 1;

        if (memo[N] != -1) return memo[N];

        for (int i = 0; i < billDenominations.length; i++) al.add(N-billDenominations[i]);
        next = Collections.min(al);

        if(next == 0) return 1;
        else if(next > 0){
            if (memo[next] != -1) return memo[next] +1;
            else memo[N] = billsNeeded(next, billDenominations) + 1;
        }
        return memo[N];

    }

    public int billsNeeded(int N, int[] billDenominations) {
        memo = new int[N];
        for (int i = 0; i < memo.length; i++) memo[i] = -1;

        return billsNeededHelper(N, billDenominations, memo);
    }
}
