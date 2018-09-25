import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SupplyTest {

    @Test
    void getWarehouse() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Store", "Street nº 1", "111222333", "info@info.com", headQuarter);

        assertNotNull(store);

        Supply supply = new Supply(new Date(), store, new Warehouse(store));

        assertNotNull(supply);

        assertEquals(supply.getWarehouse().getId(), 1);
    }
}