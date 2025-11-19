
// Bubble Sort algorithm adapted from https://www.geeksforgeeks.org/dsa/insertion-sort-algorithm/
public class OnSqaredSort extends Sort {
    public OnSqaredSort(){
        super();
        int[][] sort = new int[initial.length][];

        for (int i = 0; i < initial.length; i++) {
            sort[i] = new int[initial[i].length];
            System.arraycopy(initial[i], 0, sort[i], 0, initial[i].length);
        }
        for (int i = 0; i < sort.length; i++) {
            sw.startTimer();
            insertionSort(sort[i]);
            sw.stopTimer();

            if (i == 0) {
                // Print the test array (row 0)
                System.out.println("\nO(n^2) algo insertionSort - TEST array");
                System.out.println("Before sorting:");
                show(initial[0]);
                System.out.println("\nAfter sorting:");
                show(sort[0]);
                System.out.println("Is sorted? " + isSorted(sort[0]));
            } else {
                System.out.println("insertionSort - Array " + i + " (size " + sort[i].length +
                        "): " + sw.elapsedTime() + " ms");
            }
        }

    }

    public long[] runTiming() {
        long[] times = new long[initial.length - 1];

        for (int i = 1; i < initial.length; i++) {
            int[] arr = new int[initial[i].length];
            System.arraycopy(initial[i], 0, arr, 0, initial[i].length);

            sw.startTimer();
            insertionSort(arr);
            sw.stopTimer();

            times[i - 1] = sw.elapsedTime();
        }

        return times;
    }

    private void insertionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
