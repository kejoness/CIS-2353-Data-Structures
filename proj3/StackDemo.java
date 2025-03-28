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

        System.out.println("Stack: " + stack);
        System.out.println("Top of current stack: " + stack.peekTop());
    }
}
