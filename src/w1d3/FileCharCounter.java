package w1d3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.function.Function;

public class FileCharCounter extends InputReader {
	public void run() {
		final var path = ask("Input a filename: ");
		if(path.isEmpty())
			return;
		Path p = null;
		try {
			p = Path.of(path.get());
		} catch (InvalidPathException e) {
			return;
		}
		
		final var text = ask("Input char to search for:");
		if(text.isEmpty())
			return;
		if(text.get().length() != 1)
			return;
		var c = text.get().codePointAt(0);
		
		try {
			System.out.println(String.format(
							"Char count: %d",
							Files.lines(p).flatMapToInt((x) -> x.chars().filter(i -> i==c)).count()));
		} catch (IOException e) {
			return;
		}
	}
}
