class Shape {
    double area() {
        return 0;
    }
}

class Circle extends Shape {
    double radius = 7;

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length = 5;
    double width = 6;

    @Override
    double area() {
        return length * width;
    }
}

public class AreaDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
    }
}
