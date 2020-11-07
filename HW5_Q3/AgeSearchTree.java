/**
 * @author Fatih OGUZ
 */

/**
 *  This class extends BinarySerachTree class
 *  and define spesific methods
 * @param <E>
 */
public class AgeSearchTree<E extends Comparable<E>> extends BinarySearchTree<E>{
    /**
     * BinarySearchTree
     */
    private BinarySearchTree binarySearchTree = new BinarySearchTree();

    /**
     * no parameter constructor
     */
    public AgeSearchTree(){
       // System.out.println("no parameter constructor");
    }

    /**
     * if is there item , increment number of people ,otherwise create AgeData
     * @param item The object being inserted
     * @return
     */
    @Override
    public boolean add(E item) {
        return super.add(item);
    }
    /**
     * if is there item , increment number of people ,otherwise create AgeData
     * @param node The object being inserted
     * @return
     */
    public boolean add(AgeData<E> node){
        root = add(root, node.data,node.numberOfPeople);
        return addReturn;
    }
    /**
     * Recursive add method.
     * post: The data field addReturn is set true if the item is added to
     * the tree, false if the item is already in the tree.
     *
     * @param localRoot The local root of the subtree
     * @param item      The object to be inserted
     * @return The new local root that now contains the
     * inserted item
     */
    private AgeData<E> add(AgeData<E> localRoot, E item,int peopleSize) {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            addReturn = true;
            return new AgeData<>(item,peopleSize);
        } else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = true;
            localRoot.numberOfPeople = localRoot.numberOfPeople + peopleSize;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item,peopleSize);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item,peopleSize);
            return localRoot;
        }
    }

    /**
     * is there target in binaryTree
     * @param target The Comparable object being sought
     * @return target
     */
    @Override
    public AgeData<E> find(E target) {
        return super.find(target);
    }


    /**
     * if is there target in binaryTree , decrement number of people of target,otherwwise delete AgeData
     * @param target is age
     * @return boolean
     */
    @Override
    public boolean remove(E target) {
        E ret =  super.delete(target);
        if(ret==null){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Helping metod for youngerThan(item)
     * How many are smaller than item
     * @param node is AgeData
     * @param item is age
     * @param count size of smaller than item
     * @return how many are smaller than item
     */
    private int youngerThan(AgeData node,int item,int count){
        if((Integer)node.data>item){
            if(node.left!=null){
                return youngerThan(node.left,item,count);
            }

        }
        else if((Integer)node.data<item){
            count=count+node.numberOfPeople;
            if(node.right!=null){
                if(node.left!=null){
                    count = youngerThan(node.left,item,count);
                }

                return youngerThan(node.right,item,count);
            }
            else{
                if(node.left!=null)
                return youngerThan(node.left,item,count);
            }

        }
        else{
            if(node.left!=null){
                return youngerThan(node.left,item,count);
            }
        }
        return count;
    }

    /**
     * How many are smaller than item
     * @param item is age
     * @return how many are smaller than item
     */
    public int youngerThan(int item){
        return youngerThan(root,item,0);
    }
    /**
     * How many are bigger than item
     * @param item is age
     * @return How many are bigger than item
     */
    public int olderThan(int item){
        return olderThan(root,item,0);
    }

    /**
     * Helping metod for olderThan(item)
     * How many are bigger than item
     * @param node is AgeData
     * @param item is age
     * @param count size of igger than item
     * @return How many are bigger than item
     */
    private int olderThan(AgeData node,int item,int count) {

        if((Integer)node.data>item){
            count = count + node.numberOfPeople;
            if(node.left!=null){
                if(node.right!=null){
                    count = olderThan(node.right,item,count);
                }
                return olderThan(node.left,item,count);

            }
            else{
                if(node.right!=null){
                    return olderThan(node.right,item,count);
                }
            }

        }
        else if((Integer)node.data<item){
            if(node.right!=null){
                return olderThan(node.right,item,count);
            }

        }
        else{
            if(node.right!=null){
                return olderThan(node.right,item,count);
            }
        }
        return count;
    }

}
