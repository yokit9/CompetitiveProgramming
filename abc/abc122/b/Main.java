package b;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String s = sc.next();
		
		int max = 0;
		int count = 0;
		for(char c: s.toCharArray()){
			if(c=='A' || c=='C' || c=='G' || c=='T') {
				count++;
				max = Math.max(max, count);
			}
			else count = 0;
		}
		
        out.println(max);
    }
}

