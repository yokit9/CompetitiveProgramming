package b;

import static java.lang.System.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();

		int count = 0;
		for(int i=Math.min(a, b); i>0; i--) {
			if(a%i==0 && b%i==0) count++;
			if(count==k) {
				out.println(i);
				break;
			}
		}
	}
}

