import java.util.Random;

public class QuickSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 0;

    /**
     * Best-case runtime: nlogn
     * Worst-case runtime: n^2
     * Average-case runtime:nlogn
     *
     * Space-complexity: logn (function calls take up space)
     */
    @Override
    public int[] sort(int[] array) {
        array = shuffle(array);
        quickSort(array, 0, array.length-1);
        return array;
    }

    public int[] shuffle (int[] array){
        Random random = new Random();
        for (int i = 0; i< array.length; i++){
            int j = random.nextInt(i+1);
            swap(array, i, j);
        }
        return array;

    }

    /**
     * Partition the array around a pivot, then recursively sort the left and right
     * portions of the array. A test for this method is provided in `SortTest.java`
     * Optional: use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * @param low The beginning index of the subarray being considered (inclusive)
     * @param high The ending index of the subarray being considered (inclusive)
     */
    public void quickSort(int[] a, int low, int high) {
        if (a.length <= INSERTION_THRESHOLD){
            InsertionSort insertionSort = new InsertionSort();
            insertionSort.sort(a);
        } else {
            if(low<high){
                int r = partition(a, low, high);

                quickSort(a, low, r-1);
                quickSort(a, r+1, high );
            }

        }
    }


    /**
     * Given an array, choose the array[low] element as the "pivot" element.
     * Place all elements smaller than "pivot" on "pivot"'s left, and all others
     * on its right. Return the final position of "pivot" in the partitioned array.
     *
     * @param low The beginning index of the subarray being considered (inclusive)
     * @param high The ending index of the subarray being considered (inclusive)
     */
    public int partition(int[] array, int low, int high) {
        int i,j;
        i = low;
        int pivot = array[low];

        for (j = low+1; j <= high; j++){
            if (array[j]<pivot){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, low,i);
        return i;
    }

}
