import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadQuarterTest {

    @Test
    void getAddress() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        assertEquals(headQuarter.getAddress(), "Roses Street");
        HeadQuarter headQuarter2 = new HeadQuarter("Tulip Street", "222111666", "info2@info.com");

        assertNotNull(headQuarter2);

        assertEquals(headQuarter2.getAddress(), "Tulip Street");
    }

    @Test
    void getContact(){
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        assertEquals(headQuarter.getContact(), "222333444");
        assertEquals(headQuarter.getEmail(), "info@info.com");

        HeadQuarter headQuarter2 = new HeadQuarter("Tulip Street", "222111666", "info2@info.com");

        assertNotNull(headQuarter2);

        assertEquals(headQuarter2.getContact(), "222111666");
        assertEquals(headQuarter2.getEmail(), "info2@info.com");
    }

    @Test
    void getEmail(){
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        assertEquals(headQuarter.getEmail(), "info@info.com");

        HeadQuarter headQuarter2 = new HeadQuarter("Tulip Street", "222111666", "info2@info.com");

        assertNotNull(headQuarter2);

        assertEquals(headQuarter2.getEmail(), "info2@info.com");
    }

    @Test
    void getStores() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store[] emptyStores = new Store[0];
        assertArrayEquals(headQuarter.getStores().toArray(), emptyStores);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        assertNotNull(store);

        assertEquals(headQuarter.getStores().size(), 1);

        Store store2 = new Store("Supermarket", "June's Street", "991645655", "super2@info.com", headQuarter);
        assertNotNull(store2);

        assertEquals(headQuarter.getStores().size(), 2);

        Store store3 = new Store("Supermarket2", "July's Street", "991645656", "super3@info.com", headQuarter);
        assertNotNull(store3);

        assertEquals(headQuarter.getStores().size(), 3);
    }

    @Test
    void addStore() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store[] emptyStores = new Store[0];
        assertArrayEquals(headQuarter.getStores().toArray(), emptyStores);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertNotNull(store);

        assertEquals(headQuarter.getStores().size(), 1);
    }

    @Test
    void removeStore() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        headQuarter.addStore(store);

        assertEquals(headQuarter.getStores().size(), 1);

        headQuarter.removeStore(store);

        assertEquals(headQuarter.getStores().size(), 0);

    }

    @Test
    void searchStore() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);
        headQuarter.addStore(store);

        assertNotNull(headQuarter.searchStore("Supermarket", "May's Street"));
        assertEquals(headQuarter.searchStore("Supermarket", "May's Street"), store);
        assertNull(headQuarter.searchStore("Supermarket2", "May's Street"));

    }

    @Test
    void searchEmployeesByStore() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(headQuarter.searchEmployeesByStore(store).size(), 0);

        Employee employee = new Employee("John", store);

        assertEquals(headQuarter.searchEmployeesByStore(store).size(), 1);
        assertTrue(headQuarter.searchEmployeesByStore(store).contains(employee));

        HeadQuarter headQuarter2 = new HeadQuarter("Roses Street 2", "112333444", "info2@info.com");

        assertNotNull(headQuarter2);

        Store store2 = new Store("Supermarket", "June's Street", "991345664", "super2@info.com", headQuarter2);
        assertEquals(headQuarter.searchEmployeesByStore(store2).size(), 0);
    }

    @Test
    void searchEmployeeByStoreByName() {
         HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

         assertNotNull(headQuarter);

         Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

         assertEquals(headQuarter.searchEmployeesByStore(store).size(), 0);

         Employee employee = new Employee("John", store);

         assertEquals(headQuarter.searchEmployeeByStoreByName(store, "John"), employee);

         HeadQuarter headQuarter2 = new HeadQuarter("Roses Street 2", "112333444", "info2@info.com");

         assertNotNull(headQuarter2);

         Store store2 = new Store("Supermarket", "June's Street", "991345664", "super2@info.com", headQuarter2);

         assertNull(headQuarter.searchEmployeeByStoreByName(store2, "John"));
    }

    @Test
    void searchStoreByEmployee() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertEquals(headQuarter.searchEmployeesByStore(store).size(), 0);

        Employee employee = new Employee("John", store);

        assertEquals(headQuarter.searchStoreByEmployee(employee).getName(), "Supermarket");

        HeadQuarter headQuarter2 = new HeadQuarter("Roses Street", "222333455", "info2@info.com");

        assertNotNull(headQuarter2);

        Employee employee2 = new Employee("Anna", new Store("Jumbo", "Road 5", "111222333", "jumbo@info.com", headQuarter2));
        assertNull(headQuarter.searchStoreByEmployee(employee2));
    }
}