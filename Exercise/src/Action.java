import java.util.Date;
import java.util.HashMap;

/**
 * Action can be a sale or a supply order
 */
public class Action {
    private int idAction;
    private Date date;
    private HashMap<Product, Integer> productsQuantities; //Products and quantities of products by order/action
    private Store store;

    public Action(Date date, Store store) {
        this.store = store;

        //this.idAction = store.getActions().size() + 1; //Solution

        this.idAction = store.getActions().size();

        this.date = date;
        this.productsQuantities = new HashMap<>();
        this.store.addAction(this);
    }

    public int getIdAction() {
        return idAction;
    }

    public Date getDate() {
        return date;
    }

    public HashMap<Product, Integer> getProductsQuantities() {
        return productsQuantities;
    }

    public Store getStore() {
        return store;
    }

    public void setStore() {
        store = null;
    }

    public void addProducts(Product product, int quantity) {
        productsQuantities.put(product, quantity);
    }
}
