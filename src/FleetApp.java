import java.util.*;

public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("""
                Fleet Management System
                1. Print all vehicles
                2. Add new car
                3. Add new bus
                4. Show total yearly insurance fees
                5. Show vehicles older than N years
                6. Perform service for all vehicles
                7. Quit
                """);

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> printAll();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> showInsurance();
                case 5 -> showOlderThan();
                case 6 -> serviceAll();
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void printAll() {
        if (vehicles.isEmpty())
            System.out.println("No vehicles in the fleet");
        else
            vehicles.forEach(System.out::println);
    }

    private void addCar() {
        System.out.print("Model year price doors: ");
        vehicles.add(new Car(
                sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt()));
    }

    private void addBus() {
        System.out.print("Model year price capacity: ");
        vehicles.add(new Bus(
                sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt()));
    }

    private void showInsurance() {
        double sum = 0;
        for (Vehicle v : vehicles)
            sum += v.calculateInsuranceFee();
        System.out.println("Total insurance: " + sum);
    }

    private void showOlderThan() {
        System.out.print("Current year and N: ");
        int year = sc.nextInt();
        int n = sc.nextInt();
        vehicles.stream()
                .filter(v -> v.getAge(year) > n)
                .forEach(System.out::println);
    }

    private void serviceAll() {
        for (Vehicle v : vehicles) {
            Servicable s = v; // polymorphism
            s.performService();
        }
    }

    public static void main(String[] args) {
        new FleetApp().run();
    }
}
