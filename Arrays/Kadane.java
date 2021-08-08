
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kadane {

    public static int MaxSubArrayNonNeg(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        int maxtemp = 0;
        for (int i : arr) {
            maxtemp += i;
            if (maxtemp < 0)
                maxtemp = 0;
            else if (max < maxtemp)
                max = maxtemp;
        }
        return max;
    }

    public static int MaxSubArray(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        int maxtemp = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            maxtemp = Math.max(arr.get(i), maxtemp + arr.get(i));
            max = Math.max(max, maxtemp);
            // System.out.println(max + ":" + maxtemp);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            array.add(sc.nextInt());
        }
        System.out.println("Maximum is:" + MaxSubArray(array));
        sc.close();
    }

}
