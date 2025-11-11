// AnimalHierarchy.java
import java.util.*;

class Animal { public String toString() { return "Animal"; } }
class Dog extends Animal { public String toString() { return "Dog"; } }
class Cat extends Animal { public String toString() { return "Cat"; } }

public class AnimalHierarchy {
    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) System.out.println(a);
    }

    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
        List<Cat> cats = Arrays.asList(new Cat(), new Cat());
        printAnimals(dogs);
        printAnimals(cats);
    }
}
