/**
 * this interface for binarySearchTree class
 * @param <E>
 */
public interface SearchTree<E> {

    /**
     * Starter method add.
     * pre: The object to insert must implement the
     * Comparable interface.
     *
     * @param item The object being inserted
     * @return true if the object is inserted, false
     * if the object already exists in the tree
     */
    boolean add(E item);

    boolean contains(E target);
    /**
     * Starter method find.
     * pre: The target object must implement
     * the Comparable interface.
     *
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    BinaryTree.AgeData<E> find(E target);

    /**
     * Starter method delete.
     * post: The object is not in the tree.
     *
     * @param target The object to be deleted
     * @return The object deleted from the tree
     * or null if the object was not in the tree
     * @throws ClassCastException if target does not implement
     *                            Comparable
     */
    E delete(E target);

    boolean remove(E target);
}
