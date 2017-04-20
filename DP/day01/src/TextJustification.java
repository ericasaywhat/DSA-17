import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static List<Integer> justifyText(String[] w, int m) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] memo = new int[w.length+1];
        int[] trace = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            trace[i] = -1;
            memo[i] = -1;
        }
        justifyTextHelper(w, memo, trace, m, 0);

        int i = 0;
        while(i<w.length) {
            answer.add(i);
            i = trace[i];

        }
        return answer;
    }

    private static int length(String[] w, int i , int j){
        int totalSum = 0;
        for (int k = i; k < j ; k++) totalSum += w[k].length() + 1;
        return totalSum - 1;
    }

    //calcuates how bad it is to have words of index i to j in a line
    private static int badnessLevel(String[] w, int i, int j, int m){
        if(length(w, i, j) > m) return Integer.MAX_VALUE;      //if they do not fit, then return largest integer
        return (int) Math.pow(m-length(w, i, j),3);       //if they fit return cost; cubed to avoid confusion
    }


    private static int justifyTextHelper (String[] w, int[] memo, int[] trace, int m, int i){
        //memo integer to cost , index
        // for j
        // if j is not in memo
        //helper j
        //else
        //c = memo j
        // c2 = badness of i j
        // if c2< current min
        // update min, index
        //memo i = c+c2


        if(memo[i] != -1) return memo[i];

        int minIndex = i+1;
        int currentMin = Integer.MAX_VALUE;
        int total;

        for (int j = i+1; j <= w.length; j++) {
            int c1 = justifyTextHelper(w,memo, trace, m, j);
            int c2 = badnessLevel(w,i,j,m);

            if(c2 == Integer.MAX_VALUE){
                total = Integer.MAX_VALUE;
            }
            else {
                total = c1+c2;
            }
            if(total<currentMin){
                currentMin = total;
                minIndex = j;
            }
        }
        memo[i] = currentMin;
        trace[i] = minIndex;
        return currentMin;

    }

}