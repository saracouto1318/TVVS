/**
 * This class creates a supply order. Supply extends the class Action
 */
public class Supply extends Action {
    private Warehouse warehouse; //Warehouse related to the supply order

    /**
     * Supply's constructor
     * @param store Store where the supply order took place
     * @param warehouse Warehouse related to the supply order
     */
    public Supply(Store store, Warehouse warehouse) {
        super(store);
        this.warehouse = warehouse;
    }

    /**
     * @return The warehouse related to the supply order
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }
}
