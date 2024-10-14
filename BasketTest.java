import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    @Test
    public void testAddProduct() {
        Task_5 basket = new Task_5();

        basket.addProduct("Milk", 1);
        assertEquals(basket.getProductQuantity("Milk"), 1);

        basket.addProduct("Milk", 2);
        assertEquals(basket.getProductQuantity("Milk"), 3);

        basket.addProduct("Bread", 4);
        assertEquals(basket.getProductQuantity("Bread"), 4);

        assertTrue(basket.getProducts().contains("Bread"));
    }

    @Test
    public void testRemoveProduct() {
        Task_5 basket = new Task_5();

        basket.addProduct("Milk", 1);
        basket.addProduct("Bread", 6);

        basket.removeProduct("Milk");
        assertFalse(basket.getProducts().contains("Milk"));
        assertEquals(basket.getProductQuantity("Bread"), 6);

        basket.removeProduct("Bread");
        assertFalse(basket.getProducts().contains("Bread"));
        assertEquals(basket.getProductQuantity("Bread"), 0);
    }

    @Test
    public void testUpdateProductQuantity() {
        Task_5 basket = new Task_5();

        basket.addProduct("Milk", 1);
        basket.addProduct("Bread", 6);

        basket.updateProductQuantity("Milk", 2);
        assertEquals(basket.getProductQuantity("Milk"), 2);

        basket.updateProductQuantity("Bread", 8);
        assertEquals(basket.getProductQuantity("Bread"), 8);

        basket.updateProductQuantity("Bread", 9);
        assertEquals(basket.getProductQuantity("Bread"), 9);
    }

    @Test
    public void testClear() {
        Task_5 basket = new Task_5();

        basket.addProduct("Milk", 1);
        basket.addProduct("Bread", 6);

        basket.clear();
        assertTrue(basket.getProducts().isEmpty());
    }

    public static void main(String[] args) {
        BasketTest basket = new BasketTest();
        basket.testAddProduct();
        basket.testRemoveProduct();
        basket.testUpdateProductQuantity();
        basket.testClear();
    }
}
