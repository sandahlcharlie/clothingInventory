import java.util.Random;

public abstract class Sort {
    protected int[][] initial;
    public static final int TEST = 20;
    public Stopwatch sw;

    public Sort() {
        int[] sizes = {TEST, 100000, 200000, 300000, 400000, 500000};
        initial = new int[sizes.length][];
        Random r = new Random();

        for (int i = 0; i < sizes.length; i++) {
            initial[i] = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) {
                initial[i][j] = r.nextInt();
            }
        }
        sw = new Stopwatch();

    }

    public static int show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%20d%n", a[i]);
        }
        return a.length;
    }

    public boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int[] getArraySizes() {
        int[] sizes = new int[initial.length - 1];
        for (int i = 1; i < initial.length; i++) {
            sizes[i - 1] = initial[i].length;
        }
        return sizes;
    }
}