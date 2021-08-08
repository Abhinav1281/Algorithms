import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * MergeIntervals
 */
public class MergeIntervals {

    static Stack<int[]> reverse(Stack<int[]> s) {
        Stack<int[]> x = new Stack<>();
        while (!s.isEmpty()) {
            x.push(s.pop());
        }
        return x;
    }

    static void merge(int ar[][]) {
        Stack<int[]> st = new Stack<>();

        Arrays.sort(ar, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        st.push(ar[0]);

        for (int i = 1; i < ar.length; i++) {
            int[] top = st.peek();
            if (top[1] < ar[i][0]) {
                st.push(ar[i]);
            } else if (top[1] < ar[i][1]) {
                st.pop();
                top[1] = ar[i][1];
                st.push(top);
            }
        }
        st = reverse(st);
        System.out.println("\nThe merged intervals are:");
        while (!st.isEmpty()) {
            int[] inter = st.pop();
            System.out.print(inter[0] + "," + inter[1] + "\t");
        }
    }

    public static void main(String[] args) {
        int ar[][] = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
        merge(ar);
    }
}