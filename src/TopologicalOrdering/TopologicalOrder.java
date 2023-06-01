/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologicalOrdering;

import java.util.*;

/**
 *
 * @author krish
 */
public class TopologicalOrder {

    static final int N = (int) (1e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static ArrayList<Integer> order;

    static {
        for (int i = 0; i < N; i++) {
            gr[i] = new ArrayList<>();
        }
    }
    static boolean[] vis = new boolean[N];

    static void dfs(int cur, int par) {
        vis[cur] = true;
        for (int x : gr[cur]) {
            if (!vis[x]) {
                dfs(x, cur);
            }
        }
        // I am here because I came back from the subtree
        order.add(cur);
        return;
    }

    static void addEdge(int x, int y) {
        gr[x].add(y);

    }

    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(3, 4);
        addEdge(4, 5);
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, 0);
            }
        }

        Collections.reverse(order);

        for (int x : order) {
            System.out.println(x);
        }
    }
}
