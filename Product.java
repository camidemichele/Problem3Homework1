/**
 * stores information shared by all products.
 */
public abstract class Product {

    protected String name;
    protected String type;
    protected String specs;
    protected double price;

    /** creates a product with its information. */
    public Product(String name, String type, String specs, double price) {
        this.name = name;
        this.type = type;
        this.specs = specs;
        this.price = price;
    }

    /** returns the name of the product. */
    public String getName() {
        return name;
    }

    /** displays the product information. */
    public void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Specifications: " + specs);
        System.out.println("Price: $" + price);
    }
}
