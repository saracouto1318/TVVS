import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void getMainParameters() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertNotNull(store);

        assertEquals(store.getName(), "Supermarket");
        assertEquals(store.getAddress(), "May's Street");
        assertEquals(store.getContact(), "991345654");
        assertEquals(store.getEmail(), "super@info.com");
        assertEquals(store.getHeadQuarter().getAddress(), "Roses Street");
    }

    @Test
    void getAddEmployees() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(store.getEmployees().size(), 0);

        Employee employee = new Employee("John", store);

        assertEquals(store.getEmployees().size(), 1);
    }

    @Test
    void removeEmployee() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(store.getEmployees().size(), 0);

        Employee employee = new Employee("John", store);

        assertEquals(store.getEmployees().size(), 1);

        store.removeEmployee(employee);
        assertEquals(store.getEmployees().size(), 0);
    }

    @Test
    void getAddWarehouses() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(store.getWarehouses().size(), 0);

        Warehouse warehouse = new Warehouse(store);

        assertTrue(store.getWarehouses().contains(warehouse));
    }

    @Test
    void removeWarehouse() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(store.getWarehouses().size(), 0);

        Warehouse warehouse = new Warehouse(store);

        assertTrue(store.getWarehouses().contains(warehouse));

        store.removeWarehouse(warehouse);

        assertTrue(!store.getWarehouses().contains(warehouse));
    }

    @Test
    void getActions() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(store.getActions().size(), 0);
    }

    @Test
    void addAction() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(store.getActions().size(), 0);

        Action action = new Action(store);

        assertTrue(store.getActions().contains(action));
    }

    @Test
    void removeAction() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(store.getActions().size(), 0);

        Action action = new Action(store);

        assertTrue(store.getActions().contains(action));

        store.removeAction(action);
    }

    @Test
    void searchWarehouse() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(store.getWarehouses().size(), 0);

        Warehouse warehouse = new Warehouse(store);

        assertTrue(store.getWarehouses().contains(warehouse));

        assertEquals(store.searchWarehouse(warehouse.getId()), warehouse);

        assertNull(store.searchWarehouse(10));
    }

    @Test
    void searchEmployee() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertNull(store.searchEmployee("John"));

        Employee employee = new Employee("John", store);

        assertEquals(store.searchEmployee("John"), employee);
    }
}