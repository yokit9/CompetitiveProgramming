package e;

import static java.lang.System.*;
import java.util.*;

class UnionFind {
    int[] par;
    int[] num;

    UnionFind(int n) { 
    	par = new int[n];
    	num = new int[n];
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

    int getNum(int n) {
    	return num[root(n)];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		int m = sc.nextInt();

		UnionFind uf = new UnionFind(n);
		for(int i = 0; i<m; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int z = sc.nextInt();
			uf.unite(x, y);
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++) set.add(uf.root(i));
		
        out.println(set.size());
    }
}

