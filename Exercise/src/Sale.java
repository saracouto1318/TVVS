import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Sale extends Action {
    private double price;
    private Employee employee;

    public Sale(Date date, Store store, Employee employee) {
        super(date, store);
        this.price = 0;

        if(store.getEmployees().contains(employee))
            this.employee = employee;
        else
            this.employee = null;
    }

    public double getPrice() {
        return price;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void addProducts(Product product, int quantity) {
        this.getProductsQuantities().put(product, quantity);
        this.price += product.getPrice() * quantity;
    }

    /**
     * Verifies if the product exists on one of the warehouses, if it doesn't a supply order is created
     */
    public void completeSale() {

        for (HashMap.Entry<Product, Integer> entries : this.getProductsQuantities().entrySet()) {
            Product product = entries.getKey();
            int quantity = entries.getValue();

            ArrayList<Warehouse> warehouses = this.getStore().getWarehouses();

            int idWarehouse = 0;

            for (int i = 0; i < warehouses.size(); i++)
                for (HashMap.Entry<Product, Integer> entriesWarehouse : warehouses.get(i).getProducts().entrySet()) {
                    int productReference = entriesWarehouse.getKey().getReference();
                    int productQuantity = entriesWarehouse.getValue();

                    if (productReference == product.getReference())
                        if (productQuantity >= quantity) {
                            idWarehouse = warehouses.get(i).getId();

                            Warehouse warehouse = this.getStore().searchWarehouse(idWarehouse);

                            int afterChange = warehouse.changeProductsQuantity(product, quantity);
                            if (afterChange == quantity) {
                                Supply supply = new Supply(new Date(), this.getStore(), warehouse);
                                supply.addProducts(product, 10); //restore quantity
                                break;
                            } else if (afterChange != 0)
                                quantity = warehouse.changeProductsQuantity(product, quantity);
                            else
                                break;

                        }

                }
        }
    }
}
