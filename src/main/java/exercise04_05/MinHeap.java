package exercise04_05;

public class MinHeap {
    private int[] heap; // the array to store the heap
    private int maxsize; // the size of the array
    private int size; // the current number of elements in the array

    /**
     * Constructor for the min heap
     * @param array of keys
     */
    public MinHeap(int[] array) {
        maxsize = array.length + 1;
        heap = new int[maxsize];
        for (int i = 1; i <= array.length; i++)
           heap[i] = array[i-1] ;
        size = array.length;
        heap[0] = Integer.MIN_VALUE;
        buildFromTheBottomUp();

    }

    /**
     * Fix the heap from the bottom up
     */
    public void buildFromTheBottomUp() {
       // FILL IN CODE: iterate over internal nodes from right to left
        // and call pushdown

    }

    /** Return the index of the left child of the element at index pos
     *
     * @param pos the index of the element in the heap array
     * @return the index of the left child
     */
    private int leftChild(int pos) {
        return 2 * pos;
    }

    /** Return the index of the right child
     *
     * @param pos the index of the element in the heap array
     * @return the index of the right child
     */
    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    /** Return the index of the parent
     *
     * @param pos the index of the element in the heap array
     * @return the index of the parent
     */
    private int parent(int pos) {
        return pos / 2;
    }

    /** Returns true if the node in a given position is a leaf
     *
     * @param pos the index of the element in the heap array
     * @return true if the node is a leaf, false otherwise
     */
    private boolean isLeaf(int pos) {
        return ((pos > size / 2) && (pos <= size));
    }

    /** Swap given elements: one at index pos1, another at index pos2
     *
     * @param pos1 the index of the first element in the heap
     * @param pos2 the index of the second element in the heap
     */
    private void swap(int pos1, int pos2) {
        int tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }


    /** Print the array that stores the heap */
    public void print() {
        int i;
        for (i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    /** Remove minimum element (it is at the top of the minHeap)
     *
     * @return the smallest element in the heap
     */
    public int removeMin() {
        swap(1, size); // swap the end of the heap into the root
        size--;  	   // removed the end of the heap
        // fix the heap property - push down as needed
        if (size != 0)
            pushdown(1);
        return heap[size + 1];
    }

    /** Push the value down the heap if it does not satisfy the heap property
     *
     * @param position the index of the element in the heap
     */
    private void pushdown(int position) {
        int smallestChild;
        while (!isLeaf(position)) {
            smallestChild = leftChild(position);
            if (smallestChild + 1 <= size) {
                if (heap[smallestChild + 1] < heap[smallestChild])
                    smallestChild = smallestChild + 1;
            }
            if (heap[position] < heap[smallestChild])
                return;
            swap(position, smallestChild);
            position = smallestChild;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 1, 12, 34, 4, 2, 8, 6, 0};
        MinHeap minheap = new MinHeap(arr);
        minheap.print(); //0 5 1 6 9 4 2 8 12 34
        /*
                       0
                5             1
            6       9      4    2
          8   12  34

        */

    }

}

