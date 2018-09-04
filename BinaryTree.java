import java.util.ArrayList;
import java.util.Random;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
};

public class BinaryTree {
    private static int n;
    private static int tick = 0;

    public Pair g[];
    public int inorder[], preorder[], postorder[], d[];

    private void genTree() {
        ArrayList<Pair> free_edges = new ArrayList<>();
        Random rand = new Random();

        free_edges.add(new Pair(0, 0));
        free_edges.add(new Pair(0, 1));
        for (int i = 1; i < n; i++) {
            int idx = rand.nextInt(free_edges.size());
            int par = free_edges.get(idx).first, side = free_edges.get(idx).second;
            free_edges.remove(idx);
            free_edges.add(new Pair(i, 0));
            free_edges.add(new Pair(i, 1));
            if (side == 0) g[par].first = i;
            else g[par].second = i;
//            System.out.println(i + " " + par + " " + side);
        }
    }
    private void dfs_inorder(int u) {
        if(g[u].first != -1) dfs_inorder(g[u].first);
        inorder[tick++] = u;
        if(g[u].second != -1) dfs_inorder(g[u].second);
    }
    private void dfs_preorder(int u) {
        preorder[tick++] = u;
        if(g[u].first != -1) dfs_preorder(g[u].first);
        if(g[u].second != -1) dfs_preorder(g[u].second);
    }
    private void dfs_postorder(int u) {
        if(g[u].first != -1) dfs_postorder(g[u].first);
        if(g[u].second != -1) dfs_postorder(g[u].second);
        postorder[tick++] = u;
    }
    private void dfs_depth(int u) {
        if(g[u].first != -1) {
            d[g[u].first] = d[u] + 1;
            dfs_depth(g[u].first);
        }
        if(g[u].second != -1) {
            d[g[u].second] = d[u] + 1;
            dfs_depth(g[u].second);
        }
    }
    private void debug() {
        for (int i = 0; i < n; i++) System.out.printf("%d ", inorder[i]);
        System.out.println();
        for (int i = 0; i < n; i++) System.out.printf("%d ", preorder[i]);
        System.out.println();
        for (int i = 0; i < n; i++) System.out.printf("%d ", postorder[i]);
        System.out.println();
    }
    public BinaryTree(int n) {
        this.n = n;
        g = new Pair[n];
        inorder = new int[n];
        preorder = new int[n];
        postorder = new int[n];
        d = new int[n];
        for (int i = 0; i < n; i++) g[i] = new Pair(-1, -1);
        genTree();
        dfs_depth(0);
        tick = 0;
        dfs_inorder(0);
        tick = 0;
        dfs_preorder(0);
        tick = 0;
        dfs_postorder(0);
        //debug();
    }
}