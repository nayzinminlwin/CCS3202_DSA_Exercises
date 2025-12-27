package Trees;

public class Node {
    private int currentNode;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(int c, Node parent) {
        this.currentNode = c;
        this.parent = parent;
    }

    public Node(int c) {
        this.currentNode = c;
        this.parent = null;
    }

    public int getCurrentNode() {
        return this.currentNode;
    }

    public Node getParent() {
        return this.parent;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(Node lc) {
        this.leftChild = lc;
    }

    public void addRightChild(Node rc) {
        this.rightChild = rc;
    }

    public static void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.getLeftChild());
        System.out.print(node.getCurrentNode() + " ");
        inorder(node.getRightChild());
    }
}
