package w1d1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Random;

public class GuessingGame {
	BufferedReader reader;
	Random random;
	
	public GuessingGame() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		random = new Random();
	}
	
	Optional<Integer> ask(String prompt) {
		while(true) {
			System.out.print(prompt);
			try {
				String line = reader.readLine();
				if(line.equals("q"))
					return Optional.empty();
				int num = Integer.parseInt(line);
				if(!(1 <= num && num <= 100))
					throw new IOException(); // Loop around again
				return Optional.of(num);
			} catch (IOException e) { // readLine
			} catch (NumberFormatException e) { // parseInt
			}
			System.out.println("...that's not a valid input...");
		}
	}
	
	public void run() {
		int chances = 5;
		while(true) {
			int goal = random.nextInt(100)+1; // [1,100]
			var guess = ask("Guess a number 1-100: ");
			if(guess.isEmpty())
				break; // End program on empty
			int x = guess.get();
			var adiff = Math.abs(goal-x);
			if(adiff <= 10) {
				System.out.println(String.format("Nice! You were close enough to the real value: %d",goal));
				break;
			}
			chances -= 1;
			if(chances <= 0) {
				System.out.println("Sorry! You're out of chances :( Game Over!");
				break;
			}
			System.out.println(String.format("Sorry, guess again! You have %d chances left.", chances));
		}
	}
}
