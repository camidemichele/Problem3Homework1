
/**
 * stores product information from the supplier.
 */
public class SupplierProduct {

    private String productName;
    private String processor;
    private String ram;
    private String storage;
    private String integrated;
    private String operatingSystem;
    private String price;

    /**
     * creates a supplier product using CSV information.
     */
    public SupplierProduct(String productName, String processor,
                           String ram, String storage, String integrated,
                           String operatingSystem, String price) {

        this.productName = productName;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.integrated = integrated;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getIntegrated() {
        return integrated;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getPrice() {
        return price;
    }
}
