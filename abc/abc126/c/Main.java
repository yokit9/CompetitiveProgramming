package c;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] mul = new int[20];
		double[] prob = new double[20];
		mul[0] = 1; prob[0] = 1;
		for(int i=1; i<20; i++) {
			mul[i] = mul[i-1] * 2;
			prob[i] = prob[i-1] / 2;
		}
		
		double ans = 0.0;
		for(int i=1; i<=n; i++) 
			for(int j=0; j<20; j++) 
				if(i * mul[j] >= k) {
					ans += prob[j];
					//if(i < 10) out.println(i + " " + j + " " + mul[j] + " " + prob[j]);
					break;
				}
			
		out.println(ans/n);
    }
}

