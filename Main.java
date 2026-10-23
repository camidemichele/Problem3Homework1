import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * tests the builder and adapter design patterns.
 */
public class Main {

    /** starts the program. */
    public static void main(String[] args) {

        // stores all the CSV lines
        ArrayList<String> csvLines = new ArrayList<>();

        System.out.println("CSV Contents:");

        // reads the CSV file and prints the contents of each
        try (BufferedReader reader = new BufferedReader(
                new FileReader("products.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line); // shows each CSV line
                csvLines.add(line); // saves it for later
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
            return;
        }
        String productToFind = "Smartphone Model X";

        System.out.println();
        System.out.println("Looking for product: " + productToFind);

        CSVAdapter adapter = new CSVAdapter();

        Product foundProduct = null;

        // starts at 1 to skip the CSV header
        for (int i = 1; i < csvLines.size(); i++) {

            String line = csvLines.get(i);

            if (line.trim().isEmpty()) {
                continue; // skips empty lines
            }

            System.out.println("Processing line: " + line);

            // gets the product name from the first column
            String[] data = line.split(",", -1);

            String csvName = data[0].trim();

            System.out.println("Checking against CSV product name: " + csvName);

            // checks if we found the product we wanted
            if (csvName.equalsIgnoreCase(productToFind)) {

                foundProduct = adapter.toProduct(line);

                System.out.println("Product found and built: "
                        + foundProduct.getName());

                break; // stops searching once we find it
            }
        }

        if (foundProduct == null) {
            System.out.println("Product not found.");
            return;
        }

        // creates the director from our UML
        ProductDirector director = new ProductDirector();

        // creates a laptop builder
        ProductBuilder laptopBuilder = new LaptopBuilder();

        // customizes the laptop like the professor's example
        laptopBuilder.setAttribute("name", "Laptop");
        laptopBuilder.setAttribute("processor", "Intel i5");
        laptopBuilder.setAttribute("ram", "8");
        laptopBuilder.setAttribute("storage", "256");
        laptopBuilder.setAttribute("graphicscard", "Integrated");
        laptopBuilder.setAttribute("operatingsystem", "Windows 10");
        laptopBuilder.setAttribute("price", "800");

        // director builds our customized laptop
        Product customizedProduct = director.construct(laptopBuilder);

        System.out.println();
        System.out.println("CUSTOMIZED PRODUCT:");
        customizedProduct.displayDetails();

        System.out.println();
        System.out.println("DEFAULT PRODUCT FROM CSV:");
        foundProduct.displayDetails();
    }
}


