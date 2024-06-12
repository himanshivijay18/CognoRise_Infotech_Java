import java.util.*;

  /*
        Generate a random number using the Random class.
        ● Prompt the user for input using Scanner.
        ● Compare the user's guess with the generated number.
        ● Provide feedback on whether the guess is too high, too low, or correct using
          conditional statements (if).
        ● Use a loop (e.g., while) to allow multiple attempts.
        ● Track the number of attempts and stop the game after a predefined limit in java
         */

public class NumberGuessing {
    int randomNo;
    int attempts;
     int max_attempts;

    public  NumberGuessing(int max_attempts){
        Random random = new Random();
        randomNo = random.nextInt(10) + 1;
        this.max_attempts = max_attempts;
        int totalscore = 0;
    }

    public void play(){
        Scanner sc = new Scanner (System.in);
        System.out.println("Welcome to the number guessing game! I've selected a number, can you guess it? ");
        while(attempts < max_attempts){
            System.out.println("Enter the number you guessed : ");
            int guess = sc.nextInt();
            attempts++;
            if(guess == randomNo){
                System.out.println("Congratulations! You guessed the correct number which is " + randomNo);
                System.out.println("Total score : " + attempts) ;
                break;
            }
            else if(guess < randomNo){
                System.out.println("The number you guessed is too smaller which is " + guess);
                System.out.println("Total score : " + attempts) ;
            }
            else{
                System.out.println("The number you guessed is too larger, plz try again");
                System.out.println("Total score : " + attempts) ;
            }
        }

        System.out.println("The actual number was " + randomNo);
    }
    public static void main(String[] args){

    NumberGuessing game = new NumberGuessing(5);
    game.play();
    }
}
