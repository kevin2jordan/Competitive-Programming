class  UnionFind {
    int v;
    int parents[];
    int rank[];
    
    UnionFind(int n) {
        this.v = n;
        parents = new int[v];
        rank = new int[v];
        for(int i=0;i<n;i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }
    
    
    void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if(parentX != parentY) {
            if(rank[parentX] < rank[parentY]) {
                parents[parentX] = parentY;
                rank[parentX] += rank[parentY];
            } else {
                parents[parentY] = parentX;
                rank[parentY] += parentX;
            }
            
        }
    }
    
    int find(int x) {
        if(parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        
        return parents[x];
    }
}
