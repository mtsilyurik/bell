import java.sql.SQLOutput;
import java.util.Scanner;


public class Task_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Width: ");
        int width = sc.nextInt();

        System.out.print("Height: ");
        int height = sc.nextInt();

        int[][] matrix = initRandom(new int[width][height]);

        System.out.println(minDiag(matrix));

    }

    private static int[][] initRandom(int[][] matrix) {

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        return matrix;
    }

    private static int minDiag(int[][] matrix) {
        int minDiag = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if(i != matrix.length / 2) {
                minDiag = Math.min(minDiag, matrix[matrix.length - 1-i][i]);
            }
        }
        return minDiag;
    }
}
