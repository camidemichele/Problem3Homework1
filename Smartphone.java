/**
 * this represents a smartphone product.
 */
public class Smartphone extends Product {

    /** creates a smartphone with its information. */
    public Smartphone(String name, String specs, double price) {
        super(name, "Smartphone", specs, price); // gets the shared product information
    }
}
