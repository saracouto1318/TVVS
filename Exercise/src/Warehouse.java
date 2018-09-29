import java.util.HashMap;

/**
 * This class creates the respective store's warehouses
 */
public class Warehouse {
    private int id; //Warehouse's identification
    private HashMap<Product, Integer> products; //Warehouse products and respective quantities
    private Store store; //Store where the warehouse exists

    /**
     * Warehouse's constructor
     * @param store Store where the warehouse exists
     */
    public Warehouse(Store store) {
        this.store = store;
        this.id = this.store.getWarehouses().size() + 1;
        this.products = new HashMap<>();
        this.store.addWarehouse(this);
    }

    /**
     * @return The warehouse identification
     */
    public int getId() {
        return id;
    }

    /**
     * @return The warehouse's main store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @return The warehouse products and quantities
     */
    public HashMap<Product, Integer> getProducts() {
        return this.products;
    }

    /**
     * This function removes the warehouse's store putting it null
     */
    public void removeStore() {
        this.store = null;
    }

    /**
     * This function adds a product to the warehouse
     * @param product Product to be added
     * @param quantity Products's quantity
     */
    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    /**
     * This function removes a product from the warehouse
     * @param product Product to be removed
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * This function changes the quantity of a product by removing a quantity passed as a function parameter
     * @param product Product to be updated
     * @param quantity Quantity to be reduced
     * @return If the quantity to be removed is less than the existing quantity, only the product update is done
     * in the warehouse and the function returns 0.
     * If the product does not have the quantity that should be reduced, it is removed from the warehouse and the
     * function returns to quantity of product that has yet to be reduced.
     */
    public int changeProductsQuantity(Product product, int quantity) {
        if(this.products.containsKey(product)){
            int productQuantity = 0;
            if(this.products.get(product) - quantity > 0){
                productQuantity = this.products.get(product) - quantity;
                this.products.remove(product);
                addProduct(product, productQuantity);
                return 0;
            }
            else {
                productQuantity = quantity - this.products.get(product);
                removeProduct(product);
                return productQuantity;
            }
        }
        return quantity;
    }
}
