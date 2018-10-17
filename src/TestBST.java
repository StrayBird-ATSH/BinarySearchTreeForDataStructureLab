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
        System.out.print("Inorder (sorted): ");
        tree.inOrderTreeWalk();
        System.out.print("\nPostorder: ");
        tree.postOrderTreeWalk();
        System.out.print("\nPreorder: ");
        tree.preOrderTreeWalk();
        System.out.print("\nThe number of nodes is " + tree.getSize());

        // Search for an element
        System.out.print("\nIs Peter in the tree? " + tree.searchIterative(tree.getRoot(), "Peter"));

        // Get a path from the root to Peter
        System.out.print("\nA path from the root to Peter is: ");
        ArrayList<Tree.TreeNode<String>> path = tree.path("Peter");
        for (int i = 0; path != null && i < path.size(); i++)
            System.out.print(path.get(i).element + " ");

        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BST<Integer> intTree = new BST<>(numbers);
        System.out.print("\nInorder (sorted): ");
        intTree.inOrderTreeWalk();
    }
}
