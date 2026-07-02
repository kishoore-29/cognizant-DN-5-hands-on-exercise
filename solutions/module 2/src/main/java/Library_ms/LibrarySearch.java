package Library_ms;

import java.util.Arrays;

public class LibrarySearch {

    /**
     * Linear Search: Checks every book one by one.
     * Works perfectly on unsorted arrays.
     */
    public static Book linearSearchByTitle(Book[] library, String targetTitle) {
        for (Book book : library) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book; // Found the book
            }
        }
        return null; // Book not found
    }

    /**
     * Binary Search: Divides the search interval in half.
     * REQUIRES the array to be sorted by title beforehand.
     */
    public static Book binarySearchByTitle(Book[] sortedLibrary, String targetTitle) {
        int left = 0;
        int right = sortedLibrary.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midTitle = sortedLibrary[mid].getTitle();

            // Compare the target title with the middle title (ignoring case)
            int comparison = midTitle.compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return sortedLibrary[mid]; // Found the book
            }
            if (comparison < 0) {
                left = mid + 1; // Target is alphabetically after mid, discard left half
            } else {
                right = mid - 1; // Target is alphabetically before mid, discard right half
            }
        }
        return null; // Book not found
    }

    // Example Usage
    public static void main(String[] args) {
        Book[] library = {
                new Book("B01", "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book("B02", "1984", "George Orwell"),
                new Book("B03", "To Kill a Mockingbird", "Harper Lee"),
                new Book("B04", "Pride and Prejudice", "Jane Austen")
        };

        System.out.println("--- Linear Search (Unsorted Data) ---");
        System.out.println(linearSearchByTitle(library, "1984"));

        // Binary Search requires the data to be sorted first!
        Arrays.sort(library);

        System.out.println("\n--- Binary Search (Sorted Data) ---");
        System.out.println(binarySearchByTitle(library, "The Great Gatsby"));
    }
}