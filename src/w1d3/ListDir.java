package w1d3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class ListDir extends InputReader {
	public void run() {
		final var path = ask("Input a directory: ");
		if(path.isEmpty())
			return;
		final var f = new File(path.get());
		var names = f.list();
		if(names == null)
			return;
		for(var s : names){
			System.out.println(s);
		}
		
	}
}
