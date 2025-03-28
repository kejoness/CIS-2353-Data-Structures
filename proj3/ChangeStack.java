// Kayla Jones
// Project 3
// CIS 2353
// Winter 2025
// Prof. John P. Baugh

public class ChangeStack {
    private Node topNode;
    private int numElements;

    public ChangeStack() {
        topNode = null;
        numElements = 0;
    }

    // check if top of linked stack is empty
    public boolean isEmpty() {
        return topNode == null;
    }

    // add new node to top of linked stack
    public void push(int item) {
        topNode = new Node(item, topNode);
    }

    // look at top node of linked stack
    public int peekTop() {
        if(isEmpty()) {
            throw new StackEmptyException("The stack is empty.");
        } else {
            return topNode.getData();
        }
    }

    // remove the top node of linked stack
    public int pop() {
        if(isEmpty()) {
            throw new StackEmptyException("The stack is empty.");
        } else {
            topNode = topNode.getNextNode();
            return topNode.getData();
        }
    }

    public void increaseValues(int k, int amount) {

    }

    public void decreaseValues(int k, int amount) {

    }
}
