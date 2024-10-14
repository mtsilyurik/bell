import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_5 implements Basket{
    private final Map<String, Integer> products = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        if (!products.containsKey(product)) {
            products.put(product, quantity);
        } else {
            products.compute(product, (k, currentQuantity) -> currentQuantity + quantity);
        }
    }

    @Override
    public void removeProduct(String product) {
        if (products.containsKey(product)) {
            products.compute(product, (k, currentQuantity) -> Math.max(currentQuantity - 1, 0));
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            products.compute(product, (k, currentQuantity) -> Math.min(quantity, currentQuantity + quantity));
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        return products.getOrDefault(product, 0);
    }
}
