package Trees;

import java.util.Arrays;

public class BinarySearchTree {

    public static void main(String[] args) {
        // 12, 22, 8, 19, 10, 9, 20, 4, 2, 6
        int[] intArr = { 12, 22, 8, 19, 10, 9, 20, 4, 2, 6 };
        Node myTree = null;

        for (int i : intArr) {
            if (myTree == null) {
                myTree = new Node(i);
            } else {
                recursiveBinaryInsert(myTree, i);
            }
        }

        System.out.println("Original array : " + Arrays.toString(intArr));
        System.out.print("Sorted array : ");
        Node.inorder(myTree);

    }

    public static void recursiveBinaryInsert(Node currentNode, int newVal) {
        if (newVal < currentNode.getCurrentNode()) {
            if (currentNode.getLeftChild() == null) {
                currentNode.addLeftChild(new Node(newVal, currentNode));
                System.out.printf("%d inserted left to parent : %d\n", newVal, currentNode.getCurrentNode());
            } else {
                recursiveBinaryInsert(currentNode.getLeftChild(), newVal);
            }
        } else {
            if (currentNode.getRightChild() == null) {
                currentNode.addRightChild(new Node(newVal, currentNode));
                System.out.printf("%d inserted right to parent : %d\n", newVal, currentNode.getCurrentNode());

            } else {
                recursiveBinaryInsert(currentNode.getRightChild(), newVal);
            }
        }
    }

}
