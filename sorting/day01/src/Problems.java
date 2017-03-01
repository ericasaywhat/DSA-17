import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size()/2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size()/2-1))/2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        int index = 0;
        PriorityQueue<Integer> minPQ = minPQ();
        PriorityQueue<Integer> maxPQ = maxPQ();
        for (int i : inputStream) {
            if (minPQ.peek() == null) minPQ.offer(i);
            else if (i< maxPQ.peek()) maxPQ.offer(i);
            else minPQ.offer(i);

            if (maxPQ.size() < minPQ.size()) maxPQ.offer(minPQ.poll());
            else if (maxPQ.size() > minPQ.size()) minPQ.offer(maxPQ.poll());

            if (maxPQ.peek() == null){
                runningMedian[index] = (double) minPQ.peek();
                index ++;
            } else if (maxPQ.size() == minPQ.size()) {
                runningMedian[index] = (double) (maxPQ.peek()+minPQ.peek())/2;
                index++;
            } else if (maxPQ.size()>minPQ.size()){
                runningMedian[index] = (double) maxPQ.peek();
                index ++;
            } else {
                runningMedian[index] = (double) minPQ.peek();
                index++;
            }
        }
        return runningMedian;
    }

    public static void main(String args[]) {
        int[] thing = new int[] {1,2,3,4,5,6,7};
        double[] soln = runningMedianReallySlow(thing);
    }

}

