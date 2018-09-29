/**
 * This class creates a sales order. Sale extends the class Action
 */
public class Sale extends Action {
    private double price; //Total price of the sale
    private Employee employee; //Employee that registered the sales order

    /**
     * Sale's constructor
     * @param store Store where the supply order took place
     * @param employee Employee that registered the sales order
     */
    public Sale(Store store, Employee employee) {
        super(store);
        this.price = 0;

        if(store.getEmployees().contains(employee))
            this.employee = employee;
        else
            this.employee = null;
    }

    /**
     * @return The total price of the sale
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return Employee that registered the sales order
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * This function adds a product and its quantity to the sales order. the sales order's price is updated here
     * @param product Product to be added
     * @param quantity Product's quantity to be added
     */
    public void addProducts(Product product, int quantity) {
        this.getProductsQuantities().put(product, quantity);
        this.price += product.getPrice() * quantity;
    }

    /**
     * This function verifies if the product exists on one of the warehouses, if it doesn't a supply order is created
     */
    public void completeSale() {

    }
}
