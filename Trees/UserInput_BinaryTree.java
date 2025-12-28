package Trees;

import java.util.Scanner;

public class UserInput_BinaryTree {
    public static void main(String[] args) {

        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        // accept input from user
        System.out.print("Enter integers to insert into BST (space-separated): ");
        String input = sc.nextLine();

        Node myTree = null;

        String[] strArr = input.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            myTree = Node.InsertNodeBST(myTree, Integer.parseInt(strArr[i]));
        }

        while (exit == false) {
            System.out.print("Enter your command (press ? for help) : ");
            String cmd = sc.nextLine();
            char firstChar = cmd.toUpperCase().charAt(0);
            if (firstChar == 'Q') {
                System.out.println("Exiting...");
                exit = true;
                break;
            } else if (firstChar == '?') {
                helpFunction();
            } else if (firstChar == 'X') {
                treeInfo(myTree);
            } else if (firstChar == 'S') {
                String[] inputStr = cmd.split(" ");
                boolean found = Node.searchBST(myTree, Integer.parseInt(inputStr[1]));

                if (found)
                    System.out.printf("Number %d is FOUND!", inputStr[1]);
                else
                    System.out.printf("Number %d is NOT FOUND!", inputStr[1]);
            } else if (firstChar == 'D') {
                System.out.print("Are you sure you want to delete? (Y/N) : ");
                String confirm = sc.nextLine();
                char confirmChar = confirm.toUpperCase().charAt(0);
                if (confirmChar == 'Y') {
                    String[] inputStr = cmd.split(" ");
                    // deletion function to be implemented
                    System.out.println("Delete function not yet implemented.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
            } else {
                System.out.println("Invalid command. Press '?' for help menu.");
            }

        }

    }

    public void searchFunction(Node myTree, int val) {
        Node.searchBST(myTree, val);
    }

    public static void treeInfo(Node myTree) {
        System.out.print("NLR : ");
        Node.preOrderBST(myTree);
        System.out.print("\nLNR : ");
        Node.inOrderBST(myTree);
        System.out.print("\nLRN : ");
        Node.postOrderBST(myTree);

        System.out.println("\nHEIGHT : " + myTree.getHeight());
        System.out.println("BALANCED : " + myTree.isBalanceTree());
    }

    public static void helpFunction() {
        System.out.println("Press 's <number>' to search the number in the tree.");
        System.out.println("Press 'd <number>' to delete the number from the tree.");
        System.out.println("Press 'X' to display tree information.");
        System.out.println("Press '?' to access the help menu.");
        System.out.println("Press 'Q' to exit the program");
    }
}