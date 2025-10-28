import java.util.*;

// Generic Participant class
class Participant<T> {
    private T rollNumber;
    private String name;
    private String branch;

    public Participant(T rollNumber, String name, String branch) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.branch = branch;
    }

    public T getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Branch: " + branch;
    }
}

// EventRegistrationSystem demonstrating Generics and Collections
class EventRegistrationSystem<T> {
    private ArrayList<Participant<T>> registeredList;
    private LinkedList<Participant<T>> waitingList;
    private HashSet<T> rollNumbers;

    private int capacity; // Maximum allowed participants

    public EventRegistrationSystem(int capacity) {
        this.capacity = capacity;
        registeredList = new ArrayList<>();
        waitingList = new LinkedList<>();
        rollNumbers = new HashSet<>();
    }

    // Register a participant
    public void registerParticipant(Participant<T> participant) {
        if (rollNumbers.contains(participant.getRollNumber())) {
            System.out.println("Participant with Roll No " + participant.getRollNumber() + " is already registered!");
            return;
        }

        rollNumbers.add(participant.getRollNumber());

        if (registeredList.size() < capacity) {
            registeredList.add(participant);
            System.out.println(participant.getName() + " registered successfully!");
        } else {
            waitingList.add(participant);
            System.out.println("Event full! " + participant.getName() + " added to waiting list.");
        }
    }

    // Cancel registration by roll number
    public void cancelRegistration(T rollNumber) {
        boolean removed = false;

        Iterator<Participant<T>> iterator = registeredList.iterator();
        while (iterator.hasNext()) {
            Participant<T> p = iterator.next();
            if (p.getRollNumber().equals(rollNumber)) {
                iterator.remove();
                rollNumbers.remove(rollNumber);
                removed = true;
                System.out.println(p.getName() + " removed from registered participants.");
                break;
            }
        }

        if (!removed) {
            Iterator<Participant<T>> waitIterator = waitingList.iterator();
            while (waitIterator.hasNext()) {
                Participant<T> p = waitIterator.next();
                if (p.getRollNumber().equals(rollNumber)) {
                    waitIterator.remove();
                    rollNumbers.remove(rollNumber);
                    removed = true;
                    System.out.println(p.getName() + " removed from waiting list.");
                    break;
                }
            }
        }

        if (removed && !waitingList.isEmpty()) {
            // Move one from waiting to registered
            Participant<T> moved = waitingList.removeFirst();
            registeredList.add(moved);
            System.out.println(moved.getName() + " moved from waiting list to registered participants.");
        } else if (!removed) {
            System.out.println("No participant found with Roll No: " + rollNumber);
        }
    }

    // Display registered participants
    public void displayRegistered() {
        System.out.println("\n📋 Registered Participants:");
        if (registeredList.isEmpty()) {
            System.out.println("No participants registered yet.");
        } else {
            for (Participant<T> p : registeredList) {
                System.out.println(p);
            }
        }
    }

    // Display waiting list
    public void displayWaitingList() {
        System.out.println("Waiting List:");
        if (waitingList.isEmpty()) {
            System.out.println("No participants in waiting list.");
        } else {
            for (Participant<T> p : waitingList) {
                System.out.println(p);
            }
        }
    }
}

// Main class for testing
public class StudentEventRegistration {
    public static void main(String[] args) {
        EventRegistrationSystem<Integer> event = new EventRegistrationSystem<>(3); // Capacity 3

        Participant<Integer> p1 = new Participant<>(101, "Alice", "CSE");
        Participant<Integer> p2 = new Participant<>(102, "Bob", "ECE");
        Participant<Integer> p3 = new Participant<>(103, "Charlie", "ME");
        Participant<Integer> p4 = new Participant<>(104, "David", "IT");
        Participant<Integer> p5 = new Participant<>(105, "Eva", "CSE");

        event.registerParticipant(p1);
        event.registerParticipant(p2);
        event.registerParticipant(p3);
        event.registerParticipant(p4);
        event.registerParticipant(p5);

        event.displayRegistered();
        event.displayWaitingList();

        System.out.println("Cancelling Registration of Roll No 102 (Bob) ---");
        event.cancelRegistration(102);

        event.displayRegistered();
        event.displayWaitingList();
    }
}
