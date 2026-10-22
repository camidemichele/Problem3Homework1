
/**
 * builds a laptop by choosing its specifications
 */
public class LaptopBuilder implements ProductBuilder {

    private String processor;
    private int ram;
    private int storage;
    private String graphicsCard;
    private String operatingSystem;

    /**
     * sets the laptop processor
     */
    public LaptopBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    /**
     * sets the laptop RAM
     */
    public LaptopBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    /**
     * sets the laptop storage
     */
    public LaptopBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    /**
     * sets the graphics card
     */
    public LaptopBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    /**
     * sets the operating system
     */
    public LaptopBuilder setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    /**
     * creates the finished laptop
     */
    @Override
    public Product build() {
        return new Laptop(processor, ram, storage,
                graphicsCard, operatingSystem);
    }
}
