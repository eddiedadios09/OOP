public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(String bookId, String title, String author, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    // Getters
    public String getBookId() { return bookId; }
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    // Setters (added so updateBook(...) works)
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setAvailable(boolean available) { this.available = available; }

    // Display helper
    public void displayBookDetails() {
        System.out.printf("%-5s | %-30s | %-20s | %s%n",
                bookId,
                title.length() > 30 ? title.substring(0, 27) + "..." : title,
                author.length() > 20 ? author.substring(0, 17) + "..." : author,
                (available ? "Available" : "Borrowed"));
    }
}