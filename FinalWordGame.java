import java.util.Random;
import java.util.Scanner;

public class FinalWordGame{
    private static final String[] WORDS = {"java", "python", "programming", "computer", "algorithm", "developer", "keyboard", "language"};
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

            
            while (true) {
            String chosenWord = chooseRandomWord();
            int chances = chosenWord.length()-2;
             StringBuilder guessedWord = new StringBuilder(chosenWord);
                for (int i = 1; i < guessedWord.length() - 1; i++){
                    guessedWord.setCharAt(i, '_');
                }
            int scoretotal = chosenWord.length()-2;

            while (chances > 0){
                System.out.println("Word: " + guessedWord);
                System.out.println("Chances left: " + chances);

                
                System.out.print("Guess a letter: ");
                char guess = scanner.next().charAt(0);

                if (isCorrectGuess(chosenWord, guessedWord, guess)) {
                    
                    System.out.println("Correct guess!");
                } 
                else {
                    chances--;
                    scoretotal--;
                    System.out.println("Incorrect guess. Chances left: " + chances);
                }

                if (chosenWord.equals(guessedWord.toString())) {
                    
                    System.out.println(firstName + "  "+ "Congratulations! You guessed the word: " + chosenWord);
                    System.out.println("Your score : " + (scoretotal/(float)(chosenWord.length()-2))* 10);
                    break;
                }
            }

            System.out.print("Do you want to play again? (1 for yes, 0 for no): ");
            int playAgain = scanner.nextInt();

            if (playAgain > 1 || playAgain < 1) {
                System.out.println(firstName+ "  " +"Goodbye!");
                break;
            }
            continue;
        }
        break;
     }

    }
      private static boolean isCorrectGuess(String word, StringBuilder guessedWord, char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                guessedWord.setCharAt(i, guess);
                correctGuess = true;
            }
        }
        return correctGuess;
    }
    private static String chooseRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(WORDS.length);
        return WORDS[randomIndex];
    }

}
