package d;

import java.util.*;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(in);

        long n = sc.nextLong();
        long m = sc.nextLong()+1L;

        String mstr = Long.toBinaryString(m);
        int num = mstr.length();

        long base = 2;
        String ans = "";
        for(int i=num-1; i>=0; i--) {
            long count = 0;

            long mquo = m / base;
            count += mquo * base / 2;
            long mmod = m % base;
            if(mmod > base/2) count += mmod - base/2;

            long nquo = n / base;
            count -= nquo * base / 2;
            long nmod = n % base;
            if(nmod > base/2) count -= nmod - base/2;

            if(count % 2 == 0) ans = "0" + ans;
            else ans = "1" + ans;

            base *= 2;
        }

        out.println(Long.parseLong(ans, 2));
    }
}

