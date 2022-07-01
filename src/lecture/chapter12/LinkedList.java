package lecture.chapter12;

public class LinkedList {

  private Node firstNode;

  public void add(String word){
    Node newNode = new Node(word);

    if(firstNode == null){
      firstNode = newNode;
      return;
    }

    Node currentNode = firstNode;
    while(currentNode.getNextNode() != null){
      currentNode = currentNode.getNextNode();
    }

    currentNode.setNextNode(newNode);

  }

  public int size(){
    // TODO
    return 0;
  }

  public boolean conatins(String word){
    // TODO
    return false;
  }

  public void printList(){
    // TODO
  }

  public boolean remove(String word){
    // TODO
    return false;
  }



  private class Node{

    private String word;
    private Node nextNode;

    public Node(String word){
      this.word = word;
      this.nextNode = null;
    }

    public void setNextNode(Node nextNode){
      this.nextNode = nextNode;
    }

    public Node getNextNode(){
      return this.nextNode;
    }

    public String getWord(){
      return this.word;
    }

  }

}
