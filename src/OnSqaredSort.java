
// Bubble Sort algorithm adapted from https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/
// removed the swapped flag to make it closer to On^2
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
            bubbleSort(sort[i]);
            sw.stopTimer();

            if (i == 0) {
                // Print the test array (row 0)
                System.out.println("\nBubbleSort - TEST array");
                System.out.println("Before sorting:");
                show(initial[0]);
                System.out.println("\nAfter sorting:");
                show(sort[0]);
                System.out.println("Is sorted? " + isSorted(sort[0]));
            } else {
                System.out.println("BubbleSort - Array " + i + " (size " + sort[i].length +
                        "): " + sw.elapsedTime() + " ms");
            }
        }

    }
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        int i, j, temp;
        for (i = 0; i < 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
