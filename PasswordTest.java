interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password.length() < 8)
            return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}

public class PasswordTest {
    public static void main(String[] args) {
        String pwd1 = "Secure@123";
        String pwd2 = "weakpass";

        System.out.println("Password: " + pwd1 + " → " + SecurityUtils.isStrongPassword(pwd1));
        System.out.println("Password: " + pwd2 + " → " + SecurityUtils.isStrongPassword(pwd2));
    }
}
