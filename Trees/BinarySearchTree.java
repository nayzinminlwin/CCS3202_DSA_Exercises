package Trees;

import java.util.Arrays;

public class BinarySearchTree {

    public static void main(String[] args) {
        // 12, 22, 8, 19, 10, 9, 20, 4, 2, 6
        int[] intArr = { 12, 22, 8, 19, 10, 9, 20, 4, 2, 6 };
        intArr = new int[] { 70, 60, 80, 50, 65, 75, 85, 45, 55, 90 };
        intArr = new int[] { 14, 23, 7, 10, 33, 56, 80, 66, 70 };

        Node myTree = null;

        for (int i : intArr) {
            myTree = Node.InsertNodeBST(myTree, i);
        }

        System.out.println("Original array : " + Arrays.toString(intArr));

        System.out.print("NLR : ");
        Node.preOrderBST(myTree);

        System.out.println();

        System.out.print("LNR : ");
        Node.inOrderBST(myTree);

        System.out.println();

        System.out.print("LRN : ");
        Node.postOrderBST(myTree);

        System.out.println();
        System.out.println(Node.searchBST(myTree, 6));

        myTree.calculateHeight();
        System.out.println(myTree.getHeight());

    }

}
