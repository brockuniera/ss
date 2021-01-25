package w1d3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

public class TextAppender extends InputReader {
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
		
		final var text = ask("Input text to append: ");
		if(text.isEmpty())
			return;
		try {
			Files.writeString(
					p,
					text.get()+System.lineSeparator(),
					StandardCharsets.US_ASCII,
					StandardOpenOption.APPEND);
		} catch(IOException e) {
			System.err.println(e);
			return;
		}
		System.out.println("Wrote to file!");
	}
}
