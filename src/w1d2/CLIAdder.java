package w1d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;


public class CLIAdder {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	Optional<Integer> ask(String prompt) {
		while(true) {
			System.out.print(prompt);
			try {
				String line = reader.readLine();
				int num = Integer.parseInt(line);
				return Optional.of(num);
			} catch (IOException | NumberFormatException e) {
				return Optional.empty();
			}
		}
	}
	
	public void run() {
		int total = 0;
		while(true) {
			var guess = ask("Input a number. Invalid input ends app: ");
			if(guess.isEmpty())
				break; // End program on empty
			total += guess.get();
		}
		System.out.println(String.format("Sum: %d", total));
	}
}
