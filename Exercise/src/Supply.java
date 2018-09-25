import java.util.*;

public class Supply extends Action {
    private Warehouse warehouse;

    public Supply(Date date, Store store, Warehouse warehouse) {
        super(date, store);
        this.warehouse = warehouse;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
