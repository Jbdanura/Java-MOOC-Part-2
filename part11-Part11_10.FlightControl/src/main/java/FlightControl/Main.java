package FlightControl;

import java.util.*;

class Airplane {
    private String id;
    private int capacity;

    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return id + " (" + capacity + " capacity)";
    }
}

class Flight {
    private Airplane airplane;
    private String departure;
    private String destination;

    public Flight(Airplane airplane, String departure, String destination) {
        this.airplane = airplane;
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return airplane + " (" + departure + "-" + destination + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Airplane> airplanes = new HashMap<>();
        List<Flight> flights = new ArrayList<>();

        System.out.println("Airport Asset Control");
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("1")) {
                System.out.print("Give the airplane id: ");
                String id = scanner.nextLine();
                System.out.print("Give the airplane capacity: ");
                int capacity = Integer.parseInt(scanner.nextLine());
                airplanes.put(id, new Airplane(id, capacity));
            } else if (command.equals("2")) {
                System.out.print("Give the airplane id: ");
                String id = scanner.nextLine();
                Airplane airplane = airplanes.get(id);
                if (airplane == null) {
                    System.out.println("Airplane not found.");
                    continue;
                }
                System.out.print("Give the departure airport id: ");
                String departure = scanner.nextLine();
                System.out.print("Give the target airport id: ");
                String destination = scanner.nextLine();
                flights.add(new Flight(airplane, departure, destination));
            } else if (command.equals("x")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }

        System.out.println("\nFlight Control");
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("1")) {
                for (Airplane airplane : airplanes.values()) {
                    System.out.println(airplane);
                }
            } else if (command.equals("2")) {
                for (Flight flight : flights) {
                    System.out.println(flight);
                }
            } else if (command.equals("3")) {
                System.out.print("Give the airplane id: ");
                String id = scanner.nextLine();
                Airplane airplane = airplanes.get(id);
                if (airplane != null) {
                    System.out.println(airplane);
                } else {
                    System.out.println("Airplane not found.");
                }
            } else if (command.equals("x")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}
