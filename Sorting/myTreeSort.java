package Sorting;

public class myTreeSort {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };

        treeSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static void treeSort(int[] arr) {

        Node root = null;

        for (int num : arr) {
            root = insertNode(root, num);
        }

        inOrderFill(root, arr, 0);

    }

    public static int inOrderFill(Node root, int[] arr, int index) {
        if (root != null) {
            index = inOrderFill(root.left, arr, index);
            arr[index++] = root.key;
            index = inOrderFill(root.right, arr, index);
        }
        return index;
    }

    public static Node insertNode(Node root, int k) {
        if (root == null)
            return new Node(k);

        if (k < root.key)
            root.left = insertNode(root.left, k);

        else
            root.right = insertNode(root.right, k);

        return root;
    }
}

class Node {
    int key;
    Node left;
    Node right;

    public Node(int k) {
        this.key = k;
    }
}