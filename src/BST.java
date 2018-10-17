import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @param <E> a comparable generic that you want this tree to contain
 * @author Wang, Chen
 */
public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    private TreeNode<E> root;
    private int size = 0;

    /**
     * Create a default binary tree
     */
    BST() {
    }

    /**
     * Create a binary tree from an array of objects
     */
    BST(@NotNull E[] objects) {
        for (E element : objects)
            insert(element);
    }

    /**
     * Returns the element if the element is in the tree
     */
    @Override
    public TreeNode<E> searchIterative(TreeNode<E> x, E k) {
        TreeNode<E> current = x; // Start from the root

        while (current != null)
            if (k.compareTo(current.element) < 0)
                current = current.left;
            else if (k.compareTo(current.element) > 0)
                current = current.right;
            else // element matches current.element
                return current; // Element is found
        return null;
    }


    @Override
    public TreeNode<E> searchRecursive(TreeNode<E> x, E k) {
        if (x == null || k.compareTo(x.element) == 0)
            return x;
        if (k.compareTo(x.element) < 0)
            return searchRecursive(x.left, k);
        else
            return searchRecursive(x.right, k);
    }

    @Contract(pure = true)
    private TreeNode<E> treeMinimum(@NotNull TreeNode<E> x) {
        while (x.left != null)
            x = x.left;
        return x;
    }

    @Contract(pure = true)
    private TreeNode<E> treeMaximum(@NotNull TreeNode<E> x) {
        while (x.right != null)
            x = x.right;
        return x;
    }

    private TreeNode<E> successor(@NotNull TreeNode<E> x) {
        if (x.right != null)
            return treeMinimum(x.right);
        TreeNode<E> y = x.parent;
        while (y != null && x.element.equals(y.right.element)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    private TreeNode<E> predecessor(@NotNull TreeNode<E> x) {
        if (x.left != null)
            return treeMinimum(x.left);
        TreeNode<E> y = x.parent;
        while (y != null && x.element.equals(y.left.element)) {
            x = y;
            y = y.parent;
        }
        return y;
    }


    /**
     * Insert element o into the binary tree
     * Return true if the element is inserted successfully
     */
    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e); // Create a new root
            root.parent = null;
        } else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
                parent.left.parent = parent;
            } else {
                parent.right = createNewNode(e);
                parent.right.parent = parent;
            }
        }
        size++;
        return true; // Element inserted successfully
    }

    @NotNull
    @Contract("_ -> new")
    private TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    /**
     * Inorder traversal from the root
     */
    @Override
    public void inOrderTreeWalk() {
        inorder(root);
    }

    /**
     * Inorder traversal from a subtree
     */
    private void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }


    /**
     * Postorder traversal from the root
     */
    @Override
    public void postOrderTreeWalk() {
        postorder(root);
    }

    /**
     * Postorder traversal from a subtree
     */
    private void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }


    /**
     * Preorder traversal from the root
     */
    @Override
    public void preOrderTreeWalk() {
        preorder(root);
    }

    /**
     * Preorder traversal from a subtree
     */
    private void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }


    /**
     * Get the number of nodes in the tree
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    TreeNode<E> getRoot() {
        return root;
    }

    /**
     * Returns a path from the root leading to the specified element
     */
    ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            list.add(current); // Add the node to the list
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }

        return list; // Return an array list of nodes
    }


    /**
     * Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree
     */
    @Override
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break; // Element is in the tree pointed at by current
        }

        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                    current.right.parent = parent;
                } else {
                    parent.right = current.right;
                    current.right.parent = parent;
                }
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
                rightMost.left.parent = parentOfRightMost;
            } else {
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
                rightMost.left.parent = parentOfRightMost;
            }
        }

        size--;
        return true; // Element deleted successfully
    }


    /**
     * Obtain an iterator. Use inOrderTreeWalk.
     */
    @Override
    public @NotNull
    Iterator<E> iterator() {
        return new InorderIterator();
    }

    // Inner class InorderIterator
    private class InorderIterator implements Iterator<E> {
        // Store the elements in a list
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0; // Point to the current element in list

        InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /**
         * Inorder traversal from the root
         */
        private void inorder() {
            inorder(root);
        }

        /**
         * Inorder traversal from a subtree
         */
        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }


        /**
         * More elements for traversing?
         */
        @Override
        public boolean hasNext() {
            return current < list.size();
        }


        /**
         * Get the current element and move to the next
         */
        @Override
        public E next() {
            return list.get(current++);
        }


        /**
         * Remove the current element
         */
        @Override
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }

    /**
     * Remove all elements from the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }
}
