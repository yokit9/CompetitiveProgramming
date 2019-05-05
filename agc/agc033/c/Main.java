package c;

import static java.lang.System.*;
import java.util.*;

class Cost {
	int x, c;
	
	Cost(int _x, int _c) {
		x = _x;
		c = _c;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n; i++) list.add(new ArrayList<Integer>());
	
		for(int i=0; i<n-1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			list.get(a).add(b);
			list.get(b).add(a);
		}

		boolean[] closed = new boolean[n];
		Arrays.fill(closed, false);
		LinkedList<Cost> open = new LinkedList<Cost>();
		open.add(new Cost(0, 0));
		closed[0] = true;
		int max = 0;
		while(!open.isEmpty()) {
			Cost now = open.poll();
			max = now.x;
			
			for(int nx: list.get(now.x)) {
				if(closed[nx]) continue;
				open.add(new Cost(nx, now.c + 1));
				closed[nx] = true;
			}
		}
		//out.println(max+1);
		
		Arrays.fill(closed, false);
		open.add(new Cost(max, 0));
		closed[max] = true;
		int ans = 0;
		while(!open.isEmpty()) {
			Cost now = open.poll();
			ans = Math.max(ans, now.c);
			//out.println(now.x+1 + " " + now.c);

			for(int nx: list.get(now.x)) {
				if(closed[nx]) continue;
				open.add(new Cost(nx, now.c + 1));
				closed[nx] = true;
			}
		}
		
		//out.println(ans);
        out.println(ans%3==1?"Second":"First");
    }
}

