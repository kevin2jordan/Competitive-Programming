class UnionFind {
    int parents[];
    int rank[];
    int V;
    UnionFind(int v) {
        this.V = v;
        parents = new int[V];
        rank = new int[V];

        for(int i=0;i<V;i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if(parentX != parentY) {
            if(rank[parentX] < rank[parentY]) {
                parents[parentX] = parents[parentY];
                rank[parentX] += rank[parentY];
            } else {
                parents[parentY] = parents[parentX];
                rank[parentY] += rank[parentX];
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
