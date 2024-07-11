package Bank;

import java.util.*;

public class Project {
    HashSet<String> names = new HashSet<>();

    public static void main(String[] args) {
        List<PlayerDetails> player = new ArrayList<>();
        Function function = new Function();
        Project project = new Project();
        Scanner ip = new Scanner(System.in);
        Random rand = new Random();
        String userName;
        while (true) {
            function.login();
            System.out.println("Enter Your Choice: ");
            int choice = ip.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter user Name : ");
                    ip.nextLine();
                    userName = ip.nextLine().toUpperCase();
                    if (project.names.contains(userName)) {
                        for (PlayerDetails p : player) {
                            if (p.getUserName().equals(userName)) {
                                function.successLogin(userName, p.getUserUid(),p.getUserPoints());
                                int num = rand.nextInt(100) + 1;
                                System.out.println(num);
                                boolean hasWon = false;
                                int attempt = 1;
                                System.out.println("Guess a number between 1 to 100");
                                int guess = ip.nextInt();
                                while (!hasWon) {
                                    if(guess==num){
                                        hasWon=true;
                                        break;
                                    }else if (guess < num) {
                                        System.out.println("Guess higher");
                                        if (attempt >= 5) break;
                                        guess = ip.nextInt();
                                    } else{
                                        System.out.println("guess lower");
                                        if (attempt >= 5) break;
                                        guess = ip.nextInt();
                                    }
                                    attempt++;
                                }
                                if (hasWon) {
                                    System.out.println("Congratulation your guess is correct and the number is " + num);
                                    p.updatePoints(110-(attempt * 20));

                                } else {
                                    System.out.println("GAME OVER!!!");
                                    System.out.println("The number is " + num);
                                }
                            }
                        }
                    } else {
                        function.accountNotFound();
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Enter user Name : ");
                    ip.nextLine();
                    userName = ip.nextLine().toUpperCase();
                    if (project.names.contains(userName)) {
                        function.userAlreadyExist();
                        System.out.println("Enter user Name : ");
                        userName = ip.nextLine().toUpperCase();
                        function.reTry();
                    }
                    if(!project.names.contains(userName)) {
                        project.names.add(userName);
                        PlayerDetails newPlayer = new PlayerDetails(userName);
                        player.add(new PlayerDetails(userName));
                        function.accountCreationSuccessful(userName, newPlayer.getUserUid());
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}