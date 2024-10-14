import java.util.Arrays;
import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Value: ");
        int v = scanner.nextInt();
        String[][] matrix = foo(v);
    }

    private static String[][] foo(int v) {

        if(v < 0) return foo(0);

        int width = (v+1)*2;
        int height = (v+1)*2;
        String[][] matrix = new String[width][height];

        for(int i = 0; i < (v+1); i++) {
            for(int j = 0; j <= v; j++) {
                String cell = "";

                if(i==0) {
                    cell = String.valueOf(v);
                } else if(j <= i) {
                    cell = String.valueOf(v - j);
                }

                if(j <= i) {
                    matrix[i][j] = cell;
                } else {
                    matrix[i][j] = matrix[i][j-1];
                }
                System.out.print(matrix[i][j] + " ");
            }

            for(int c = 0; c < width - (v+1); c++ ) {
                matrix[i][c+v+1] = matrix[i][v-c];
                System.out.print(matrix[i][c+v+1] + " ");
            }

            System.out.println();
        }

        for(int i = 0; i < height-v-1; i++) {
            matrix[i+v+1] = matrix[v-i];
            Arrays.stream(matrix[i+v+1]).forEach(s -> System.out.print(s+" "));
            System.out.println();
        }

        return matrix;
    }
}
