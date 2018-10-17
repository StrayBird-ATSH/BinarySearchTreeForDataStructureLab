public abstract class AbstractTree<E extends Comparable<E>> implements Tree<E> {
    /**
     * Return true if the tree is empty
     */
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
