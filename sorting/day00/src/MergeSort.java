import java.util.ArrayList;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 0;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     *
     * Best-case runtime: nlogn
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity: n
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] left = new int[array.length / 2];
        int[] right = new int[(array.length+1)/2];

        System.arraycopy(array, 0, left, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, right, 0, (array.length+1) / 2);

        left = sort(left);
        right = sort(right);

        return merge(left,right);
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     */
    public int[] merge(int[] a, int[] b) {
        int total = a.length+b.length;
        int[] sorted = new int[total];

        if(total <= INSERTION_THRESHOLD){
            InsertionSort insertionSort = new InsertionSort();
            System.arraycopy(a,0, sorted, 0, a.length);
            System.arraycopy(b,0,sorted, a.length, b.length);
            insertionSort.sort(sorted);
        } else {
            int i = 0,j = 0,k = 0;
            while(a.length > i && b.length >j){
                if(a[i]<=b[j]){
                    sorted[k] = a[i];
                    i++;
                    k++;
                } else if (a[i] > b[j]){
                    sorted[k] = b[j];
                    j++;
                    k++;
                }
            }
            if (i<a.length){
                for(int x = i; x<a.length; x++){
                    sorted[k] = a[x];
                    k++;
                }
            }else if (j<b.length){
                for(int x = j; x<b.length; x++){
                    sorted[k] = b[x];
                    k++;
                }
            }
        }
        return sorted;
    }

    public static void main (String args[]){
        MergeSort mergeSort = new MergeSort();
        int[] ar = new int[]{1,4,6,2,3,5};
        for(int i :mergeSort.sort(ar)){
            System.out.print(i);
        }
    }
}
