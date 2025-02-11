import java.util.ArrayList;

public class Pizza {
    enum CrustType {
        Plain,
        Butter,
        Garlic,
        GarlicButter,
        Cheese
    }

    ArrayList<String> toppings = new ArrayList<String>();

    enum SizeType {
        Small,
        Medium,
        Large,
        XLarge,
        XXLarge,
        Party
    }

    public Pizza() {
        CrustType crust = CrustType.Plain;
        SizeType size = SizeType.Small;
    }
}
