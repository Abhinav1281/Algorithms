package Arrays;

/**
 * matrixRotation
 */
public class matrixRotation {

    static int[][] rotate(int ar[][], int n) {
        if (ar.length != ar[0].length) {
            System.out.println("NOT A SQUARE MATRIX");
            return ar;
        }
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (i < j) {
                    int temp = ar[i][j];
                    ar[i][j] = ar[j][i];
                    ar[j][i] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = ar[i][j];
                ar[i][j] = ar[i][n - 1 - j];
                ar[i][n - 1 - j] = temp;
            }
        }
        return ar;
    }

    static void printAr(int ar[][]) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++)
                System.out.print(ar[i][j] + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int ar[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        printAr(ar);
        System.out.println("ROTATED 90°:");
        rotate(ar, ar.length);
        printAr(ar);
        System.out.println("ROTATED 180°:");
        rotate(ar, ar.length);
        printAr(ar);
    }
}