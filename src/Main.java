import java.util.Arrays;

/**
 * Клас Mainn містить логіку для обчислення суми двох матриць розміром N x M.
 * Уникає явних циклів — використовує методи класу Arrays.
 * 
 * @author Пічугін Ярослав
 */
public class Main {

    /**
     * Повертає суму двох матриць однакового розміру.
     *
     * @param a перша матриця
     * @param b друга матриця
     * @return матриця-сума
     * @throws IllegalArgumentException якщо розміри не збігаються
     */
    public static int[][] addMatrices(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            throw new IllegalArgumentException("Матриці мають бути однакового розміру");
        }

        return Arrays.stream(a)
                .map(row -> new int[row.length])
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matrixB = {
            {7, 8, 9},
            {10, 11, 12}
        };

        // Обчислення суми 
        int[][] result = Arrays.stream(matrixA)
            .map(int[]::clone)
            .toArray(int[][]::new);

        Arrays.setAll(result, i -> {
            int[] rowSum = new int[matrixA[0].length];
            Arrays.setAll(rowSum, j -> matrixA[i][j] + matrixB[i][j]);
            return rowSum;
        });

        // Виведення результату
        Arrays.stream(result).map(Arrays::toString).forEach(System.out::println);
    }
}
