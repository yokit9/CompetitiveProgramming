package a;

import static java.lang.System.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        char c = sc.next().toCharArray()[0];

		if(c=='A') out.println('T');
		if(c=='T') out.println('A');
		if(c=='C') out.println('G');
		if(c=='G') out.println('C');
    }
}

