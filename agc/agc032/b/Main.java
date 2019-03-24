package b;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		
		if(n%2 == 0){
			out.println((n-2)*(n/2));
			for(int i=1; i<n; i++) {
				for(int j=i+1; j<=n; j++) {
					if(i+j == n+1) continue;
					out.println(i + " " + j);
				}
			}
		}
		else{
			out.println((n-2)*(n/2)+(n-1)/2);
			for(int i=1; i<n; i++) {
				for(int j=i+1; j<=n; j++) {
					if(i+j == n) continue;
					out.println(i + " " + j);
				}
			}		
		}
	}
}

