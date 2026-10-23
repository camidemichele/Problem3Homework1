/**
 * converts the CSV product information into the product objects.
 */
public class CSVAdapter {

    /** converts a CSV line into a product. */
    public Product toProduct(String csvLine) {

        // here it splits the csv line into its different values
        String[] data = csvLine.split(",", -1);

        // makes sure the line has all seven columns
        if (data.length != 7) {
            throw new IllegalArgumentException("Invalid CSV line");
        }

        // gets the information from each column
        String name = data[0].trim();
        String processor = data[1].trim();
        String ram = data[2].trim();
        String storage = data[3].trim();
        String graphicsCard = data[4].trim();
        String operatingSystem = data[5].trim();
        String price = data[6].trim();

        ProductBuilder builder;

        // checks if the product is a smartphone
        if (name.toLowerCase().contains("smartphone")) {

            builder = new SmartphoneBuilder();

            // sets all the smartphone information
            builder.setAttribute("name", name);
            builder.setAttribute("processor", processor);
            builder.setAttribute("ram", ram);
            builder.setAttribute("storage", storage);
            builder.setAttribute("graphicscard", graphicsCard); // keeps N/A from the csv
            builder.setAttribute("operatingsystem", operatingSystem);
            builder.setAttribute("price", price);

        } else if (name.toLowerCase().contains("laptop")) {

            builder = new LaptopBuilder();

            // sets all the laptop information
            builder.setAttribute("name", name);
            builder.setAttribute("processor", processor);
            builder.setAttribute("ram", ram);
            builder.setAttribute("storage", storage);
            builder.setAttribute("graphicscard", graphicsCard);
            builder.setAttribute("operatingsystem", operatingSystem);
            builder.setAttribute("price", price);

        } else {

            // shows an error if the product type is unknown
            throw new IllegalArgumentException("Unknown product: " + name);
        }

        // creates the director from our uml
        ProductDirector director = new ProductDirector();

        // director finishes building the product
        return director.construct(builder);
    }
}

