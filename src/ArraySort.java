import java.util.Arrays;

public class ArraySort extends Sort {
    public ArraySort() {
        super();
        int[][] sort = new int[initial.length][];

        for (int i = 0; i < initial.length; i++) {
            sort[i] = new int[initial[i].length];
            System.arraycopy(initial[i], 0, sort[i], 0, initial[i].length);
        }

        for (int i = 0; i < sort.length; i++) {
            sw.startTimer();
            Arrays.sort(sort[i]);
            sw.stopTimer();

            if (i == 0) {
                // Print the test array (row 0)
                System.out.println("ArraySort - TEST array:");
                System.out.println("Before sorting:");
                show(initial[0]);
                System.out.println("\nAfter sorting:");
                show(sort[0]);
                System.out.println("Is it sorted? " + isSorted(sort[0]));
            } else {
                System.out.println("ArraySort - Array " + i + " (size " + sort[i].length +
                        "): " + sw.elapsedTime() + " ms");
            }
        }
    }
}
