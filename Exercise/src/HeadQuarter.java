import java.util.ArrayList;

public class HeadQuarter {
    private String address;
    private String contact;
    private String email;
    private ArrayList<Store> stores;

    public HeadQuarter(String address, String contact, String email){
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.stores = new ArrayList<>();
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

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void addStore(Store store){
        if(stores.isEmpty())
            stores.add(store);
        else
            for(int i = 0; i < stores.size(); i++)
                if(!stores.get(i).getName().equals(store.getName()))
                    stores.add(store);
    }

    public void removeStore(Store store){
        stores.remove(store);
    }

    public Store searchStore(String name) {
        for(int i = 0; i < this.stores.size(); i++)
            if(this.stores.get(i).getName() == name)
                return this.stores.get(i);
        return null;
    }

    public ArrayList<Employee> searchEmployeesByStore(Store store) {
        for(int i = 0; i < this.stores.size(); i++)
            if(this.stores.get(i).getName().equals(store.getName()))
                return this.stores.get(i).getEmployees();

        return new ArrayList<>();
    }

    public Employee searchEmployeeByStoreByName(Store store, String name) {
        return store.searchEmployee(name);
    }

    public Store searchStoreByEmployee(Employee employee) {
        for(int i = 0; i < this.stores.size(); i++)
            if(this.stores.get(i).getEmployees().contains(employee))
                return this.stores.get(i);

        return null;
    }
}
