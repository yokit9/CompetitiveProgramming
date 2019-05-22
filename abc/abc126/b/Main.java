package b;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String s = sc.next();
		int a = Integer.parseInt(s.substring(0,2));
		int b = Integer.parseInt(s.substring(2,4));
		
		if(0 < a && a <= 12) {
			if(0 < b && b <= 12) out.println("AMBIGUOUS");
			else out.println("MMYY");
		}
		else {
			if(0 < b && b <= 12) out.println("YYMM");
			else out.println("NA");
		}
    }
}

