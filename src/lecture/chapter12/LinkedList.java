package lecture.chapter12;

public class LinkedList {

  private Node firstNode;
  private Node lastNode;
  private int size = 0;

  public void add(String word){
    Node newNode = new Node(word);

    if(firstNode == null){
      firstNode = newNode;
      lastNode = newNode;
      size++;
      return;
    }

    /*
    Node currentNode = firstNode;
    while(currentNode.getNextNode() != null){
      currentNode = currentNode.getNextNode();
    }

    currentNode.setNextNode(newNode);
     */

    lastNode.setNextNode(newNode);
    lastNode = newNode;
    size++;

  }

  public int size(){
    return size; // --> O(1)

    /*
    int count = 0;

    if(firstNode == null){
      return 0;
    }

    Node currentNode = firstNode;
    count++;
    while(currentNode.getNextNode() != null){
      count++;
      currentNode = currentNode.getNextNode();
    }

    return count;

     */
  }

  public boolean contains(String word){

    Node currentNode = firstNode;
    while(currentNode != null){
      if(word.equals(currentNode.getWord())){
        return true;
      }
      currentNode = currentNode.getNextNode();
    }

    return false;
  }

  public void printList(){
    if(firstNode == null){
      System.out.println("Die Liste ist leer");
      return;
    }

    Node currentNode = firstNode;
    while(currentNode.getNextNode() != null){
      System.out.println(currentNode.getWord());
      currentNode = currentNode.getNextNode();
    }

    System.out.println(currentNode.getWord());

  }

  public boolean remove(String word){

    if(firstNode != null){

      if(firstNode.getWord().equals(word)){
        firstNode = firstNode.getNextNode();
        size--;
        return true;
      }

      Node currentNode = firstNode;
      while(currentNode.getNextNode() != null){
        if(currentNode.getNextNode().getWord().equals(word)){
          currentNode.setNextNode(currentNode.getNextNode().getNextNode());
          size--;
          return true;
        }
        currentNode = currentNode.getNextNode();
      }
    }

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
