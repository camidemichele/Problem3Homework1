/**
 * builds smartphones with custom specifications.
 */
public class SmartphoneBuilder implements ProductBuilder {

    private String name = "Smartphone";
    private String processor = "";
    private String ram = "";
    private String storage = "";
    private String graphicsCard = "";
    private String operatingSystem = "";
    private double price = 800;

    /** changes a smartphone attribute. */
    @Override
    public ProductBuilder setAttribute(String attribute, String value) {

        // checks which phone detail we're changing
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

        return this; // lets us keep customizing
    }

    /** creates the finished smartphone. */
    @Override
    public Product build() {

        String specs = "{Processor=" + processor
                + ", Storage=" + storage
                + ", Graphics Card=" + graphicsCard
                + ", Operating System=" + operatingSystem
                + ", RAM=" + ram + "}";

        return new Smartphone(name, specs, price);
    }
}
