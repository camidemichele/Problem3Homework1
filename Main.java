import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * runs the product customization and uses builder and adapter patterns.
 */
public class Main {

    public static void main(String[] args) {

        String fileName = "products.csv";

        // first shows the csv contents
        System.out.println("CSV Contents:");

        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
            return;
        }

        // customizes a laptop step by step using builder
        Product customizedLaptop = new LaptopBuilder()
                .setProcessor("Intel i5")
                .setRam(8)
                .setStorage(256)
                .setGraphicsCard("Integrated")
                .setOperatingSystem("Windows 10")
                .build();

        // builder supports smartphone customization so i can create one with different specifications
        Product customizedSmartphone = new SmartphoneBuilder()
                .setScreenSize(6.1)
                .setProcessor("Apple A14 Bionic")
                .setCameraResolution(12)
                .setBatterySize(3500)
                .setStorage(128)
                .build();

        // reading the supplier products
        CSVReader csvReader = new CSVReader();

        ArrayList<SupplierProduct> products =
                csvReader.readProducts(fileName);

        SupplierProductAdapter adapter = new CSVReader();

        String productToFind = "Smartphone Model X";
        Product defaultProduct = null;

        System.out.println("\nLooking for product: " + productToFind);

        // searching for the default smartphone
        for (SupplierProduct supplier : products) {

            String csvLine = supplier.getProductName() + ","
                    + supplier.getProcessor() + ","
                    + supplier.getRam() + ","
                    + supplier.getStorage() + ","
                    + supplier.getIntegrated() + ","
                    + supplier.getOperatingSystem() + ","
                    + supplier.getPrice();

            System.out.println("Processing line: " + csvLine);

            System.out.println("Checking against CSV product name: "
                    + supplier.getProductName());

            if (supplier.getProductName().equals(productToFind)) {

                // adapter converts supplier data into our product
                defaultProduct = adapter.adapt(supplier);

                System.out.println("Product found and built: "
                        + supplier.getProductName());

                break;
            }
        }

        // showing the customized laptop
        System.out.println("\nCUSTOMIZED PRODUCT:");
        customizedLaptop.displayDetails();

        // showing the default product from csv
        System.out.println("\nDEFAULT PRODUCT FROM CSV:");

        if (defaultProduct != null) {
            defaultProduct.displayDetails();
        } else {
            System.out.println("Product not found.");
        }
    }
}


