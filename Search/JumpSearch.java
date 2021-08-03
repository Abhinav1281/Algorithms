package Search;

public class JumpSearch {

    int Search(int[] ar, int val) {
        int stepsS = (int) Math.sqrt(ar.length);
        int steps = stepsS;
        int prev = 0;
        while (ar[Math.min(steps, ar.length) - 1] < val) {
            prev = steps;
            steps += stepsS;
            if (prev >= ar.length)
                return -1;
        }
        while (ar[prev] < val) {
            prev++;
            if (prev == Math.min(steps, ar.length))
                return -1;
        }
        if (ar[prev] == val)
            return prev;
        return -1;
    }

}
