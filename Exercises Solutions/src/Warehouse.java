import java.util.HashMap;

public class Warehouse {
    private int id;
    private HashMap<Product, Integer> products;
    private Store store;

    public Warehouse(Store store) {
        this.store = store;
        this.id = this.store.getWarehouses().size() + 1;
        this.products = new HashMap<>();
        this.store.addWarehouse(this);
    }

    public int getId() {
        return id;
    }

    public Store getStore() {
        return store;
    }

    public HashMap<Product, Integer> getProducts() {
        return this.products;
    }

    public void removeStore() {
        this.store = null;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

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
