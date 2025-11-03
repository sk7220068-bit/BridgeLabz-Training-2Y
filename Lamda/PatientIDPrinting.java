import java.util.*;

public class PatientIDPrinting {
    public static void main(String[] args) {
        List<String> patientIDs = Arrays.asList(
            "PID001", "PID002", "PID003", "PID004", "PID005"
        );

        System.out.println("Patient IDs for Admin Verification:");
        patientIDs.forEach(System.out::println);
    }
}
