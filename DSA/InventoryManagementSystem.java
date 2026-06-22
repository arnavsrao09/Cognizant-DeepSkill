package DSA;

import java.util.HashMap;
import java.util.Map;

class InventoryProduct {

    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public InventoryProduct(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: ₹" + price;
    }
}

public class InventoryManagementSystem {

    private HashMap<Integer, InventoryProduct> inventory = new HashMap<>();

    // Add Product
    public void addProduct(InventoryProduct product) {

        inventory.put(product.getProductId(), product);

        System.out.println("Product Added");
    }

    // Update Product
    public void updateProduct(int productId,
                              int newQuantity,
                              double newPrice) {

        InventoryProduct product = inventory.get(productId);

        if (product != null) {

            product.setQuantity(newQuantity);
            product.setPrice(newPrice);

            System.out.println("Product Updated");
        } else {
            System.out.println("Product Not Found");
        }
    }

    // Delete Product
    public void deleteProduct(int productId) {

        if (inventory.remove(productId) != null) {
            System.out.println("Product Deleted");
        } else {
            System.out.println("Product Not Found");
        }
    }

    // Display Inventory
    public void displayInventory() {

        System.out.println("\nInventory:");

        for (Map.Entry<Integer, InventoryProduct> entry
                : inventory.entrySet()) {

            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {

        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addProduct(
            new InventoryProduct(101,
                "Laptop",
                20,
                55000));

        ims.addProduct(
            new InventoryProduct(102,
                "Mouse",
                100,
                500));

        ims.addProduct(
            new InventoryProduct(103,
                "Keyboard",
                50,
                1200));

        ims.displayInventory();

        ims.updateProduct(102,
                150,
                450);

        ims.deleteProduct(103);

        ims.displayInventory();
    }
}