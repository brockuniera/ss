package w1d1;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class Patterns {
	public void run() throws IOException {
		String filename = String.join(File.separator, "src","w1d1","text.txt");
        File file = new File(filename);
		System.out.println(Files.lines(file.toPath()).collect(Collectors.joining("\n")));
	}
}
