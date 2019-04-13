package c;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        char[] s = sc.next().toCharArray();	
		
		int bc = 0, wc = 0;
		for(int i=0; i<s.length; i++) {
			if(i%2==0&&s[i]=='1' || i%2==1&&s[i]=='0') bc++;
			if(i%2==0&&s[i]=='0' || i%2==1&&s[i]=='1') wc++;
		}

        out.println(Math.min(bc, wc));
    }
}

