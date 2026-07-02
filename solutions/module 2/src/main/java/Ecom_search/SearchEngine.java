package Ecom_search;

import java.util.Arrays;

public class SearchEngine {

    /**
     * Linear Search: Checks every single element one by one.
     * Does NOT require the array to be sorted.
     */
    public static Product linearSearch(Product[] catalog, int targetId) {
        for (Product product : catalog) {
            if (product.getProductId() == targetId) {
                return product; // Found it
            }
        }
        return null; // Not found
    }

    /**
     * Binary Search: Divides the search interval in half repeatedly.
     * REQUIRES the array to be sorted beforehand.
     */
    public static Product binarySearch(Product[] sortedCatalog, int targetId) {
        int left = 0;
        int right = sortedCatalog.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = sortedCatalog[mid].getProductId();

            if (midId == targetId) {
                return sortedCatalog[mid]; // Found it
            }
            if (midId < targetId) {
                left = mid + 1; // Discard left half
            } else {
                right = mid - 1; // Discard right half
            }
        }
        return null; // Not found
    }

    // Example Usage
    public static void main(String[] args) {
        Product[] catalog = {
                new Product(105, "Wireless Mouse", "Electronics"),
                new Product(101, "Coffee Mug", "Kitchen"),
                new Product(109, "Desk Lamp", "Home"),
                new Product(102, "Mechanical Keyboard", "Electronics")
        };

        // Linear Search (Works on unsorted data)
        System.out.println("Linear Search Result: " + linearSearch(catalog, 109));

        // Binary Search (Must sort data first)
        Arrays.sort(catalog); // Uses the compareTo method in Product class
        System.out.println("Binary Search Result: " + binarySearch(catalog, 102));
    }
}