class  UnionFind {
    int v;
    int parents[];
    
    UnionFind(int n) {
        this.v = n;
        parents = new int[v];
        for(int i=0;i<n;i++) {
            parents[i] = i;
        }
    }
    
    
    void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if(parentX != parentY) {
            parents[parentX] = parentY;
        }
    }
    
    int find(int x) {
        if(parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        
        return parents[x];
    }
}
