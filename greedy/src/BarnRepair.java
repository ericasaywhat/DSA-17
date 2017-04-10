import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BarnRepair {
    public static int solve(int M, int S, int C, int[] occupied) {
        // M is the max number of boards that can be purchased
        //S is total number of stalls
        // C is number of cows
        // int[] occupied contains all stall numbers that are occupied

        // Calculate the minimum number of stalls that must be blocked in order to block all stalls with cows in them
        Arrays.sort(occupied);
        int total = S;
        PriorityQueue<Integer> EmptyBlocks = new PriorityQueue<>(S-C, Comparator.reverseOrder());
        for (int i = 1; i < occupied.length ; i++) {
            int emptyBlock = occupied[i]-occupied[i-1] -1;
            if(emptyBlock != 0) EmptyBlocks.offer(emptyBlock);
        }
        total -= occupied[0] -1;
        total -= S- occupied[C-1];
        while(!EmptyBlocks.isEmpty() && M>1){
            total -= EmptyBlocks.poll();
            M--;
        }

        return total;
    }
}
