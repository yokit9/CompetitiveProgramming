package a;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
        ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i=0; i<n; i++) b.add(sc.nextInt());
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while(b.size() > 0) {
			for(int i=b.size()-1; i>=0; i--) {
				if(b.get(i) > i+1) {
					ans.clear();
					ans.add(-1);
					break;
				}
				else if(b.get(i) == i+1) {
					ans.add(b.get(i));
					b.remove(i);
					break;
				}
			}
			
			if(ans.get(0) < 0) break;
		}
		
		for(int i=ans.size()-1; i>=0; i--)
	        out.println(ans.get(i));
    }
}

