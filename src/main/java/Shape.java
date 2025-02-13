public abstract class Shape {

    public abstract double calculateArea();
    public static void main(String[] args) {
        Shape triangle = new Triangle(8, 18);
        Shape square = new Square(2);

        System.out.println("Triangle area: " + triangle.calculateArea());
        System.out.println("Square area: " + square.calculateArea());
    }

    public static class Triangle extends Shape {

        private double base;
        private double height;
        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return (base * height) / 2;
        }
    }

    public static class Square extends Shape {
        private double side;
        public Square(double side) {
            this.side = side;

        }

        @Override
        public double calculateArea() {
            return side * side;
        }
    }
}

