package a;

import java.util.*;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int h = sc.nextInt();
        int w = sc.nextInt();

        out.println(n*m-h*m-w*n+h*w);
    }
}

