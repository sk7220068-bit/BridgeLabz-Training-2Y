interface SensitiveData {}

class UserAccount implements SensitiveData {
    String username;
    String password;

    UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class EncryptionProcessor {
    public static void process(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data before storage...");
        } else {
            System.out.println("No encryption needed for this data.");
        }
    }
}

public class SensitiveDataTest {
    public static void main(String[] args) {
        UserAccount user = new UserAccount("admin", "12345");
        String normalData = "Public Report";

        EncryptionProcessor.process(user);
        EncryptionProcessor.process(normalData);
    }
}
