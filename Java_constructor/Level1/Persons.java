class Persons {
    String name;
    int age;

    public Persons() {
        this.name = "";
        this.age = 0;
    }

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Persons(Persons other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Persons p1 = new Persons("Alice", 25);
        Persons p2 = new Persons(p1);

        p1.display();
        p2.display();
    }
}
