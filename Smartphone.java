
/**
 * represents a customized smartphone.
 */
public class Smartphone extends Product {

    /**
     * creates a smartphone with the chosen specifications.
     */
    public Smartphone(double screenSize, String processor,
                      int cameraResolution, int batterySize, int storage) {

        super("Customized Smartphone",
                "Screen: " + screenSize + " inches"
                        + ", Processor: " + processor
                        + ", Camera: " + cameraResolution + " MP"
                        + ", Battery: " + batterySize + " mAh"
                        + ", Storage: " + storage + " GB",
                800.00);
    }
}
