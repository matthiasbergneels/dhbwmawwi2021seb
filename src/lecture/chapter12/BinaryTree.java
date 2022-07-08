package lecture.chapter12;

public class BinaryTree<T> {

  private Node<T> root = null;
  private int size = 0;

  public boolean add(T data){
    Node<T> newNode = new Node(data);

    if(root == null){
      this.root = newNode;
      size++;
      return true;
    }

    // TODO --> add fertig implementieren

    return false;
  }


  private class Node<T>{
    private final T data;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T data){
      this.data = data;
      this.leftNode = null;
      this.rightNode = null;
    }

    public T getData(){
      return data;
    }

    public Node<T> getLeftNode(){
      return this.leftNode;
    }

    public Node<T> getRightNode(){
      return this.rightNode;
    }

    public void setLeftNode(Node<T> leftNode){
      this.leftNode = leftNode;
    }

    public void setRightNode(Node<T> rightNode){
      this.rightNode = rightNode;
    }
  }
}
