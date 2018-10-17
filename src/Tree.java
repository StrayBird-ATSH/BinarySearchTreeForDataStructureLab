public interface Tree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Return true if the element is in the tree
     */
    TreeNode<E> searchIterative(TreeNode<E> x, E k);


    TreeNode<E> searchRecursive(TreeNode<E> x, E k);

    /**
     * Insert element o into the binary tree
     * Return true if the element is inserted successfully
     */
    boolean insert(E e);

    /**
     * Delete the specified element from the tree
     * Return true if the element is deleted successfully
     */
    boolean delete(E e);

    /**
     * Inorder traversal from the root
     */
    void inOrderTreeWalk();

    /**
     * Postorder traversal from the root
     */
    void postOrderTreeWalk();

    /**
     * Preorder traversal from the root
     */
    void preOrderTreeWalk();

    /**
     * Get the number of nodes in the tree
     */
    int getSize();

    /**
     * Return true if the tree is empty
     */
    boolean isEmpty();

    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    class TreeNode<E extends Comparable<E>> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;
        TreeNode<E> parent;

        TreeNode(E e) {
            element = e;
        }
    }
}
