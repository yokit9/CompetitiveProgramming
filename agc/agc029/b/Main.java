package b;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

		HashSet<Long> two = new HashSet<Long>();
		for(long i=0; i*i<=2000000000; i++) two.add(i*i);
		
        int n = sc.nextInt();
		long[] num = new long[n];
		for(int i=0; i<n; i++) num[i] = sc.nextLong();
		
		// 2 2 7 14
		// 1 4 9 16 25 36 49 64 81 100
		//  3 5 7  9  11 13 15 17 19
		
		
        out.println();
    }
}

