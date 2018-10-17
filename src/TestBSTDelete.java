import org.jetbrains.annotations.NotNull;

public class TestBSTDelete {
    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        printTree(tree);

        System.out.println("\nAfter delete George:");
        tree.delete("George");
        printTree(tree);

        System.out.println("\nAfter delete Adam:");
        tree.delete("Adam");
        printTree(tree);

        System.out.println("\nAfter delete Michael:");
        tree.delete("Michael");
        printTree(tree);
    }

    private static void printTree(@NotNull BST tree) {
        // Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inOrderTreeWalk();
        System.out.print("\nPostorder: ");
        tree.postOrderTreeWalk();
        System.out.print("\nPreorder: ");
        tree.preOrderTreeWalk();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    }
}
