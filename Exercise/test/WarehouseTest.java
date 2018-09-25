import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void getId() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        Warehouse warehouseTest = new Warehouse(store);

        assertEquals(warehouseTest.getId(), 1);

        Warehouse warehouseTest2 = new Warehouse(store);

        assertEquals(warehouseTest2.getId(), 2);
    }

    @Test
    void getStore() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        Warehouse warehouseTest = new Warehouse(store);

        assertEquals(warehouseTest.getStore(), store);

        Warehouse warehouseTest2 = new Warehouse(store);

        assertEquals(warehouseTest2.getStore(), store);
    }

    @Test
    void getProducts() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        Warehouse warehouseTest = new Warehouse(store);

        assertEquals(warehouseTest.getProducts().size(), 0);

        Product product = new Product(123, "Cake", 3);

        warehouseTest.addProduct(product, 10);

        assertEquals(warehouseTest.getProducts().size(), 1);
    }

    @Test
    void removeStore(){
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        Warehouse warehouseTest = new Warehouse(store);

        assertEquals(warehouseTest.getStore(), store);
        warehouseTest.removeStore();

        assertNull(warehouseTest.getStore());
    }

    @Test
    void addProduct() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        Warehouse warehouseTest = new Warehouse(store);

        Product product = new Product(123, "Cake", 3);

        warehouseTest.addProduct(product, 10);

        assertEquals(warehouseTest.getProducts().size(), 1);

        store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        Warehouse warehouseTest2 = new Warehouse(store);

        warehouseTest2.addProduct(product, 10);

        assertEquals(warehouseTest2.getProducts().size(), 1);
    }

    @Test
    void removeProduct() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        Warehouse warehouseTest = new Warehouse(store);

        Product product = new Product(123, "Cake", 3);

        warehouseTest.addProduct(product, 10);

        assertEquals(warehouseTest.getProducts().size(), 1);

        warehouseTest.removeProduct(product);

        assertEquals(warehouseTest.getProducts().size(), 0);
    }

    /**
     * Bom para exercício 2
     */
    @Test
    void changeProductsQuantity() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        Warehouse warehouseTest = new Warehouse(store);

        Product product = new Product(123, "Cake", 3);

        warehouseTest.addProduct(product, 10);

        assertEquals(warehouseTest.getProducts().size(), 1);

        warehouseTest.changeProductsQuantity(product, 8);

        assertEquals((int)warehouseTest.getProducts().get(product), 2);

        assertEquals(warehouseTest.changeProductsQuantity(product, 3), 1);

        Product product2 = new Product(1234, "Pepsi", 1.5);

        assertEquals(warehouseTest.changeProductsQuantity(product2, 3), 3);
    }
}