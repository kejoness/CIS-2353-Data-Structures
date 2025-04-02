// Kayla Jones
// Project 3
// CIS 2353
// Winter 2025
// Prof. John P. Baugh

public class StackDemo {
    public static void main(String[] args) {
        ChangeStack stack = new ChangeStack();

        stack.push(10);
        stack.push(3);
        stack.push(9);
        stack.push(6);

        stack.printStack();
        System.out.println("Top of current stack: " + stack.peekTop());

        stack.increaseValues(2, 5);
        stack.printStack();

        stack.decreaseValues(2, 4);
        stack.printStack();

        stack.pop();
        stack.printStack();
        System.out.println("Top of current stack: " + stack.peekTop());
        
        stack.pop();
        stack.printStack();
        stack.pop();
        
        System.out.println("Top of current stack: " + stack.peekTop());
        stack.pop();
        System.out.println(stack.peekTop());
    }
}
