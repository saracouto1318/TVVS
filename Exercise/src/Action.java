import java.util.Date;
import java.util.HashMap;

/**
 * Action can be a sale or a supply order
 */
public class Action {
    private int idAction; //Action's identification
    private Date date; //Action's date
    private HashMap<Product, Integer> productsQuantities; //Products and quantities to be registered in this  order/action
    private Store store; //Store where the action took place

    /**
     * Action's constructor
     * @param store Store where the action took place
     */
    public Action(Store store) {
        this.store = store;

        this.idAction = store.getActions().size();

        this.date = new Date();
        this.productsQuantities = new HashMap<>();
        this.store.addAction(this);
    }

    /**
     * @return The action's identification
     */
    public int getIdAction() {
        return idAction;
    }

    /**
     * @return The action's date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return The action's products and respective quantities
     */
    public HashMap<Product, Integer> getProductsQuantities() {
        return productsQuantities;
    }

    /**
     * @return The store where the action took place
     */
    public Store getStore() {
        return store;
    }

    /**
     * This function sets the action's store, turning it null
     */
    public void setStore() {
        store = null;
    }

    /**
     * This function adds a product and its quantity to the action
     * @param product Product to be added
     * @param quantity Product's quantity to be added
     */
    public void addProducts(Product product, int quantity) {
        productsQuantities.put(product, quantity);
    }
}
