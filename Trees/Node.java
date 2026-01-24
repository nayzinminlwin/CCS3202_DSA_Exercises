package Trees;

public class Node {
    private int currentNode;
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private int height = -1;

    public Node(int c, Node parent) {
        this.currentNode = c;
        this.parent = parent;
        height++;
    }

    public Node(int c) {
        this.currentNode = c;
        this.parent = null;
        height++;
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

    // node - left - right
    public static void preOrderBST(Node node) {
        if (node == null)
            return;
        System.out.print(node.getCurrentNode() + ", ");
        preOrderBST(node.getLeftChild());
        preOrderBST(node.getRightChild());
    }

    // left - node - right
    public static void inOrderBST(Node node) {
        if (node == null)
            return;
        inOrderBST(node.getLeftChild());
        System.out.print(node.getCurrentNode() + ", ");
        inOrderBST(node.getRightChild());
    }

    // left - right - node
    public static void postOrderBST(Node node) {
        if (node == null)
            return;
        postOrderBST(node.getLeftChild());
        postOrderBST(node.getRightChild());
        System.out.print(node.getCurrentNode() + ", ");
    }

    public static boolean searchBST(Node node, int val) {
        // return false if node is null
        if (node == null)
            return false;

        // check if current node is the value
        if (node.currentNode == val) {
            // System.out.println("Found!");
            return true;
        }

        // traverse left or right based on value, using recursion
        if (val < node.currentNode) {
            return searchBST(node.leftChild, val);
        } else {
            return searchBST(node.rightChild, val);
        }
    }

    public static Node InsertNodeBST(Node currentNode, int newVal) {
        // initial case for the root insertion
        if (currentNode == null) {
            System.out.println("Root inserted : " + newVal);
            currentNode = new Node(newVal);
            return currentNode;
        }

        // traverse the tree to find the correct position
        // insert left if newVal < currentNode value
        if (newVal < currentNode.getCurrentNode()) {
            // check if left child is null
            if (currentNode.getLeftChild() == null) {
                currentNode.addLeftChild(new Node(newVal, currentNode));
                System.out.printf("%d inserted left to parent : %d\n", newVal, currentNode.getCurrentNode());
            } else { // if not null, continue traversing left
                InsertNodeBST(currentNode.getLeftChild(), newVal);
            }
        } else { // insert right if newVal >= currentNode value
            // check if right child is null
            if (currentNode.getRightChild() == null) {
                currentNode.addRightChild(new Node(newVal, currentNode));
                System.out.printf("%d inserted right to parent : %d\n", newVal, currentNode.getCurrentNode());

            } else { // if not null, continue traversing right
                InsertNodeBST(currentNode.getRightChild(), newVal);
            }
        }
        return currentNode;
    }

    public void calculateHeight() {
        int leftHeight = -1;
        int rightHeight = -1;

        // recursively calculate height of left and right subtrees
        if (this.leftChild != null) {
            leftHeight = this.leftChild.getHeight();
        }

        if (this.rightChild != null) {
            rightHeight = this.rightChild.getHeight();
        }

        // height is max of left and right subtree heights plus one for current node
        this.height = Math.max(leftHeight, rightHeight) + 1;
    }

    public int getHeight() {
        this.calculateHeight();
        return this.height;
    }

    public String isBalanceTree() {
        int difference = this.leftChild.getHeight() - this.rightChild.getHeight();
        if (difference >= -1 && difference <= 1) {
            return "YES";
        }
        return "NO";
    }

    public static Node deleteNode(Node node, int val) {
        // return null if node is null
        if (node == null) {
            return null;
        }

        // Tree Traversal to left
        if (val < node.currentNode) {
            node.leftChild = deleteNode(node.leftChild, val);
            return node;
        }
        // Tree Traversal to right
        else if (val > node.currentNode) {
            node.rightChild = deleteNode(node.rightChild, val);
            return node;
        }
        // found the value
        else {
            // solo leaf
            if (node.leftChild == null && node.rightChild == null) {
                return null;
            }
            // a parent with both left and right child
            else if (node.leftChild != null && node.rightChild != null) {

                // First step : go to right child
                Node successor = node.rightChild;

                // now traverse all the way to left
                // to find the smallest value
                while (successor.leftChild != null) {
                    successor = successor.leftChild;
                }

                // replace current node's value with successor's value
                // in this case,
                // replace the current value with the smallest value in the right subtree
                node.currentNode = successor.currentNode;

                // now delete the successor node
                node.rightChild = deleteNode(node.rightChild, successor.currentNode);

                return node;
            }
            // a parent with leftChild
            else if (node.leftChild != null) {
                return node.leftChild;
            }
            // a parent with rightChild
            else {
                return node.rightChild;
            }
        }
    }
}
