public class ReviewProblem {

    public static int minimumLengthSubArray(int[] A, int desiredSum) {
        int minLength = 0;

        for(int lo = 0; lo < A.length; lo++){
            int sum = A[lo];
            if (sum >= desiredSum) return 1;
            for (int hi = lo+1; hi < A.length; hi++){
                sum += A[hi];
                if (sum >= desiredSum) {
                    if(minLength == 0 || (hi-lo+1) < minLength) minLength = hi-lo+1;
                }
            }

        }
        return minLength;
    }

}
