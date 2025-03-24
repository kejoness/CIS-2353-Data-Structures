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
        firstNode = null;
        String[] expression = poly.split("(?=[+-])");
        Node current = null;

        for(String monomial : expression) {
            // store the monomial inside of a new node, then
            // move on to the next monomial in the expression
            monomial = monomial.trim();
            if(monomial.isEmpty()) continue;

            int coefficient = 1, exponent = 0;

            if (monomial.contains("x")) {
                String[] parts = monomial.split("x");

                // extract coefficient
                if (!parts[0].isEmpty()) {
                    coefficient = Integer.parseInt(parts[0].replace(" ",""));
                }

                // extract exponent
                if (monomial.contains("^")) {
                    exponent = Integer.parseInt(parts[1].substring(1).replace(" ",""));
                } else {
                    exponent = 1;
                }
            } else {
                coefficient = Integer.parseInt(monomial);
            }

            // create a new node and chain it
            Node newNode = new Node(coefficient, exponent, null);

            if (firstNode == null) {
                firstNode = newNode;
                current = firstNode;
            } else {
                current.setNextNode(newNode);
                current = newNode;
            }
        }
    }
    
    public Polynomial(Polynomial otherPoly) {
        this.firstNode = new Node(otherPoly.firstNode.getCoefficient(), otherPoly.firstNode.getExponent(), null);
        Node walker = otherPoly.firstNode.getNextNode();
        Node current = this.firstNode;

        while(walker != null) {
            current.setNextNode(new Node(walker.getCoefficient(), walker.getExponent(), null));
            current = current.getNextNode();
            walker = walker.getNextNode();
        }
    }

    // added a polynomial constructor that takes 
    // a Node so that polynomial addition 
    // can be done in the demo class
    public Polynomial(Node headNode) {
        this.firstNode = headNode;
    }

    public void print() { 
        Node walker = firstNode;
        boolean firstTerm = true;

        while(walker != null) {
            if(!firstTerm) {
                System.out.print("+");
            }
            firstTerm = false;

            // print each term in their correct form
            switch (walker.getExponent()) {
                case 0:
                    // constant term (no "x")
                    System.out.print(walker.getCoefficient());
                    break;
                case 1:
                    // linear term (coefficient * x)
                    System.out.print(walker.getCoefficient() + "x");
                    break;
                default:
                    // higher exponent terms (coefficient * x^exponent)
                    System.out.print(walker.getCoefficient() + "x^" + walker.getExponent());
                    break;
            }

            walker = walker.getNextNode();
        }
        System.out.println();
    }

    public static Node add(Polynomial poly1, Polynomial poly2) {
        Node p1 = poly1.firstNode;
        Node p2 = poly2.firstNode;

        // create "dummy node" -- represents starting point
        Node dummyHead = new Node(0, 0, null);
        Node current = dummyHead;

        // traverse through each monomial and 
        // add them up to create a new polynomial expression
        while(p1 != null || p2 != null) { // while there are monomials left to add
            if (p1 == null) {
                current.setNextNode(new Node(p2.getCoefficient(), p2.getExponent(), null));
                p2 = p2.getNextNode();
            } else if (p2 == null) {
                current.setNextNode(new Node(p1.getCoefficient(), p1.getExponent(), null));
                p1 = p1.getNextNode();
            } else if (p1.getExponent() == p2.getExponent()) {
                int newCoefficient = p1.getCoefficient() + p2.getCoefficient();
                if (newCoefficient != 0) {
                    current.setNextNode(new Node(newCoefficient, p1.getExponent(), null));
                }
                p1 = p1.getNextNode();
                p2 = p2.getNextNode();
            } else if (p1.getExponent() > p2.getExponent()) {
                current.setNextNode(new Node(p1.getCoefficient(), p1.getExponent(), null));
                p1 = p1.getNextNode();
            } else {
                current.setNextNode(new Node(p2.getCoefficient(), p2.getExponent(), null));
                p2 = p2.getNextNode();
            }
            current = current.getNextNode();
        }
    
        return dummyHead.getNextNode();
    }
}