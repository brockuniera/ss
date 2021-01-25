package w1d3;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		new ListDir().run();
		new TextAppender().run();
		new FileCharCounter().run();
	}
}
