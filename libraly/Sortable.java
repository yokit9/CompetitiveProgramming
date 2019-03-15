class Sortable implements Comparable<Sortable>{
    int v;
    int p;

    Sortable(int v, int p) {
        v = _v;
        p = _p;
    }

    public int compareTo(int o) {
        if(v > o.v) return 1;
        else if (v < o.v) return -1;
        else return 0;
    }
}
