import java.util.ArrayList;

/**
 * This class creates the stores' headquarter
 */
public class HeadQuarter {
    private String address; //Headquarter's address
    private String contact; //Headquarter's contact
    private String email; //Headquarter's email
    private ArrayList<Store> stores; //Headquarter's stores

    /**
     * HeadQuarter's constructor
     * @param address Headquarter's address
     * @param contact Headquarter's contact
     * @param email Headquarter's email
     */
    public HeadQuarter(String address, String contact, String email){
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.stores = new ArrayList<>();
    }

    /**
     * @return The headquarter's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return The headquarter's contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @return The headquarter's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return The headquarter's stores
     */
    public ArrayList<Store> getStores() {
        return stores;
    }

    /**
     * This function adds a store to an headquarter
     * @param store Store to be added
     */
    public void addStore(Store store){
        if(!stores.contains(store))
            stores.add(store);
    }

    /**
     * This function removes a store from the headquarter
     * @param store Store to be removed
     */
    public void removeStore(Store store){
        stores.remove(store);
    }

    /**
     * This function searches for the respective store by name and address
     * @param name Store's name
     * @param address Store's address
     * @return The store if it exist on the headquarter, null if not
     */
    public Store searchStore(String name,String address) {
        for(int i = 0; i < this.stores.size(); i++)
            if(this.stores.get(i).getName() == name && this.stores.get(i).getAddress() == address)
                return this.stores.get(i);
        return null;
    }

    /**
     * This function searches for the employees' of a certain store
     * @param store Store to be searched for
     * @return The employee's list of the store, null if the store doesn't exists
     */
    public ArrayList<Employee> searchEmployeesByStore(Store store) {
        for(int i = 0; i < this.stores.size(); i++)
            if(this.stores.contains(store))
                return this.stores.get(i).getEmployees();

        return new ArrayList<>();
    }

    /**
     * @param store store to be searched for
     * @param name Employee's name
     * @return The employee if the store exists or null if it doesn't
     */
    public Employee searchEmployeeByStoreByName(Store store, String name) {
        if(this.getStores().contains(store))
            return store.searchEmployee(name);
        return null;
    }

    /**
     * @param employee Employee to be searched for
     * @return The store where the employee works, null if the employee doesn't work in any of the headquarter's stores
     */
    public Store searchStoreByEmployee(Employee employee) {
        for(int i = 0; i < this.stores.size(); i++)
            if(this.stores.get(i).getEmployees().contains(employee))
                return this.stores.get(i);

        return null;
    }
}
