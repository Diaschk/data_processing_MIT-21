public class Vehicle {

    protected String make;
    protected String model;
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Name: " + make + ", Model: " + model);
    }
    public static void main(String[] args) {
        Motorcycle moto = new Motorcycle("BMW ", "F 750 GS", 853);
        moto.displayInfo();
    }
}

class Motorcycle extends Vehicle {
    private int engineCapacity;
    public Motorcycle(String make, String model, int engineCapacity) {
        super(make, model);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
    }
}
