// Kayla Jones
// CIS 2353
// Winter 2025
// Project 2

public class Polynomial {
    private Node firstNode;

    public Polynomial() {
        firstNode = null;
    }

    public Polynomial(String poly) {
        // take a string poly, break it up using split() method,
        // put components into nodes, and chain them
        String[] expression = poly.split("\\+");

        for(String monomial : expression) {
            // store the monomial inside of a new node, then
            // move on to the next monomial in the expression
            System.out.println(monomial); // testing, will split further later -- switch statement, maybe
        }
    }

    public Polynomial(Polynomial otherPoly) {
        this.firstNode = new Node(otherPoly.firstNode.getCoefficient(), otherPoly.firstNode.getExponent(), otherPoly.firstNode.getNextNode());
        Node walker = otherPoly.firstNode.getNextNode();
        Node current = this.firstNode;

        while(walker != null) {
            current.setNextNode(new Node(walker.getCoefficient(), walker.getExponent(), walker.getNextNode()));
            current = current.getNextNode();
            walker = walker.getNextNode();
        }
    }

    public void print() { 
        Node walker = firstNode;

        while(walker != null) {
            System.out.println(walker.getCoefficient() + walker.getExponent() + " + ");
            walker.getNextNode();
        }
    }

    public static void add(Polynomial poly1, Polynomial poly2) {

    }
}
