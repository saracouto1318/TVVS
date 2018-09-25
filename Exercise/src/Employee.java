public class Employee {
    private String name;
    private Store store;

    public Employee(String name, Store store) {
        this.name = name;
        this.store = store;
        this.store.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Store getStore() { return store; }
}
