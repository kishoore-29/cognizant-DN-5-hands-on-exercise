package Sort_customers_order;

public class OrderSorter {

    // --- BUBBLE SORT IMPLEMENTATION ---
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                // Sorting descending: swap if current is LESS than next
                if (orders[j].getTotalPrice() < orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped in the inner loop, it's already sorted
            if (!swapped) break;
        }
    }

    // --- QUICK SORT IMPLEMENTATION ---
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);

            // Recursively sort elements before and after partition
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        // Choosing the last element as the pivot
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // Sorting descending: if current element is GREATER than pivot
            if (orders[j].getTotalPrice() > pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap the pivot element with the element at i+1
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // --- EXAMPLE USAGE ---
    public static void main(String[] args) {
        Order[] ordersForBubble = {
                new Order("A01", "Alice", 150.50),
                new Order("A02", "Bob", 89.99),
                new Order("A03", "Charlie", 450.00),
                new Order("A04", "Diana", 12.50)
        };

        // Clone array to test Quick Sort with the same data
        Order[] ordersForQuick = ordersForBubble.clone();

        System.out.println("--- Bubble Sort ---");
        bubbleSort(ordersForBubble);
        for (Order o : ordersForBubble) System.out.println(o);

        System.out.println("\n--- Quick Sort ---");
        quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        for (Order o : ordersForQuick) System.out.println(o);
    }
}