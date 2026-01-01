public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        return basePrice * 0.05 + getAge(2025) * 20;
    }

    @Override
    public void performService() {
        System.out.println("Car " + id + ": oil change and inspection.");
    }

    @Override
    public int getServiceIntervalKm() {
        return 15000;
    }
}
