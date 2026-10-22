
/**
 * stores the basic information for a product.
 */
public class Product {

    private String name;
    private String specifications;
    private double price;

    /**
     * creates a product with its information.
     */
    public Product(String name, String specifications, double price) {
        this.name = name;
        this.specifications = specifications;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSpecifications() {
        return specifications;
    }

    public double getPrice() {
        return price;
    }

    /**
     * prints the product information.
     */
    public void displayDetails() {
        System.out.println("Product: " + name);
        System.out.println("Specifications: " + specifications);
        System.out.printf("Price: $%.2f%n", price);
    }
}
