package c;

import java.util.*;
import static java.lang.System.*;

class Drink implements Comparable<Drink>{
    long p;
    long n;

    Drink(long _p, long _n) {
        p = _p;
        n = _n;
    }

    public int compareTo(Drink o) {
        if(p > o.p) return 1;
        else if (p < o.p) return -1;
        else return 0;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
        long m = sc.nextLong();

        Drink[] d = new Drink[n];
        for(int i=0; i<n; i++) 
            d[i] = new Drink(sc.nextLong(), sc.nextLong());

        Arrays.sort(d);

        long price = 0;
        long num = 0;
        for(int i=0; i<n; i++) {
            if(num >= m) break;
            else if(num + d[i].n >= m) {
                price += (m - num) * d[i].p;
                break;
            }
            else {
                price += d[i].n * d[i].p;
                num += d[i].n;
            }
        }

        out.println(price);
    }
}

