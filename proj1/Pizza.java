import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Pizza implements Comparable<Pizza>{
    enum CrustType {
        Plain,
        Butter,
        Garlic,
        GarlicButter,
        Cheese
    }
    
    private CrustType crust;

    ArrayList<String> toppings = new ArrayList<>();

    enum SizeType {
        Small,
        Medium,
        Large,
        XLarge,
        XXLarge,
        Party
    }

    private SizeType size;

    public Pizza() {
        crust = CrustType.Plain;
        size = SizeType.Small;
        toppings = new ArrayList<>();
        toppings.add("cheese");
        toppings.add("onion");
        toppings.add("green pepper");
        toppings.add("ham");
        toppings.add("pineapple");
        toppings.add("pepperoni");
        toppings.add("ground beef");
        toppings.add("italian sausage");
        toppings.add("anchovies");
    }

    public Pizza(CrustType crust, ArrayList<String> toppings, SizeType size) {
        this.crust = crust;
        this.toppings = toppings;
        this.size = size;
    }

    public CrustType getCrust() {
        return crust;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public SizeType getSize() {
        return size;
    }

    public void setCrust(CrustType crust) {
        this.crust = crust;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    // call this on Pizza object to have an individual topping added
    public String addTopping(String topping) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Toppings available:\n");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(toppings.get(i));
        }

        System.out.println("Add a topping:\n");

        String selectedTopping = scanner.nextLine();
        scanner.nextLine(); // consume newline leftover
        scanner.close();

        return selectedTopping;
    }

    @Override
    public String toString() {
        // creating a separate array list to
        // display all toppings using string builder
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> toppingsList = new ArrayList<>();

        for (int i = 0; i < toppings.size(); i++) {
            toppingsList.add(i);
            sb.append(i).append("\n");
        }

        sb.setLength(sb.length() - 1);
        String toppingsDisplay = sb.toString();

        if (this.getToppings().isEmpty()) {  
            return "This pizza has a " + crust + " crust and zero toppings.";
        } else {
            return "This pizza has a " + crust + " crust and the following toppings:\n" + toppingsDisplay;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.crust);
        hash = 37 * hash + Objects.hashCode(this.toppings);
        return hash;
    }

    @Override
    public boolean equals(Object otherPizza) {
        if ((this.getToppings().size() == ((Pizza) otherPizza).getToppings().size()) && (this.getCrust() == ((Pizza) otherPizza).getCrust())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Pizza otherPizza) {
        // if num of toppings on one pizza is 
        // less than num of toppings on other pizza,
        // return -1
        // if greater than, return 1
        // otherwise, return 0
        if (this.getToppings().size() < otherPizza.getToppings().size()) {
            return -1;
        } else if (this.getToppings().size() > otherPizza.getToppings().size()) {
            return 1;
        } else {
            return 0;
        }
    }

    
}
