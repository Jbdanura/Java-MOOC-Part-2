import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("Input the age recommendation: ");
            int age = Integer.parseInt(scanner.nextLine());
            books.add(new Book(name, age));
        }

        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                if (b1.getAgeRecommendation() != b2.getAgeRecommendation()) {
                    return Integer.compare(b1.getAgeRecommendation(), b2.getAgeRecommendation());
                } else {
                    return b1.getName().compareTo(b2.getName());
                }
            }
        });

        System.out.println(books.size() + " books in total.");
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book.getName() + " (recommended for " + book.getAgeRecommendation() + " year-olds or older)");
        }
    }
}

class Book {
    private String name;
    private int ageRecommendation;

    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }

    public String getName() {
        return name;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }
}