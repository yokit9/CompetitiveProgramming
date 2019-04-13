package d;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		int k = sc.nextInt();
		char[] s = sc.next().toCharArray();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		char prev = '1';
		list.add(0);
		for(int i=0; i<n; i++) {
			if(s[i] == prev) {
				list.set(list.size()-1, list.get(list.size()-1)+1);
			}
			else {
				prev = s[i];
				list.add(1);
			}
		}
		for(int i=0; i<k*2; i++) list.add(0);		
			
		int ans = 0;
		int sum = 0;
		for(int i=0; i<k*2; i++) 
			sum += list.get(i);
		
		for(int i=k*2; i<list.size(); i++) {
			sum += list.get(i);			
			if(i%2==0) ans = Math.max(ans, sum);
			sum -= list.get(i-k*2);		
		}
		
        out.println(ans);
    }
}

