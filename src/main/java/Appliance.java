public abstract class Appliance {

    public abstract void turnOn();

    public static void main(String[] args) {
        Appliance washingMachine = new WashingMachine();
        Appliance microwave = new Microwave();
        washingMachine.turnOn();
        microwave.turnOn();
    }

    public static class Microwave extends Appliance {
        @Override
        public void turnOn() {
            System.out.println("Microwave is turned on");

        }
    }

    public static class WashingMachine extends Appliance {
        @Override
        public void turnOn() {
            System.out.println("Washing machine is turned on");
        }
    }
}


