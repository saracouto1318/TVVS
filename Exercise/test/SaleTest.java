import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @Test
    void getPrice() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        Employee employee = new Employee("John", store);

        Sale sale = new Sale(new Date(), store, employee);

        Product product = new Product(123, "Cake", 3);

        sale.addProducts(product, 2);

        assertEquals(sale.getPrice(), 6);

        Employee employee2 = new Employee("John", new Store("Jumbo", "Road 5", "111222333", "jumbo@info.com", headQuarter));

        Sale sale2 = new Sale(new Date(), store, employee2);

        assertNull((sale2.getEmployee()));
    }

    @Test
    void getEmployee() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        Employee employee = new Employee("John", store);

        Sale sale = new Sale(new Date(), store, employee);

        assertEquals(sale.getEmployee().getName(), "John");
    }

    /**
     * Bom para exercício 3
     */
    @Test
    void completeSale() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        Employee employee = new Employee("John", store);

        Warehouse warehouse = new Warehouse(store);

        Product product = new Product(123, "Cake", 3);

        warehouse.addProduct(product, 10);

        Sale sale = new Sale(new Date(), store, employee);

        sale.addProducts(product, 2);

        Product product2 = new Product(1234, "Pasta", 3);

        warehouse.addProduct(product2, 10);

        sale.addProducts(product2, 3);

        sale.completeSale();

        assertEquals(sale.getPrice(), 15);
        assertEquals((int)warehouse.getProducts().get(product), 8);
        assertEquals((int)warehouse.getProducts().get(product2), 7);
    }
}