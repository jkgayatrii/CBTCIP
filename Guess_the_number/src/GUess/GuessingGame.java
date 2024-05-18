package GUess;
import java.util.Scanner; 

public class GuessingGame {
    private static int score = 0;
    
    public static void main(String[] args) {
        System.out.println("Let's play a game. I'll pick a number between 1 and 100, and you try to guess it.");
        
        Scanner sc1 = new Scanner(System.in);
        boolean playAgain=true;
        
        while (playAgain) {
            start();
            System.out.println("Would you like to play again? (Y/N)");
            char input = sc1.next().charAt(0); 
            playAgain = (input == 'Y' || input == 'y');
        }

        System.out.println("Thanks for playing.");
        sc1.close(); 
    }

    
    public static void start() {
        int cNumber, userNo, Count;
        cNumber = (int)(100 * Math.random()) + 1;
        Count = 0;
        
        System.out.println();
        System.out.println("What is your first guess?");
        Scanner sc = new Scanner(System.in);
        
        while (true) {
        	userNo = sc.nextInt();
            Count++;
            
            if (userNo == cNumber) {
                score++;
                if(Count<2) {
                	Count=Count+10;
                	System.out.println("Congratulations:"+"You got in"+Count+"My number was"+cNumber+". Your Score: " + score);
                }
                else if(Count>2&&Count<4) {
                	Count=Count+5;
                	System.out.println("Congratulations:"+"You got in"+Count+"My number was"+cNumber+". Your Score: " + score);
                }else {
                	
                	System.out.println("Congratulations:"+"You got in"+Count+"My number was"+cNumber+". Your Score: " + score);
                }
                
                break;
            }
            
            if (Count == 6) {
               
                System.out.println("You lose. My number was " + cNumber + ". Your Score: " + score);
                System.out.println("You didn't get the number in 6 guesses.");
                break;
            }
            
            if (userNo < cNumber) {
                System.out.println("That's too low. Try again: ");
            } else if (userNo > cNumber) {
                System.out.println("That's too high. Try again: ");
            }
        }
        
        System.out.println();
    }
}
