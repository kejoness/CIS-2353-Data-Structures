import java.util.ArrayList;
import java.util.Objects;

public class Pizza implements Comparable<Pizza>{
    public enum CrustType {
        Plain,
        Butter,
        Garlic,
        GarlicButter,
        Cheese
    }
    
    private CrustType crust;

    ArrayList<String> toppings = new ArrayList<>();

    public enum SizeType {
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
        toppings.add(topping);
        return topping;
    }

    @Override
    public String toString() {
        if (this.getToppings().isEmpty()) {  
            return "This pizza has a " + crust + " crust and zero toppings.";
        } else {
            return "This pizza has a " + crust + " crust and the following toppings:\n" + this.getToppings();
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
        if (this.getToppings().size() < otherPizza.getToppings().size()) {
            if (this.getCrust().ordinal() < otherPizza.getCrust().ordinal()) {
                return -1;
            }
        } else if ((this.getToppings().size() > otherPizza.getToppings().size()) || (this.getCrust().ordinal() > otherPizza.getCrust().ordinal())) {
            return 1;
        } else {
            return 0;
        }
                return 0;
    }

    
}
