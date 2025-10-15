import java.io.*;
import java.util.*;

public class FileHandler {

    public static List<User> loadUsers(String filename) throws IOException {
        File file = new File(filename);

        // ✅ Create file with default data if it doesn't exist
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write("U001,John Doe,pass123,user\n");
                bw.write("U002,Jane Smith,abc123,user\n");
                bw.write("A001,Admin,admin123,admin\n");
            }
        }

        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                users.add(new User(parts[0], parts[1], parts[2], parts[3]));
            }
        }
        return users;
    }

    public static List<Book> loadBooks(String filename) throws IOException {
        File file = new File(filename);

        // ✅ Create file with default books if it doesn't exist
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write("B001,The Great Gatsby,F. Scott Fitzgerald,true\n");
                bw.write("B002,To Kill a Mockingbird,Harper Lee,true\n");
                bw.write("B003,1984,George Orwell,false\n");
            }
        }

        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                books.add(new Book(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3])));
            }
        }
        return books;
    }

    public static List<Transaction> loadTransactions(String filename) throws IOException {
        File file = new File(filename);

        // ✅ Create file with default transactions if it doesn't exist
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                bw.write("T001,U001,B002,2025-10-14,null\n");
                bw.write("T002,U002,B003,2025-10-10,2025-10-13\n");
            }
        }

        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String dateReturned = parts[4].equals("null") ? null : parts[4];
                transactions.add(new Transaction(parts[0], parts[1], parts[2], parts[3], dateReturned));
            }
        }
        return transactions;
    }

    public static void saveBooks(String filename, List<Book> books) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Book b : books) {
                bw.write(b.getBookId() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.isAvailable());
                bw.newLine();
            }
        }
    }

    public static void saveTransactions(String filename, List<Transaction> transactions) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Transaction t : transactions) {
                bw.write(t.getTransactionId() + "," + t.getUserId() + "," + t.getBookId() + ","
                        + t.getDateBorrowed() + "," + (t.getDateReturned() == null ? "null" : t.getDateReturned()));
                bw.newLine();
            }
        }
    }
    public static void saveUsers(String filename, List<User> users) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (User u : users) {
                bw.write(u.getId() + "," + u.getName() + "," + u.getPassword() + "," + u.getRole());
                bw.newLine();
            }
        }
    }

}