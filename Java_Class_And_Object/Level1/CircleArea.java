class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getCircumference() {
        return 2 * Math.PI * radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
}

public class CircleArea {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        c1.display();

        Circle c2 = new Circle(7.5);
        c2.display();
    }
}
