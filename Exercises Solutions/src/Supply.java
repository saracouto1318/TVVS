public class Supply extends Action {
    private Warehouse warehouse;

    public Supply(Store store, Warehouse warehouse) {
        super(store);
        this.warehouse = warehouse;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void addProducts(Product product, int quantity) {
        warehouse.addProduct(product, quantity);
    }

}
