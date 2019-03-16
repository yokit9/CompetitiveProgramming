package b;

import java.util.*;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        int[] b = new int[m];
        for(int j=0; j<m; j++) b[j] = sc.nextInt();

        int[][] a = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) a[i][j] = sc.nextInt();

        int count = 0;
        for(int i=0; i<n; i++) {
            int score = c;
            for(int j=0; j<m; j++) 
                score += b[j] * a[i][j];

            if(score > 0) count++;
        }

        out.println(count);
    }
}

