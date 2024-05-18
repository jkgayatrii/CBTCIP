package Project2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class UserLogin {
    private String username;
    private String password;
    private String profileInfo;

    public UserLogin(String username, String password, String profileInfo) {
        this.username = username;
        this.password = password;
        this.profileInfo = profileInfo;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getProfileInfo() {
        return profileInfo;
    }

    public void updateProfileInfo(String profileInfo) {
        this.profileInfo = profileInfo;
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
