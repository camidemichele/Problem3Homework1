/**
 * defines the steps for building a product.
 */
public interface ProductBuilder {

    /** sets an attribute of the product. */
    ProductBuilder setAttribute(String attribute, String value);

    /** returns the finished product. */
    Product build();
}

