package ds;

public class UnionFind {

    private final int[] parent;
    private final int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int n) {
        int root = n;
        while (parent[root] != root) {
            root = parent[root];
        }
        while (n != root) {
            int oldRoot = parent[n];
            parent[n] = root;
            n = oldRoot;
        }
        return root;
    }

    public boolean union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        if (root1 == root2) {
            return false;
        }
        if (size[root1] < size[root2]) {
            parent[root1] = root2;
            size[root2] += size[root1];
        } else {
            parent[root2] = root1;
            size[root1] += size[root2];
        }
        return true;
    }
}
