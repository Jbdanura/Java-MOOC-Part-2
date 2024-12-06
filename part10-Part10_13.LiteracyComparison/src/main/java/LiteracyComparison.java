import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
 
        ArrayList<LiteracyRecord> results = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(l -> l.split(","))
                    .map(a -> new LiteracyRecord(a[2].replace("(%)", "").trim(), a[3], Integer.valueOf(a[4]), Double.parseDouble(a[5])))
                    .forEach(t -> results.add(t));
        } catch (IOException exception) {
            System.out.println("Error with reading file");
        }
        
        results.stream().sorted((t1, t2) -> {
            if (t1.getLiteracyPercentage() > t2.getLiteracyPercentage()) {
                return 1;
            }
            if (t1.getLiteracyPercentage() < t2.getLiteracyPercentage()) {
                return -1;
            }
            return 0;
        }).forEach(t -> System.out.println(t));
    }
}

class LiteracyRecord {
    private String demographic;
    private String country;
    private int year;
    private double literacyPercentage;
 
    public LiteracyRecord(String demographic, String country, int year, double literacyPercentage) {
        this.demographic = demographic;
        this.country = country;
        this.year = year;
        this.literacyPercentage = literacyPercentage;
    }
 
    public double getLiteracyPercentage() {
        return literacyPercentage;
    }
 
    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.demographic + ", " + this.literacyPercentage;
    }
}