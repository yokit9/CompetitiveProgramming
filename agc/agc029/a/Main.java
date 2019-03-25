package a;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String s = sc.next();
		
		long ans = 0;
		long bc = 0;
		for(char c: s.toCharArray()) {
			if(c == 'B') bc++;
			else ans += bc;
		}
        
        out.println(ans);
    }
}

