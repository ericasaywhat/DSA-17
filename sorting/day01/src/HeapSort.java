public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Recursively corrects the position of element indexed i: check children, and swap with larger child if necessary.
    public void heapify(int i) {
        if(leftChild(i)<size){
            if (rightChild(i)< size){
                if(heap[leftChild(i)] >= heap[rightChild(i)]) {
                    if(heap[i]<heap[leftChild(i)]){
                        swap(heap, i, leftChild(i));
                        heapify(leftChild(i));
                    }
                } else {
                    if (heap[i] < heap[rightChild(i)]) {
                        swap(heap, i, rightChild(i));
                        heapify(rightChild(i));
                    }
                }
            } else {
                if(heap[i]<heap[leftChild(i)]){
                    swap(heap, i, leftChild(i));
                    heapify(leftChild(i));
                }
            }

        }



    }

    // Given the array, build a heap by correcting every non-leaf's position.
    public void buildHeapFrom(int[] array) {
        this.heap = array;
        this.size = array.length;
        for(int i = size/2; i > -1; i--){
            heapify(i);
        }
    }

    /**
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        buildHeapFrom(array);
        for (int i=size-1; i>0; i--) {
            swap(heap, 0, i);
            size--;
            heapify(0);
        }
        return heap;
    }
}
