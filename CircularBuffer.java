public class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % capacity;
        if (size < capacity) {
            size++;
        } else {
            front = (front + 1) % capacity; // Overwrite oldest
        }
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();
        cb.insert(4);
        cb.display();
    }
}
