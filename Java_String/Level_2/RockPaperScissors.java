import java.util.Scanner;

class RockPaperScissors {
    public static String getComputerChoice() {
        int n = (int)(Math.random() * 3);
        if (n == 0) return "rock";
        if (n == 1) return "paper";
        return "scissors";
    }

    public static int getWinner(String user, String comp) {
        if (user.equals(comp)) return 0;
        if (user.equals("rock") && comp.equals("scissors")) return 1;
        if (user.equals("paper") && comp.equals("rock")) return 1;
        if (user.equals("scissors") && comp.equals("paper")) return 1;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        int userWins = 0, compWins = 0;

        for (int i = 0; i < games; i++) {
            System.out.print("Enter choice (rock/paper/scissors): ");
            String user = sc.next().toLowerCase();
            String comp = getComputerChoice();
            int res = getWinner(user, comp);
            if (res == 1) userWins++;
            else if (res == -1) compWins++;
            System.out.println("Computer chose: " + comp);
        }

        double userPct = (userWins * 100.0) / games;
        double compPct = (compWins * 100.0) / games;
        System.out.println("User Wins: " + userWins + " (" + userPct + "%)");
        System.out.println("Computer Wins: " + compWins + " (" + compPct + "%)");
        sc.close();
    }
}
