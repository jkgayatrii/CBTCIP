package Project2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Exam{
    private static Map<String,UserLogin> students = new HashMap<>();
    private static ArrayList<Question> mCqs = new ArrayList<>();
    private static UserLogin currentUser = null;
    private static int score = 0;

    public static void main(String[] args) {
        // Initialize some sample data
        students.put("user1", new UserLogin("gayatri", "PassWord1", "user1Profile"));
        students.put("user2", new UserLogin("Neha", "PassWord2", "user2Pofile"));

        mCqs.add(new Question("Who was the first woman Chief Minister of an Indian state ?", new String[]{"Indira Gandhi ", "Sucheta Kriplani", "Sarojini Naidu ", "Mamta Banerjee "}, 1));
        mCqs.add(new Question("Which of the following is hardware and not software ?", new String[]{"Excel", "Printer driver", "Power Point", "CPU"}, 3));
        mCqs.add(new Question("Which day is celebrated every year as ‘World Environment Day’?",
        		new String[]{"5th April ","5th May","5th June ","5th March"},2));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (currentUser == null) {
                System.out.println("1. Login");
                System.out.println("2. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice == 1) {
                    login(scanner);
                } else if (choice == 2) {
                    break;
                }
            } else {
                System.out.println("1. Update Profile");
                System.out.println("2. Change Password");
                System.out.println("3. Take Exam");
                System.out.println("4. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        updateProfile(scanner);
                        break;
                    case 2:
                        changePassword(scanner);
                        break;
                    case 3:
                        takeExam(scanner);
                        break;
                    case 4:
                        logout();
                        break;
                }
            }
        }

        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (students.containsKey(username) && students.get(username).checkPassword(password)) {
            currentUser = students.get(username);
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void updateProfile(Scanner scanner) {
        System.out.println("Current profile info: " + currentUser.getProfileInfo());
        System.out.println("Enter new profile info:");
        String newProfileInfo = scanner.nextLine();
        currentUser.updateProfileInfo(newProfileInfo);
        System.out.println("Profile updated successfully.");
    }

    private static void changePassword(Scanner scanner) {
        System.out.println("Enter current password:");
        String currentPassword = scanner.nextLine();
        if (currentUser.checkPassword(currentPassword)) {
            System.out.println("Enter new password:");
            String newPassword = scanner.nextLine();
            currentUser.updatePassword(newPassword);
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("Incorrect current password.");
        }
    }

    private static void takeExam(Scanner scanner) {
        score = 0;
        int questionIndex = 0;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Auto-submitting your answers...");
                submitExam();
            }
        };
        timer.schedule(task, 60000);

        while (questionIndex < mCqs.size()) {
            Question q = mCqs.get(questionIndex);
            System.out.println(q.getQuestion());
            for (int i = 0; i < q.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + q.getOptions()[i]);
            }
            System.out.println("Enter your answer (1-" + q.getOptions().length + "):");
            int answer = scanner.nextInt() - 1;
            if (answer == q.getCorrectAnswer()) {
                score++;
            }
            questionIndex++;
        }
        timer.cancel();
        submitExam();
    }

    private static void submitExam() {
        System.out.println("Exam finished. Your score is: " + score + "/" + mCqs.size());
    }

    private static void logout() {
        System.out.println("Logging out...");
        currentUser = null;
    }
}
