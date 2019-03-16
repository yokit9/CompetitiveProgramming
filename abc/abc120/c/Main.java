package c;

import static java.lang.System.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		char[] str = sc.next().toCharArray();
		int c0 = 0;
		int c1 = 0;
		for(char c: str) {
			if(c == '0') c0++;
			else c1++;
		}

		out.println(Math.min(c0, c1)*2);
	}
}

