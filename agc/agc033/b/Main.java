package b;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		int y = sc.nextInt()-1;
		int x = sc.nextInt()-1;
		
		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();
		
		int lx=0, rx=0, uy=0, dy=0;
		for(int i=n-1; i>=0; i--) {
			switch(t[i]) {
				case 'L':
					if(rx > 0) rx--; break;
				case 'R':
					if(lx > 0) lx--; break;
				case 'U':
					if(dy > 0) dy--; break;
				case 'D':
					if(uy > 0) uy--; break;
			}
			switch(s[i]) {
				case 'L':
					lx++; break;
				case 'R':
					rx++; break;
				case 'U':
					uy++; break;
				case 'D':
					dy++; break;
			}
			if(lx + rx >= w || uy + dy >= h) break;
		}

		//out.println(lx + " " + rx + " " + uy + " " + dy);
		
		boolean ans = true;
		ans &= x - lx >= 0;
		ans &= x + rx < w;
		ans &= y - uy >= 0;
		ans &= y + dy < h;
        out.println(ans?"YES":"NO");
    }
}

