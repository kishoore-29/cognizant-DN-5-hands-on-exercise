package Library_ms;

public class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // Required for sorting the array and performing Binary Search by title
    @Override
    public int compareTo(Book other) {
        // String's compareTo handles alphabetical comparison
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "ID: " + bookId + " | Title: '" + title + "' | Author: " + author;
    }
}
