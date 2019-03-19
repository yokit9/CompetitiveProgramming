package b;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

		int l = sc.nextInt();
        int n = sc.nextInt();
		
		int[] x = new int[n];
		for(int i=0; i<n; i++) x[i] = sc.nextInt();
		
		//ゴールを決めた時、全部最後にジグザグしたの方が経路が長くなる
		long ans = Math.max(x[n-1], l-x[0]); //ジグザグなし
		
		long now = x[n-1]; //最初に正方向に移動
		for(int i=2; i<=n; i++) {
			now += l;
			now -= (x[n-i/2] - x[n-i]) * 2;
			if(i%2==1) now += (x[n-i/2]-x[n-i/2-1]);
			
			ans = Math.max(ans, now);
		}

		now = l - x[0]; //最初に負方向に移動
		for(int i=0; i<n-1; i++) {
			now += l;
			now -= (x[i+1] - x[i/2]) * 2;
			if(i%2==1) now += (x[i/2+1]-x[i/2]);
			
			ans = Math.max(ans, now);
		}
		
        out.println(ans);
    }
}

