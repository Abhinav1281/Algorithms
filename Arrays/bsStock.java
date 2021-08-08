
public class bsStock {
    static int oneSell(int ar[]) {
        int diff = ar[1] - ar[0];
        int min = ar[0];
        for (int i = 1; i < ar.length; i++) {
            diff = diff < ar[i] - min ? ar[i] - min : diff;
            min = ar[i] < min ? ar[i] : min;
        }
        return diff;
    }

    static int valleyPeak(int ar[]) {
        int max = 0;
        for (int i = 1; i < ar.length; i++)
            max += (ar[i] > ar[i - 1]) ? (ar[i] - ar[i - 1]) : 0;
        return max;
    }

    public static void main(String[] args) {
        int ar[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println("HIGHEST PROFIT from one sell one buy:" + oneSell(ar));
        System.out.println("Highest profit from valley peak:" + valleyPeak(ar));
    }

}
