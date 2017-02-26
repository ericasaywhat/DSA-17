
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * Best-case runtime: n
     * Worst-case runtime: n^2
     * Average-case runtime: n^2
     *
     * Space-complexity: 1
     */
    @Override
    public int[] sort(int[] array) {
        int j;
        for (int i = 0; i < array.length; i++){
            j=i;
            while (j>0 && array[j]<array[j-1]){
                swap(array, j, j-1);
                j--;
            }
        }
        return array;
    }
}
