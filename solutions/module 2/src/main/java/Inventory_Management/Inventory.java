package Inventory_Management;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    // HashMap chosen for O(1) average time complexity for lookups
    private Map<String, Product> inventoryDb;

    public Inventory() {
        this.inventoryDb = new HashMap<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        if (inventoryDb.containsKey(product.getProductId())) {
            System.out.println("Product ID already exists. Use update instead.");
        } else {
            inventoryDb.put(product.getProductId(), product);
            System.out.println("Product added successfully.");
        }
    }

    // Update an existing product's quantity and price
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = inventoryDb.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (inventoryDb.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }
}