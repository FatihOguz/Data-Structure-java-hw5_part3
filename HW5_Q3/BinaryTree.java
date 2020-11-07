/**
 * @author Fatih OGUZ
 */


/**
 * Serialicable interface
 */

import java.io.Serializable;
/**
 * Comparator interface
 */
import java.util.Comparator;
/**
 * Scanner interface
 */
import java.util.Scanner;
/**
 * BiConsumer interface
 */
import java.util.function.BiConsumer;

/**
 *
 * implements Serializable interfaces.
 * has an inner class AgeData
 * Stores ageData in a binary tree structure
 *
 * @param <E> is generic
 */
public class BinaryTree<E> implements Serializable {
    /**
     * implements Serializable and Comparator interfaces.
     * this class stores age(data) and number of people of that ages(numberOfPeople)
     * every AgeData connects each other with left or right reference
     * @param <E> is generic
     */
    protected static class AgeData<E> implements Serializable , Comparator {
        /**
         * stores age
         */
        protected E data;
        /**
         * stores number of people that age
         */
        protected int numberOfPeople=1;
        /**
         * connects to the child on the left
         */
        protected AgeData<E> left;
        /**
         * connects to the child on the right
         */
        protected AgeData<E> right;

        /**
         * No parameter constructor
         */
        public AgeData(){

        }

        /**
         * Constructor create a leaf
         * @param data store age
         */
        public AgeData(E data){
            this.data=data;
            left=null;
            right=null;
        }

        /**
         * create AgeData and initialize age and number of people of that age
         * and create a leaf
         * @param data store age
         * @param size store number of people
         */
        public AgeData(E data,int size){
            this.data=data;
            this.numberOfPeople=size;
            left=null;
            right=null;
        }

        /**
         * create AgeData and connect other AgeData
         * @param dataVal store age
         * @param left connect leftchild
         * @param right connect rigt child
         */
        public  AgeData(E dataVal, AgeData<E> left, AgeData<E> right) {
            this.data = dataVal;
            this.left=left;
            this.right=right;
        }



        /**
         * check item and age of AgeData
         * @param item is age
         * @return boolean
         */
        public boolean compareTo(E item){
            if(this.data == item){
                return true;
            }
            else{
                return false;
            }
        }

        /**
         * show age and number of people of that age
         * @return string
         */
        public String toString(){
            return data.toString() + " - " + numberOfPeople;
        }

        /**
         * override Comparator interface
         * compare age of two objects
         * @param o1 is object
         * @param o2 is object
         * @return if o1.age>o2.age return 1 else if o1.age<o2.age return -1 otherwise 0
         */
        @Override
        public int compare(Object o1, Object o2) {
            AgeData<E> ageData1= (AgeData<E>)o1;
            AgeData<E> ageData2 = (AgeData<E>)o2 ;

            if((Integer)ageData1.data >(Integer)ageData2.data){
                return 1;
            }
            else if((Integer)ageData1.data <(Integer)ageData2.data){
                return -1;
            }
            else
            {
                return 0;
            }

        }
    }
    /********************************************************************************************************/
    /**
     * data field of binary tree
     * it is root of AgeData tree
     */
    protected AgeData<E> root;


    /**
     * no parameter constructor
     * did not creat root
     */
    public BinaryTree(){
        root=null;
    }

    /**
     * The constructor that takes a AgeData as a parameter is a protected constructor.
     * This is because client classes do not know about the AgeData<E> class
     * This constructor can be used only by methods internal to the BinaryTree class and its subclass
     * @param root is head of binaryTree
     */
    protected BinaryTree(AgeData<E> root){
        this.root = root;
    }

    /**
     * this constructor connect leafs
     * @param data store age
     * @param leftTree  reference to left of AgeData tree
     * @param rightTree reference to right of AgeData tree
     */
    public BinaryTree(E data,BinaryTree<E> leftTree,BinaryTree<E> rightTree){
        root = new AgeData<>(data);

        if(leftTree != null){
            root.left = leftTree.root;
        }
        else{
            root.left=null;
        }
        if(rightTree != null){
            root.right=rightTree.root;
        }
        else{
            root.right = null;
        }
    }


    /**
     * if  is there tree in left of binary Tree ,return this tree.
     * @return left of binaryTree
     */
    public BinaryTree<E> getLeftSubtree(){
        if(root!=null && root.left!=null){
            return new BinaryTree<>(root.left);
        }
        else
        {
            return null;
        }
    }

    /**
     * if  is there tree in right  of binary Tree ,return this tree.
     * @return right of binaryTree
     */
    public BinaryTree<E> getRightSubtree(){
        if(root!=null && root.right!=null){
            return new BinaryTree<>(root.right);
        }
        else
        {
            return null;
        }

    }

    /**
     * getter metod .
     * get age of root
     * @return age
     */
    public E getData(){
        return this.root.data;
    }

    /**
     * if there is not left and right children,root is leaf
     * @return boolean
     */
    public boolean isLeaf(){
        return (root.left==null && root.right==null);
    }

    /**
     * show binary tree
     * @return string
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        toString(root,1,sb);
        return sb.toString();
    }

    /**
     * helping metod for toString method
     * @param node is AgeData
     * @param depth is depth of binary tree
     * @param sb String builder
     */
    private void toString(AgeData<E> node,int depth,StringBuilder sb){
        for(int i = 1 ;i< depth;i++){
            sb.append(" ");
        }
        if(node==null){
            sb.append("null\n");
        }
        else{
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left,depth+1,sb);
            toString(node.right,depth+1,sb);

        }
    }

    /**
     * Starter method for preorder traversal
     * @param consumer an object that instantiates
     *                 the BiConsumer interface.Its method implement
     *                 abstract method apply.
     */
    public void preOrderTraverse(BiConsumer<E,Integer> consumer){
        preOrderTraverse(root,1,consumer);
    }

    /**
     *  Performs a recursive preorder traversal of the tree,
     *  applying the action specified in the consumer object.
     * @param node
     * @param depth
     * @param consumer object whose accept method specifies the action to be performed on each node
     */
    private void preOrderTraverse(AgeData<E> node ,int depth,BiConsumer<E,Integer> consumer){
        if(node==null){
            consumer.accept(null,depth);
        }else{
            consumer.accept(node.data,depth);
            preOrderTraverse(node.left,depth+1,consumer);
            preOrderTraverse(node.right,depth+1,consumer);
        }
    }

    /**
     * Method to read a binary tree
     * pre: The input consists of a preorder traversal of the binary tree .
     * The line "null" indicates a null tree.
     * @param scan the scanner attached to the input file
     * @return the binary tree
     */
    public  BinaryTree readBinaryTree(Scanner scan){

        //Read a line and trim leading and tailing spaces.

        String data = scan.nextLine().trim();

        if(data.equals("null")){
            return null;
        }
        else{
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<> (data,leftTree,rightTree);
        }
    }
}
