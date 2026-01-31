package Trees;

import java.util.Scanner;

public class UserInput_BinaryTree {
    public static void main(String[] args) {

        // 8 72 917 39 72 36 18 9 ggwp 71 +616 63 9 1 5 -11 53 0

        Scanner sc = new Scanner(System.in);

        // accept input from user
        System.out.print("Enter integers to insert into BST (space-separated): ");
        String input = sc.nextLine();

        // tree initialization
        Node myTree = null;

        // user input to BST
        String[] strArr = input.split(" ");
        for (int i = 0; i < strArr.length; i++) {

            // check if the input value is positive integer
            // and not already present in the tree
            if (strArr[i].matches("\\+?\\d+") && !Node.searchBST(myTree, Integer.parseInt(strArr[i]))) {

                myTree = Node.InsertNodeBST(myTree, Integer.parseInt(strArr[i]));

            } else {
                System.out.printf("Invalid input '%s' skipped.\n", strArr[i]);
            }
        }

        // interactive prompt
        while (true) {

            System.out.print("Enter your command (press ? for help) : ");
            String cmd = sc.nextLine();

            // get first character of command
            char firstChar = cmd.toUpperCase().charAt(0);

            if (firstChar == 'Q') {
                // exit from infinite loop
                System.out.println("Exiting...");
                break;
            } else if (firstChar == '?') {
                helpFunction();
            } else if (firstChar == 'X') {
                treeInfo(myTree);
            } else if (firstChar == 'S') {
                String[] inputStr = cmd.split(" ");
                boolean found = Node.searchBST(myTree, Integer.parseInt(inputStr[1]));

                if (found)
                    System.out.printf("Number %s is FOUND!", inputStr[1]);
                else
                    System.out.printf("Number %s is NOT FOUND!", inputStr[1]);

                System.out.println();

            } else if (firstChar == 'D') {

                // delete confirmation
                System.out.print("Are you sure you want to delete? (Y/N) : ");
                String confirm = sc.nextLine();
                char confirmChar = confirm.toUpperCase().charAt(0);

                if (confirmChar == 'Y') {

                    String[] inputStr = cmd.split(" ");

                    // invoking delete function
                    myTree = Node.deleteNode(myTree, Integer.parseInt(inputStr[1]));
                    System.out.println("Deleted number " + inputStr[1] + " from the tree.");

                } else {
                    System.out.println("Deletion cancelled.");
                }
            }
            // last else for invalid command
            else {
                System.out.println("Invalid command. Press '?' for help menu.");
            }

        }

        sc.close();

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

        int leftTreeHeight = myTree.getLeftChild().getHeight();
        int rightTreeHeight = myTree.getRightChild().getHeight();

        System.out.println("Left Height : " + leftTreeHeight);
        System.out.println("Right Height : " + rightTreeHeight);

    }

    public static void helpFunction() {
        System.out.println("===========================================================");
        System.out.println("\t \t \t HELP \t \t \t ");
        System.out.println("===========================================================");
        System.out.println("Press 's <number>' to search the number in the tree.");
        System.out.println("Press 'd <number>' to delete the number from the tree.");
        System.out.println("Press 'X' to display tree information.");
        System.out.println("Press '?' to access the help menu.");
        System.out.println("Press 'Q' to exit the program");
        System.out.println("===========================================================");
    }
}