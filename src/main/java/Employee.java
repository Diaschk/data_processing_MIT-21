public class Employee {
    protected String name;
    protected String position;
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Position: " + position);
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Dina", "Network engineer", 50);
        manager.displayInfo();
    }
}

class Manager extends Employee {
    private int teamSize;
    public Manager(String name, String position, int teamSize) {
        super(name, position);
        this.teamSize = teamSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Team Size: " + teamSize);
    }
}
