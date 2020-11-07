/**
 * testing AgeSearchTree metods
 */
public class Main {

    public static <E> void main(String[] args){
        AgeSearchTree<Integer> ageTree = new AgeSearchTree<Integer>();


        ageTree.add(new BinaryTree.AgeData<>(10));
        ageTree.add(new BinaryTree.AgeData<>(20));
        ageTree.add(new BinaryTree.AgeData<>(5));
        ageTree.add(new BinaryTree.AgeData<>(15));
        ageTree.add(new BinaryTree.AgeData<>(10));
        System.out.println(ageTree+"\n*******************************************************************************");
        System.out.println("youngerThan(15) --> " +  ageTree.youngerThan(15));
        System.out.println("olderThan(15)  " + ageTree.olderThan(15));
        System.out.println("find(10) --> " + ageTree.find(10));
        System.out.println(ageTree+"\n*******************************************************************************");
        ageTree.remove(10);
        ageTree.remove(20);
        ageTree.remove(5);
        System.out.println(ageTree+"\n*******************************************************************************");
        ageTree.remove(15);
        ageTree.remove(10);
        System.out.println(ageTree+"\n*******************************************************************************");
        ageTree.add(1);
        ageTree.add(2);
        ageTree.add(3);
        System.out.println(ageTree+"\n*******************************************************************************");
        ageTree.add(3);
        System.out.println(ageTree+"\n*******************************************************************************");
        ageTree.add(new BinaryTree.AgeData<Integer>(8,78));
        System.out.println(ageTree+"\n*******************************************************************************");
        ageTree.add(new BinaryTree.AgeData<>(2,23));
        System.out.println(ageTree+"\n*******************************************************************************");

        System.out.println("youngerThan(3) --> "+  ageTree.youngerThan(3));
        System.out.println("olderThan(2) --> "+  ageTree.olderThan(2));




    }


}
