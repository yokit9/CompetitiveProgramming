package c;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n; i++) list.add(new ArrayList<Integer>());
	
		for(int i=0; i<n; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			list.get(a).add(b);
			list.get(b).add(a);
		}

		
		
        out.println();
    }
}

