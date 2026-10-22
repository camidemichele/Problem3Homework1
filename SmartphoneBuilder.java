
/**
 * builds a smartphone by choosing its specifications.
 */
public class SmartphoneBuilder implements ProductBuilder {

    private double screenSize;
    private String processor;
    private int cameraResolution;
    private int batterySize;
    private int storage;

    /**
     * sets the screen size.
     */
    public SmartphoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    /**
     * sets the processor.
     */
    public SmartphoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    /**
     * sets the camera resolution.
     */
    public SmartphoneBuilder setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
        return this;
    }

    /**
     * sets the battery size.
     */
    public SmartphoneBuilder setBatterySize(int batterySize) {
        this.batterySize = batterySize;
        return this;
    }

    /**
     * sets the storage.
     */
    public SmartphoneBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    /**
     * creates the finished smartphone.
     */
    @Override
    public Product build() {
        return new Smartphone(screenSize, processor,
                cameraResolution, batterySize, storage);
    }
}
