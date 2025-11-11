// FruitBox.java
class Fruit {
    String name;
    Fruit(String name) { this.name = name; }
    public String toString() { return name; }
}

class Apple extends Fruit {
    Apple() { super("Apple"); }
}

class Mango extends Fruit {
    Mango() { super("Mango"); }
}

public class FruitBox<T extends Fruit> {
    private java.util.List<T> fruits = new java.util.ArrayList<>();

    public void addFruit(T fruit) { fruits.add(fruit); }
    public void displayFruits() { System.out.println(fruits); }

    public static void main(String[] args) {
        FruitBox<Apple> apples = new FruitBox<>();
        apples.addFruit(new Apple());
        apples.displayFruits();

        // FruitBox<Car> cars = new FruitBox<>(); ❌ Won’t compile (Car not a Fruit)
    }
}
