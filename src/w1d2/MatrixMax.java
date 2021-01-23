package w1d2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class MatrixMax {
	
	Random rndm = new Random();

	public void run() {
		
		var m = new int[rndm.nextInt(10)+1][rndm.nextInt(10)+1];
		for(var r = 0; r < m.length; r++) {
			for(var c = 0; c < m[r].length; c++) {
				m[r][c] = rndm.nextInt(100-10)+10; // 2 digit numbers
			}
		}
		
		System.out.println("Generated matrix:");
		for(var row : m) {
			System.out.println(Arrays.stream(row).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
		}
			
		int best = Integer.MIN_VALUE;
		int br = -1;
		int bc = -1;
		for(var r = 0; r < m.length; r++) {
			for(var c = 0; c < m[r].length; c++) {
				var val = m[r][c];
				if(val > best) {
					best = val;
					br = r;
					bc = c;
				}
			}
		}
		System.out.println(String.format("Largest value in matrix: %d at Row: %d Col: %d (0 indexed)", best, br, bc));
	}
}
