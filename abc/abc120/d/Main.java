package d;

import static java.lang.System.*;
import java.util.*;

class UnionFind {
    int[] par;
    long[] num;

    UnionFind(int n) { 
    	par = new int[n];
    	num = new long[n];
        for(int i = 0; i < n; i++) {
        	par[i] = i;
        	num[i] = 1;
        }
    }

    int root(int x) {
        if (par[x] == x) return x;
        return par[x] = root(par[x]);
    }

    void unite(int x, int y) {
        int rx = root(x); 
        int ry = root(y);
        if (rx == ry) return; 

        par[rx] = ry;
        num[ry] += num[rx];
    }

    boolean same(int x, int y) {
        int rx = root(x);
        int ry = root(y);
        return rx == ry;
    }

    long getNum(int n) {
    	return num[root(n)];
    }
};

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		UnionFind uf = new UnionFind(n);

		int[] a = new int[m];
		int[] b = new int[m];
		for(int i=0; i<m; i++) {
			a[m-i-1] = sc.nextInt()-1;
			b[m-i-1] = sc.nextInt()-1;
		}

		long[] ans = new long[m];
		ans[0] = (long)n*((long)n-1)/2;

		for(int i=0; i<m-1; i++) {
			if(uf.same(a[i], b[i])) ans[i+1] = ans[i];
			else {
				long ac = uf.getNum(a[i]);
				long bc = uf.getNum(b[i]);
				ans[i+1] = ans[i] - ac * bc;
				uf.unite(a[i], b[i]);
			}
		}

		for(int i=0; i<m; i++) {
			out.println(ans[m-i-1]); 
		}
	}
}

