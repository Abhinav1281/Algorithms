import java.util.*;

public class KMP {
    static List<Integer> generatePi(String s) {
        List<Integer> ans = new ArrayList<>();
        int i = 1, j = 0;
        ans.add(0);
        for (i = 1; i < s.length(); i++) {
            j = ans.get(i - 1);
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = ans.get(j--);
            if (s.charAt(i) == s.charAt(j))
                j += 1;
            ans.add(j);
        }
        return ans;
    }

    static int search(String s, String pat) {
        int ans = -1;
        int j = 0;
        List<Integer> pi = generatePi(s);
        for (int i : pi)
            System.out.print(i + "\t");
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == pat.length())
                return i - j;
            else if (i < s.length() && pat.charAt(j) != s.charAt(i)) {
                if (j == 0)
                    i++;
                else {
                    j = pi.get(j - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String o = "abcababd";
        String s = "abd";

        System.out.println("\n" + search(o, s));
    }
}
