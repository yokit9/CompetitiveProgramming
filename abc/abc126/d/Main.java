package d;

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

class Sep implements Comparable<Sep>{
	int u, v;
	
	Sep(int _u, int _v) {
		u = _u;
		v = _v;
	}
	
	public int compareTo(Sep o) {
		if(u == o.u) return v - o.v;
		else return u - o.u;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int n = sc.nextInt();
		UnionFind uf = new UnionFind(n);

		LinkedList<Sep> sep = new LinkedList<Sep>();
		for(int i=0; i<n-1; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			int w = sc.nextInt();
			
			if(w%2 == 0) uf.unite(u, v);
			else {
				if(u > v) {
					int temp = u;
					u = v;
					v = temp;
				}
				sep.add(new Sep(u, v));
			}
		}
		Collections.sort(sep);
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(sep.size() > 0) {
			Sep s = sep.poll();
			map.put(s.u, 0);
			map.put(s.v, 1);
		}
		while(!sep.isEmpty()) {
			Sep s = sep.poll();
			int u = uf.root(s.u);
			int v = uf.root(s.v);
			if(map.containsKey(u)) 
				map.put(v, 1-map.get(u));
			else if(map.containsKey(v)) 
				map.put(u, 1-map.get(v));
			else 
				sep.add(new Sep(u, v));
		}
		
        for(int i=0; i<n; i++) {
			if(map.isEmpty()) out.println(0);
			else out.println(map.get(uf.root(i)));
		}
    }
}

