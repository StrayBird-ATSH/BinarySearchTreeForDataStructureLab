import java.util.ArrayList;

public class TestBST {
    public static void main(String[] args) {
        // Create a BST
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        // Traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inOrderTreeWalk();
        System.out.println("\nPostorder: ");
        tree.postOrderTreeWalk();
        System.out.println("\nPreorder: ");
        tree.preOrderTreeWalk();
        System.out.println("\nThe number of nodes is " + tree.getSize());

        // Search for an element
        System.out.println("Is Peter in the tree? (iterative) " + tree.searchIterative(tree.getRoot(), "Peter").element);

        // Search for an element
        System.out.println("Is Peter in the tree? (recursive) " + tree.searchRecursive(tree.getRoot(), "Peter").element);

        // Get a path from the root to Peter
        System.out.println("A path from the root to Peter is: ");
        ArrayList<Tree.TreeNode<String>> path = tree.path("Peter");
        for (int i = 0; path != null && i < path.size(); i++)
            System.out.println(path.get(i).element + " ");

        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BST<Integer> intTree = new BST<>(numbers);
        System.out.print("Inorder (sorted): ");
        intTree.inOrderTreeWalk();


        // Get the predecessor
        System.out.println("\nWhat is the predecessor of 3? " +
                intTree.predecessor(intTree.searchRecursive(intTree.getRoot(), 3)).element);

        // Get the successor
        System.out.println("What is the successor of 3? " +
                intTree.successor(intTree.searchRecursive(intTree.getRoot(), 3)).element);
    }
}
