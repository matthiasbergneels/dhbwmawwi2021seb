package lecture.chapter12;

public class BinaryTreeRun {

  public static void main(String[] args) {

    BinaryTree<Integer> numbersTree = new BinaryTree<>();

    numbersTree.add(30);
    numbersTree.add(60);
    numbersTree.add(80);
    numbersTree.add(50);
    numbersTree.add(10);
    numbersTree.add(20);
    numbersTree.add(15);
    numbersTree.add(0);
    numbersTree.add(100);

    System.out.println("Baum ist fertig!");

  }
}
