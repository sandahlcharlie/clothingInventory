// Bubble Sort algorithm adapted from https://www.geeksforgeeks.org/dsa/merge-sort/
public class OlognSort extends Sort {
    public OlognSort(){
        super();
        int[][] sort = new int[initial.length][];

        for (int i = 0; i < initial.length; i++) {
            sort[i] = new int[initial[i].length];
            System.arraycopy(initial[i], 0, sort[i], 0, initial[i].length);
        }
        for (int i = 0; i < sort.length; i++) {
            sw.startTimer();
            mergeSort(sort[i], 0, sort.length - 1);
            sw.stopTimer();

            if (i == 0) {
                // Print the test array (row 0)
                System.out.println("\nOlog(n)n algo mergeSort - TEST array");
                System.out.println("Before sorting:");
                show(initial[0]);
                System.out.println("\nAfter sorting:");
                show(sort[0]);
                System.out.println("Is sorted? " + isSorted(sort[0]));
            } else {
                System.out.println("mergeSort - Array " + i + " (size " + sort[i].length +
                        "): " + sw.elapsedTime() + " ms");
            }
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private void mergeSort(int arr[], int l, int r){

        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(int arr[], int l, int m, int r){

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
