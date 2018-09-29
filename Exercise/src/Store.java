import java.util.ArrayList;

/**
 * This class creates a Store
 */
public class Store {
    private String name; //Store's name
    private String address; //Store's address
    private String contact; //Store's contact
    private String email; //Store's email
    private HeadQuarter headQuarter; //Store's headquarter
    private ArrayList<Employee> employees; //Store's list of employees
    private ArrayList<Warehouse> warehouses; //Store's list of warehouses
    private ArrayList<Action> actions; //Store's list of actions

    /**
     * Store's constructor
     * @param name Store's name
     * @param address Store's address
     * @param contact Store's contact
     * @param email Store's email
     * @param headQuarter Store's headquarter
     */
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

    /**
     * @return The store's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The store's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return The store's contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @return The store's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return The store's headquarter
     */
    public HeadQuarter getHeadQuarter() {
        return headQuarter;
    }

    /**
     * @return The store's list of employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * This function adds a employee to the list of employees
     * @param employee Enployee to be added
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * This function removes an employee from the list of employees
     * @param employee Enployee to be removed
     */
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * @return The store's list of warehouses
     */
    public ArrayList<Warehouse> getWarehouses() {
        return warehouses;
    }

    /**
     * This function adds a warehouse to the list of warehouses
     * @param warehouse Warehouse to be added
     */
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    /**
     * This function removes an warehouse from the list of warehouses
     * @param warehouse Warehouse to be removed
     */
    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
        warehouse.removeStore();
    }

    /**
     * @return The store's list of actions
     */
    public ArrayList<Action> getActions() {
        return actions;
    }

    /**
     * This function adds an action to the list of actions
     * @param action Action to be added
     */
    public void addAction(Action action) {
        actions.add(action);
    }

    /**
     * This function removes an action from the list of actions
     * @param action Action to be removed
     */
    public void removeAction(Action action) {
        actions.remove(action);
        action.setStore();
    }

    /**
     * This function searches for a certain warehouse by id
     * @param id Warehouse's id
     * @return The warehouse which id is the same passed as parameter or null if that warehouse doesn't exists
     */
    public Warehouse searchWarehouse(int id){
        for(int i = 0; i < warehouses.size(); i++)
            if(warehouses.get(i).getId() == id)
                return warehouses.get(i);

        return null;
    }

    /**
     * This function searches for a certain employee by name
     * @param name Employee's name
     * @return The employee which name is the same passed as parameter or null if that employee doesn't exists
     */
    public Employee searchEmployee(String name){
        for(int i = 0; i < employees.size(); i++)
            if(employees.get(i).getName() == name)
                return employees.get(i);
        return null;
    }
}
