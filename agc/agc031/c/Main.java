package c;

import static java.lang.System.*;
import java.util.*;

public class Main {
	public static int n, a, b, ac, bc;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();

		ac=0; bc=0;
		for(int i=a; i>0; i>>=1) if((i&1) > 0) ac++;
	    for(int i=b; i>0; i>>=1) if((i&1) > 0) bc++;
		//out.println(ac + " " + bc);
		
			
		int[] num = new int[n+1];
		Arrays.fill(num, 0);
		num[0] = 1;
		for(int i=0; i<n; i++) 
			for(int j=i; j>=0; j--) num[j+1] += num[j];
        //for(int i=0; i<=n; i++) out.print(num[i] + " ");
		//out.println();
			
		for(int i=Math.min(ac,bc); i<=Math.max(bc,ac); i++) 
			num[i]--;
		
		for(int i=0; i<n; i++) num[i+1] -= num[i];
		
		
		if(num[n] != 0) out.println("NO");
		else {
			out.println("YES");
			
			boolean[] closed = new boolean[1<<n];
			Arrays.fill(closed, false);
			closed[b] = true;
			search(b, bc, closed, 0);
			out.println(b);
		}
    }
	
	public static boolean search(int now, int nowc, boolean[] closed, int count) {
		if(count >= (1<<n)-1) return now == a;
		
		
		LinkedList<Integer> next;
		if(a<b && nowc<ac || a>b && nowc<=ac) {
			next = getMinus(now);
			next.addAll(getPlus(now));
		}
		else {
			next = getPlus(now);
			next.addAll(getMinus(now));
		}
		for(int i=0; i<count; i++) out.print(" ");
		out.print(now);
		for(int i=0; i<(1<<n)-count; i++) out.print(" ");
		out.printf("(%5s) ",Integer.toString(now, 2));
		out.print(count + ": ");
		for(int nk: next) out.print(nk + " ");
		out.println();

		
		for(int nk: next) {
			if(!closed[nk]) {				
				closed[nk] = true;
				int nextc = nowc + ((now & nk) == now ? 1 : -1);
				if(search(nk, nextc, closed, count+1)) {
					out.print(nk + " ");
					//out.printf("%5s\n", Integer.toString(nk, 2));
					return true;
				}
				closed[nk] = false;
			}
		}
		
		return false;
	}
	
	public static LinkedList<Integer> getMinus(int now) {
		LinkedList<Integer> next = new LinkedList<Integer>();
		
		int k = now & (now-1);
		while(k != now) {
			next.add(k);
			k = now & (k - (k ^ now));
		}
		return next;
	}
	
	public static LinkedList<Integer> getPlus(int now) {
		LinkedList<Integer> next = new LinkedList<Integer>();
		
		int k = (now | (now+1)) & ((1<<n)-1);
		while(k != now) {
			next.add(k);
			k = (now | (k + (k ^ now))) & ((1<<n)-1);
		}
		return next;
	}
}

