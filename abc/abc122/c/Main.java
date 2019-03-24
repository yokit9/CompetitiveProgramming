package c;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		int q = sc.nextInt();
		
		String s = sc.next();
		int[] count = new int[n];
		Arrays.fill(count, 0);
		for(int i=1; i<n; i++) {
			if(s.charAt(i-1) == 'A' && s.charAt(i) == 'C') count[i] = count[i-1] + 1;
			else count[i] = count[i-1];
		}
		
		for(int i=0; i<q; i++) {
			int l = sc.nextInt()-1;
			int r = sc.nextInt()-1;
			
			out.println(count[r]-count[l]);
		}
	}
}

