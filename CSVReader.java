import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * reads products from the csv file and converts supplier products.
 */
public class CSVReader implements SupplierProductAdapter {

    /**
     * reads the csv file and returns a list of supplier products.
     */
    public ArrayList<SupplierProduct> readProducts(String fileName) {

        // making a list to store the products...
        ArrayList<SupplierProduct> products = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            reader.readLine(); // skipping the first row with the column names

            String line;

            // going through each row in the csv
            while ((line = reader.readLine()) != null) {

                // splitting the row into separate values
                String[] data = line.split(",", -1);

                if (data.length == 7 && !data[0].trim().isEmpty()) {

                    // making a supplier product using the csv information
                    SupplierProduct product = new SupplierProduct(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            data[4].trim(),
                            data[5].trim(),
                            data[6].trim()
                    );

                    products.add(product); // saving it in the list
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }

        return products;
    }

    /**
     * converts a supplier product into our regular product format.
     */
    @Override
    public Product adapt(SupplierProduct supplier) {

        // putting all the supplier specs together
        String specifications = "{Processor=" + supplier.getProcessor()
                + ", Storage=" + supplier.getStorage()
                + ", Graphics Card=" + supplier.getIntegrated()
                + ", Operating System=" + supplier.getOperatingSystem()
                + ", RAM=" + supplier.getRam() + "}";

        // the price comes as text, so changing it into a number
        double price = Double.parseDouble(supplier.getPrice());

        // making a regular product with the supplier information
        return new Product(
                supplier.getProductName(),
                specifications,
                price
        );
    }
}
