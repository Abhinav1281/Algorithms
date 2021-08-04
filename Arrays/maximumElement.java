package Arrays;

import java.util.ArrayList;
import java.util.*;

class Node {
    int val;
    int count = 0;
    Node left = null;
    Node right = null;

}

public class maximumElement {
    static int ma = 0;
    static int maxele = 0;

    static Node newnode(int v) {
        Node temp = new Node();
        temp.val = v;
        temp.count = 1;
        temp.left = temp.right = null;
        return temp;
    }

    static Node insert(Node node, int val) {
        if (node == null) {
            if (ma == 0)
                ma = 1;
            return newnode(val);
        }

        if (val < node.val)
            node.left = insert(node.left, val);
        else if (val > node.val)
            node.right = insert(node.right, val);
        else
            node.count++;

        ma = Math.max(ma, node.count);
        return node;
    }

    static void inorder(Node node, int s) {
        if (node != null) {
            inorder(node.left, s);

            if (node.count >= s / 2) {
                maxele = node.val;
                return;
            }
            // System.out.println(node.val);
            inorder(node.right, s);
        }
    }

    static int withSpace(List<Integer> arr) {
        Node root = null;
        int s = arr.size();
        for (int i : arr) {
            root = insert(root, i);
        }
        if (ma >= s / 2) {
            inorder(root, s);
            return maxele;
        } else
            return -1;
    }

    static int withoutSpace(List<Integer> arr) {
        for (int i : arr) {
            int count = 0;
            for (int j : arr)
                if (j == i)
                    count++;
            if (count >= arr.size() / 2)
                return i;
        }
        return -1;
    }

    static int moore(List<Integer> arr) {
        int maxI = 0;
        int maxC = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (maxC == 0) {
                maxI = i;
                maxC = 1;
            } else if (arr.get(maxI) == arr.get(i))
                maxC++;
            else
                maxC--;
        }
        int cCount = 0;
        for (int i : arr) {
            if (arr.get(maxI) == i)
                cCount++;
        }
        if (cCount >= arr.size() / 2)
            return arr.get(maxI);
        else
            return -1;
    }

    public static void main(String[] args) {
        Integer ar[] = { 1, 2, 2, 1, 3, 5, 2 };
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(ar));
        System.out.println(withoutSpace(arr));
        System.out.println(withSpace(arr));
        System.out.println(moore(arr));
    }

}
