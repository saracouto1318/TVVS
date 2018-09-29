/**
 * This class creates a store's employee
 */
public class Employee {
    private String name; //Employee's name
    private Store store; //Store where the employee works

    /**
     * Employee's constructor
     * @param name Employee's name
     * @param store Store where the employee works
     */
    public Employee(String name, Store store) {
        this.name = name;
        this.store = store;
        this.store.addEmployee(this);
    }

    /**
     * @return The employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The store where the employee works
     */
    public Store getStore() { return store; }
}
