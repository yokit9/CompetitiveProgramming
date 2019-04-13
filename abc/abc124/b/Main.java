package b;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		int max = 0;
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int h = sc.nextInt();
			if(h >= max) {
				ans++;
				max = h;
			}
		}

        out.println(ans);
    }
}

