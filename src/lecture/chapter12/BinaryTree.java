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

    return add(newNode, root);
  }

  private boolean add(Node<T> newNode, Node<T> currentNode){
    int compareToResult = ((Comparable)currentNode.getData()).compareTo(newNode.getData());

    if(compareToResult > 0){
      // leftSide
      if(currentNode.getLeftNode() != null){
        return add(newNode, currentNode.getLeftNode());
      } else {
        currentNode.setLeftNode(newNode);
        this.size++;
        return true;
      }

    }else if(compareToResult < 0){
      // rightSide

      if(currentNode.getRightNode() != null){
        return add(newNode, currentNode.getRightNode());
      } else {
        currentNode.setRightNode(newNode);
        this.size++;
        return true;
      }
    }

    return false;
  }

  public int size(){
    return this.size;
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
