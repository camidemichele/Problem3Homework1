/**
 * represents a laptop product.
 */
public class Laptop extends Product {

    /** creates a laptop with its information. */
    public Laptop(String name, String specs, double price) {
        super(name, "Laptop", specs, price); // gets the shared product information
    }
}
