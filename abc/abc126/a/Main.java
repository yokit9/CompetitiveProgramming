package a;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
		
        out.println(s.substring(0,k-1) + (char)(s.charAt(k-1)-'A'+'a') + s.substring(k));
    }
}

