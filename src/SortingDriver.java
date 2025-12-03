import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SortingDriver {
    public static void main(String[] args) {
        System.out.println("Sorting Algorithm Comparison");
        System.out.println();

        ArraySort as = new ArraySort();
        OnSqaredSort is = new OnSqaredSort();
        OnlognSort ms = new OnlognSort();


        ArraySort arraysSort = new ArraySort();
        OnSqaredSort insertionSort = new OnSqaredSort();
        OnlognSort mergeSort = new OnlognSort();

        // Get array sizes (skip index 0 which is the test array)
        int[] sizes = new int[arraysSort.initial.length - 1];
        for (int i = 1; i < arraysSort.initial.length; i++) {
            sizes[i - 1] = arraysSort.initial[i].length;
        }

        // Run 10 times and save to CSV
        try (PrintWriter writer = new PrintWriter(new FileWriter("sorting_results.csv"))) {
            // Write header
            writer.println("Run,Algorithm,Array,Time (ms)");

            for (int run = 1; run <= 50; run++) {
                // ArraysSort
                long[] arraysTimes = arraysSort.runTiming();
                for (int i = 0; i < arraysTimes.length; i++) {
                    writer.printf("%d,ArraysSort,Array %d (size %d),%d%n",
                            run, i + 1, sizes[i], arraysTimes[i]);
                }

                // InsertionSort
                long[] insertionTimes = insertionSort.runTiming();
                for (int i = 0; i < insertionTimes.length; i++) {
                    writer.printf("%d,InsertionSort,Array %d (size %d),%d%n",
                            run, i + 1, sizes[i], insertionTimes[i]);
                }

                // MergeSort
                long[] mergeTimes = mergeSort.runTiming();
                for (int i = 0; i < mergeTimes.length; i++) {
                    writer.printf("%d,MergeSort,Array %d (size %d),%d%n",
                            run, i + 1, sizes[i], mergeTimes[i]);
                }
            }

            System.out.println("\nResults written to sorting_results.csv");

        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }
}
