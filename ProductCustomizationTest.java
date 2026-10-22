
import java.util.ArrayList;

/**
 * tests the product customization system.
 */
public class ProductCustomizationTest {

    /**
     * checks whether a test passes.
     */
    public static void check(boolean condition, String message) {

        if (condition) {
            System.out.println("PASS: " + message);
        } else {
            System.out.println("FAIL: " + message);
        }
    }

    /**
     * runs the tests.
     */
    public static void main(String[] args) {

        // testing the laptop builder
        Product laptop = new LaptopBuilder()
                .setProcessor("Intel i7")
                .setRam(16)
                .setStorage(512)
                .setGraphicsCard("NVIDIA GTX")
                .setOperatingSystem("Windows 10")
                .build();

        check(laptop instanceof Laptop,
                "Laptop builder creates a laptop");

        check(laptop.getPrice() == 800.00,
                "Laptop costs $800");

        check(laptop.getSpecifications().contains("Intel i7"),
                "Laptop processor is correct");

        check(laptop.getSpecifications().contains("RAM=16"),
                "Laptop RAM is correct");

        // testing the smartphone builder
        Product phone = new SmartphoneBuilder()
                .setScreenSize(6.5)
                .setProcessor("Snapdragon")
                .setCameraResolution(48)
                .setBatterySize(4500)
                .setStorage(128)
                .build();

        check(phone instanceof Smartphone,
                "Smartphone builder creates a smartphone");

        check(phone.getPrice() == 800.00,
                "Smartphone costs $800");

        check(phone.getSpecifications().contains("48 MP"),
                "Smartphone camera is correct");

        // testing the csv reader
        CSVReader reader = new CSVReader();

        ArrayList<SupplierProduct> products =
                reader.readProducts("products.csv");

        check(products.size() == 5,
                "Five supplier products were loaded");

        // testing the adapter
        SupplierProductAdapter adapter = new CSVReader();


        SupplierProduct laptopSupplier = null;
        SupplierProduct phoneSupplier = null;

        for (SupplierProduct supplier : products) {

            if (supplier.getProductName().equals("Laptop Model A")) {
                laptopSupplier = supplier;
            }

            if (supplier.getProductName().equals("Smartphone Model X")) {
                phoneSupplier = supplier;
            }
        }

        check(laptopSupplier != null,
                "Supplier laptop was found");

        check(phoneSupplier != null,
                "Supplier smartphone was found");

        if (laptopSupplier != null) {

            Product defaultLaptop = adapter.adapt(laptopSupplier);

            check(defaultLaptop.getName().equals("Laptop Model A"),
                    "Adapter keeps the laptop name");

            check(defaultLaptop.getPrice() == 800.00,
                    "Adapter converts laptop price");

            check(defaultLaptop.getSpecifications().contains("Intel i5"),
                    "Adapter converts laptop specifications");
        }

        if (phoneSupplier != null) {

            Product defaultPhone = adapter.adapt(phoneSupplier);

            check(defaultPhone.getPrice() == 999.09,
                    "Adapter converts smartphone price");

            check(defaultPhone.getSpecifications().contains("Android"),
                    "Adapter converts smartphone specifications");
        }

        System.out.println("\nProduct tests finished!");
    }
}
