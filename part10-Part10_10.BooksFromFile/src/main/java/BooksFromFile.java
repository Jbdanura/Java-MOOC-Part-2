import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BooksFromFile {

    public static List<Book> readBooks(String file) {
        List<Book> books = new ArrayList<>();

        try {
            Files.lines(Paths.get(file))
                .forEach(line -> {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String name = parts[0].trim();
                        int year = Integer.parseInt(parts[1].trim());
                        int pageCount = Integer.parseInt(parts[2].trim());
                        String author = parts[3].trim();
                        books.add(new Book(name, year, pageCount, author));
                    }
                });
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return books;
    }
}
