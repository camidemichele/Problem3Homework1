/**
 * builds the laptops with the custom specifications.
 */
public class LaptopBuilder implements ProductBuilder {

    private String name = "Laptop";
    private String processor = "";
    private String ram = "";
    private String storage = "";
    private String graphicsCard = "";
    private String operatingSystem = "";
    private double price = 800;

    /** changes a laptop attribute. */
    @Override
    public ProductBuilder setAttribute(String attribute, String value) {

        // checks what to change
        switch (attribute.toLowerCase()) {
            case "name":
                name = value;
                break;
            case "processor":
                processor = value;
                break;
            case "ram":
                ram = value;
                break;
            case "storage":
                storage = value;
                break;
            case "graphicscard":
                graphicsCard = value;
                break;
            case "operatingsystem":
                operatingSystem = value;
                break;
            case "price":
                price = Double.parseDouble(value);
                break;
        }

        return this; // lets us keep adding attributes
    }

    /** creates the finished laptop. */
    @Override
    public Product build() {

        // puts the specs in the format from the sample
        String specs = "{Processor=" + processor
                + ", Storage=" + storage + "GB"
                + ", Graphics Card=" + graphicsCard
                + ", Operating System=" + operatingSystem
                + ", RAM=" + ram + "}";

        return new Laptop(name, specs, price);
    }
}

