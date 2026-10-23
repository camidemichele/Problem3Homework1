/**
 * manages the construction of products.
 */
public class ProductDirector {

    /** builds a product using the given builder. */
    public Product construct(ProductBuilder builder) {

        return builder.build(); // gets the finished product
    }
}
