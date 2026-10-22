
/**
 * represents a customized laptop
 */
public class Laptop extends Product {

    /**
     * creates a laptop with the chosen specifications.
     */
    public Laptop(String processor, int ram, int storage,
                  String graphicsCard, String operatingSystem) {

        super("Laptop",
                "{Processor=" + processor
                        + ", Storage=" + storage + "GB"
                        + ", Graphics Card=" + graphicsCard
                        + ", Operating System=" + operatingSystem
                        + ", RAM=" + ram + "}",
                800.00);
    }
}
