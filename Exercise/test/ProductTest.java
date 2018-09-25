import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getReference() {
        Product product = new Product(123, "Cake", 5);
        Product product2 = new Product(345, "Tooth Paste", 2.4);

        assertEquals(product.getReference(), 123);
        assertEquals(product2.getReference(), 345);

        assertNotEquals(product.getReference(), product2.getReference());
    }

    @Test
    void setReference() {
        Product product = new Product(123, "Cake", 5);

        assertEquals(product.getReference(), 123);

        product.setReference(1234);

        assertEquals(product.getReference(), 1234);
    }

    @Test
    void getName() {
        Product product = new Product(123, "Cake", 2.5);
        Product product2 = new Product(345, "Tooth Paste", 4);

        assertNotNull(product);
        assertNotNull(product2);

        assertEquals(product.getName(), "Cake");
        assertEquals(product2.getName(), "Tooth Paste");

        assertNotEquals(product.getName(), product2.getName());
    }

    @Test
    void setName() {
        Product product = new Product(123, "Cake", 3);

        assertNotNull(product);

        assertEquals(product.getName(), "Cake");

        product.setName("Cake2");

        assertEquals(product.getName(), "Cake2");
    }

    @Test
    void getPrice() {
        Product product = new Product(123, "Cake", 3);

        assertNotNull(product);

        assertEquals(product.getPrice(), 3);
    }

    @Test
    void setPrice() {
        Product product = new Product(123, "Cake", 3);

        assertNotNull(product);

        assertEquals(product.getPrice(), 3);

        product.setPrice(1.2);

        assertNotEquals(product.getPrice(), 3);
        assertEquals(product.getPrice(), 1.2);
    }
}