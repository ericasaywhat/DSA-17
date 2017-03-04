import static sun.swing.MenuItemLayoutHelper.max;


public class CountingSort {

    /**
     * Use counting sort to sort positive integer array A.
     * <<<<<<< HEAD
     * Runtime: O(n+k)
     */
    static void countingSort(int[] A) {
        int k = max(A);
        int[] counts = new int[k + 1];
        for (int i : A) {
            counts[i]++;
        }
        int a = 0;
        for (int j = 0; j <= k; j++) {      //runtime k
            while (counts[j] > 0) {       //runtime n; independent of each other
                A[a] = j;
                a++;
                counts[j]--;
            }
        }

    }
}
