
/**
 * interface for converting supplier products
 * into products our store can use.
 */
public interface SupplierProductAdapter {

    /**
     * converts supplier information into a regular product.
     */
    Product adapt(SupplierProduct supplier);
}
