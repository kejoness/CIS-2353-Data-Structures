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

    // print entire stack
    public void printStack() {
        Node current = topNode;
        System.out.print("Stack: ");

        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNextNode();
        }
        System.out.println();
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
        if (isEmpty()) return;
        
        Node current = topNode;
        int count = 0;
        
        // traverse to the bottom of the stack
        while (current.getNextNode() != null) {
            current = current.getNextNode();
            count++;
        }
        
        // determine how many elements to adjust
        int adjustCount = Math.min(count + 1, k);
        current = topNode;
        
        // traverse again and update the bottom k elements
        for (int i = 0; i < count + 1 - adjustCount; i++) {
            current = current.getNextNode();
        }
        
        while (adjustCount > 0 && current != null) {
            current.setData(current.getData() + amount);
            current = current.getNextNode();
            adjustCount--;
        }
    }

    public void decreaseValues(int k, int amount) {
        if (isEmpty()) return;
        
        Node current = topNode;
        int count = 0;
        
        // traverse to the bottom of the stack
        while (current.getNextNode() != null) {
            current = current.getNextNode();
            count++;
        }
        
        // determine how many elements to adjust
        int adjustCount = Math.min(count + 1, k);
        current = topNode;
        
        // traverse again and update the bottom k elements
        for (int i = 0; i < count + 1 - adjustCount; i++) {
            current = current.getNextNode();
        }
        
        while (adjustCount > 0 && current != null) {
            current.setData(current.getData() - amount);
            current = current.getNextNode();
            adjustCount--;
        }
    }
}
