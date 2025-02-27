// Kayla Jones
// CIS 2353
// Winter 2025
// Project 2

public class Node {
    private int exponent;
    private int coefficient;
    private Node nextNode;

    public Node(int exponent, int coefficient, Node nextNode) {
        this.exponent = exponent;
        this.coefficient = coefficient;
        this.nextNode = nextNode;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}
