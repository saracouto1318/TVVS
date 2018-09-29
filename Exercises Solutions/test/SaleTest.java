import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @Test
    void getPrice() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        Employee employee = new Employee("John", store);

        Sale sale = new Sale(store, employee);

        Product product = new Product(123, "Cake", 3);

        sale.addProducts(product, 2);

        assertEquals(sale.getPrice(), 6);

        Employee employee2 = new Employee("John", new Store("Jumbo", "Road 5", "111222333", "jumbo@info.com", headQuarter));

        Sale sale2 = new Sale(store, employee2);

        assertNull((sale2.getEmployee()));
    }

    @Test
    void getEmployee() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        Employee employee = new Employee("John", store);

        Sale sale = new Sale(store, employee);

        assertEquals(sale.getEmployee().getName(), "John");
    }

    @Test
    void completeSale() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        assertNotNull(store);

        Employee employee = new Employee("John", store);
        assertNotNull(employee);

        Warehouse warehouse = new Warehouse(store);
        assertNotNull(warehouse);

        Product product = new Product(123, "Cake", 3);
        assertNotNull(product);

        warehouse.addProduct(product, 10);

        Sale sale = new Sale(store, employee);
        assertNotNull(sale);

        sale.addProducts(product, 2);

        Product product2 = new Product(1234, "Pasta", 3);
        assertNotNull(product2);

        warehouse.addProduct(product2, 10);

        sale.addProducts(product2, 3);

        //In this case the warehouse has the two different products
        sale.completeSale();

        assertEquals(sale.getPrice(), 15);
        assertEquals((int)warehouse.getProducts().get(product), 8);
        assertEquals((int)warehouse.getProducts().get(product2), 7);

        //In this case the warehouse doesn't have the product, so a supply order is created
        Product product3 = new Product(12345, "Chocolate", 1);
        assertNotNull(product3);

        Sale sale2 = new Sale(store, employee);
        assertNotNull(sale2);

        assertEquals(store.getActions().size(), 2);

        sale2.addProducts(product3, 10);
        sale2.completeSale();

        assertEquals(store.getActions().size(), 3); //With the supply order

        //In this case the warehouse doesn't have enough product
        Sale sale3 = new Sale(store, employee);
        assertNotNull(sale3);

        Warehouse warehouse2 = new Warehouse(store);
        assertNotNull(warehouse2);

        warehouse2.addProduct(product, 10);

        sale3.addProducts(product, 9);
        sale3.completeSale();

        assertTrue(!warehouse.getProducts().containsKey(product));
        assertEquals((int)warehouse2.getProducts().get(product), 9);
    }
}