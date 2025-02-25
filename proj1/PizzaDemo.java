import java.util.ArrayList;

public class PizzaDemo {
    public static void main(String[] args) {
        // displaying all pizza topping options
        ArrayList<String> toppingsList = new ArrayList<>();
        toppingsList.add("cheese");
        toppingsList.add("onion");
        toppingsList.add("green pepper");
        toppingsList.add("ham");
        toppingsList.add("pineapple");
        toppingsList.add("pepperoni");
        toppingsList.add("black olives");
        toppingsList.add("ground beef");
        toppingsList.add("mushrooms");
        toppingsList.add("italian sausage");
        toppingsList.add("anchovies");
        toppingsList.add("tomatoes");
        toppingsList.add("bacon");
        toppingsList.add("pickles");

        System.out.println("Available pizza toppings:\n");
        for (String toppings : toppingsList) {
            System.out.println(toppings);
        }

        // creating Pizza objects and displaying crust
        // and toppings using toString()
        Pizza meatyPizza = new Pizza();
        meatyPizza.setCrust(Pizza.CrustType.Garlic);
        meatyPizza.setSize(Pizza.SizeType.Medium);
        meatyPizza.addTopping("ground beef");
        meatyPizza.addTopping("ham");
        meatyPizza.addTopping("pepperoni");
        meatyPizza.addTopping("italian sausage");
        meatyPizza.addTopping("cheese");

        Pizza veggiePizza = new Pizza();
        veggiePizza.setCrust(Pizza.CrustType.Garlic);
        veggiePizza.setSize(Pizza.SizeType.Large);
        veggiePizza.addTopping("onion");
        veggiePizza.addTopping("green pepper");
        veggiePizza.addTopping("black olives");
        veggiePizza.addTopping("mushrooms");
        veggiePizza.addTopping("cheese");

        Pizza hawaiianPizza = new Pizza();
        hawaiianPizza.setCrust(Pizza.CrustType.Plain);
        hawaiianPizza.setSize(Pizza.SizeType.XLarge);
        hawaiianPizza.addTopping("ham");
        hawaiianPizza.addTopping("bacon");
        hawaiianPizza.addTopping("pineapple");
        hawaiianPizza.addTopping("cheese");

        Pizza hamburgerPizza = new Pizza();
        hamburgerPizza.setCrust(Pizza.CrustType.GarlicButter);
        hamburgerPizza.setSize(Pizza.SizeType.Party);
        hamburgerPizza.addTopping("ground beef");
        hamburgerPizza.addTopping("pickles");
        hamburgerPizza.addTopping("tomatoes");
        hamburgerPizza.addTopping("cheese");

        // testing out creating a pizza with no toppings
        Pizza saucePizza = new Pizza();

        System.out.println(meatyPizza.toString());
        System.out.println(veggiePizza.toString());
        System.out.println(hawaiianPizza.toString());
        System.out.println(hamburgerPizza.toString());
        System.out.println(saucePizza.toString()); // should return that this pizza has zero toppings

        // comparing pizzas using equals()
        // comparing meaty pizza and veggie pizza -- should return true
        System.out.println(meatyPizza.equals(veggiePizza));

        // comparing meaty pizza and hawaiian pizza -- should return false
        System.out.println(meatyPizza.equals(hawaiianPizza));

        // comparing hawaiian pizza and hamburger pizza --  should return false
        System.out.println(hawaiianPizza.equals(hamburgerPizza));

        // comparing pizzas using compareTo()
        System.out.println(hawaiianPizza.compareTo(meatyPizza)); // should return -1 since hawaiian has less toppings AND and inferior crust
        System.out.println(meatyPizza.compareTo(veggiePizza)); // should return 0 since meaty and veggie have same num of toppings and same crust
        System.out.println(veggiePizza.compareTo(hamburgerPizza)); // should return 1 since hamburger has a superior crust in spite of less toppings
    }
}
