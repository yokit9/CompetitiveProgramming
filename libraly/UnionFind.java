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
