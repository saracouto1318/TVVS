/**
 * This class creates a product
 */
public class Product {
    private int reference; //Product's reference
    private String name; //Product's name
    private double price; //Product's price

    /**
     * Product's constructor
     * @param reference Product's reference
     * @param name Product's name
     * @param price Product's price
     */
    public Product(int reference, String name, double price) {
        this.reference = reference;
        this.name = name;
        this.price = price;
    }

    /**
     * @return The product's reference
     */
    public int getReference() {
        return reference;
    }

    /**
     * This function sets the product's reference
     * @param reference New reference
     */
    public void setReference(int reference) {
        this.reference = reference;
    }

    /**
     * @return The product's name
     */
    public String getName() {
        return name;
    }

    /**
     * This function sets the product's name
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The product's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * This function sets the product's price
     * @param price New price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
