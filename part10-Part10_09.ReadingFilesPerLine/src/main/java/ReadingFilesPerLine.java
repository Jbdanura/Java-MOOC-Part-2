
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ReadingFilesPerLine {
    
    public static List<String> read(String file) {
        try {
            return Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return List.of(); 
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test the method here
    }

}
