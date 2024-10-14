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
            products.remove(product);
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            products.put(product, quantity);
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        ArrayList<String> res = new ArrayList<>(products.keySet());
        res.trimToSize();
        return res;
    }

    @Override
    public int getProductQuantity(String product) {
        return products.getOrDefault(product, 0);
    }

    @Override
    public String toString() {
        return "Basket " + this.hashCode() + " products: " + products.keySet();
    }
}
