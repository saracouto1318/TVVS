import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getName() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertNotNull(store);

        Employee employee = new Employee("John", store);

        assertNotNull(employee);

        assertEquals(employee.getName(), "John");

        Employee employee2 = new Employee("Daisy", store);

        assertNotEquals(employee2.getName(), "John");
    }

    @Test
    void getStore() {
        HeadQuarter headQuarter = new HeadQuarter("Roses Street", "222333444", "info@info.com");

        assertNotNull(headQuarter);

        Store store = new Store("Supermarket", "May's Street", "991345654", "super@info.com", headQuarter);

        assertNotNull(store);

        Employee employee = new Employee("John", store);

        assertNotNull(employee);

        assertNotNull(employee.getStore());

        assertTrue(store.getEmployees().contains(employee));
    }
}