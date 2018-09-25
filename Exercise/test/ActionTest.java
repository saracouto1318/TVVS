import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    @Test
    void getId() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        assertNotNull(store);

        Date date = new Date();
        Action action = new Action(date, store);

        assertNotNull(action);

       assertEquals(action.getIdAction(), 1);

        Action action2 = new Action(date, store);
        assertNotNull(action2);

        assertEquals(action2.getIdAction(), 2);
    }

    @Test
    void getDate(){
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        assertNotNull(store);

        Date date = new Date();
        Action action = new Action(date, store);

        assertNotNull(action);

        assertEquals(action.getDate(), date);

        Action action2 = new Action(date, store);
        assertNotNull(action2);

        assertEquals(action2.getDate(), date);
    }

    @Test
    void getProductsQuantities() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        assertNotNull(store);

        Date date = new Date();
        Action action = new Action(date, store);

        assertNotNull(action);

        Product product = new Product(123, "Cake", 2);

        action.addProducts(product, 10);

        assertEquals(action.getProductsQuantities().values().size(), 1);

        int quantity = action.getProductsQuantities().get(product);
        assertEquals(quantity, 10);
    }

    @Test
    void getStore(){
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        assertNotNull(store);

        Date date = new Date();
        Action action = new Action(date, store);

        assertNotNull(action);

        assertEquals(action.getStore().getName(), store.getName());
        assertEquals(action.getStore().getActions().size(), 1);
        assertEquals(action.getStore().getActions().get(0), action);
    }

    @Test
    void addProducts() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        assertNotNull(store);

        Date date = new Date();
        Action action = new Action(date, store);

        assertNotNull(action);

        Product product = new Product(123, "Cake", 1);

        action.addProducts(product, 10);

        assertEquals(action.getProductsQuantities().values().size(), 1);

        Product product2 = new Product(1234, "Tooth paste", 2);

        action.addProducts(product2, 10);

        assertEquals(action.getProductsQuantities().values().size(), 2);
    }

    @Test
    void removeStore(){
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");
        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        assertNotNull(store);

        Date date = new Date();
        Action action = new Action(date, store);

        assertNotNull(action);

        assertEquals(action.getStore(), store);

        action.setStore();

        assertNull(action.getStore());
    }
}