package Exercise1;
import java.util.HashMap;

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        System.out.println("Adding products...");
        ims.addProduct(new Product("001", "Laptop", 10, 1500.0));
        ims.addProduct(new Product("002", "Smartphone", 20, 800.0));
        
        Product laptop = ims.getProduct("001");
        Product smartphone = ims.getProduct("002");
        System.out.println("Product 001: " + laptop.getProductName() + ", Quantity: " + laptop.getQuantity() + ", Price: $" + laptop.getPrice());
        System.out.println("Product 002: " + smartphone.getProductName() + ", Quantity: " + smartphone.getQuantity() + ", Price: $" + smartphone.getPrice());

        System.out.println("\nUpdating product 001...");
        ims.updateProduct("001", new Product("001", "Laptop", 15, 1400.0));
        laptop = ims.getProduct("001");
        System.out.println("Updated Product 001: " + laptop.getProductName() + ", Quantity: " + laptop.getQuantity() + ", Price: $" + laptop.getPrice());

        System.out.println("\nDeleting product 002...");
        ims.deleteProduct("002");
        smartphone = ims.getProduct("002");
        System.out.println("Product 002 after deletion: " + (smartphone == null ? "Not found" : smartphone.getProductName()));

        System.out.println("\nFinal inventory state:");
        ims.inventory.forEach((id, product) -> {
            System.out.println("Product ID: " + id + ", Name: " + product.getProductName() + ", Quantity: " + product.getQuantity() + ", Price: $" + product.getPrice());
        });
    }
}
