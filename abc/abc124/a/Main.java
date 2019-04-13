package a;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        
        out.println(Math.max(Math.max(a+a-1, a+b),b+b-1));
    }
}

