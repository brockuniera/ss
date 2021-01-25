package w1d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public abstract class InputReader {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	Optional<String> ask(String prompt) {
		System.out.print(prompt);
		try {
			String line = reader.readLine();
			if(line == null)
				return Optional.empty();
			return Optional.of(line);
		} catch (IOException | NumberFormatException e) {
			return Optional.empty();
		}
	}
}
