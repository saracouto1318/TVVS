import java.util.ArrayList;
import java.util.Date;

public class Store {
    private String name;
    private String address;
    private String contact;
    private String email;
    private HeadQuarter headQuarter;
    private ArrayList<Employee> employees;
    private ArrayList<Warehouse> warehouses;
    private ArrayList<Action> actions;

    public Store(String name, String address, String contact, String email, HeadQuarter headQuarter) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.headQuarter = headQuarter;
        this.headQuarter.addStore(this);
        this.employees = new ArrayList<>();
        this.warehouses = new ArrayList<>();
        this.actions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public HeadQuarter getHeadQuarter() {
        return headQuarter;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
        warehouse.removeStore();
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
        action.setStore();
    }

    public Warehouse searchWarehouse(int id){
        for(int i = 0; i < warehouses.size(); i++)
            if(warehouses.get(i).getId() == id)
                return warehouses.get(i);

        return null;
    }

    public Employee searchEmployee(String name){
        for(int i = 0; i < employees.size(); i++)
            if(employees.get(i).getName() == name)
                return employees.get(i);
        return null;
    }
}
