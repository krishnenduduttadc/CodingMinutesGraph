/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StronglyConnectedComp;

import java.util.*;

/**
 *
 * @author krish
 */
public class KosarajuAlgorithm {

    static final int N = (int) (1e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N], grr = new ArrayList[N], components = new ArrayList[N];

    static {
        for (int i = 0; i < N; i++) {
            gr[i] = new ArrayList<>();
            grr[i] = new ArrayList<>();
            components[i] = new ArrayList<>();
        }
    }
    static boolean[] vis = new boolean[N];
    static int[] col = new int[N];
    static ArrayList<Integer> order = new ArrayList<>();

    // topological sorting
    static void dfs1(int cur) {
        vis[cur] = true;
        for (int x : gr[cur]) {
            if (!vis[x]) {
                dfs1(x);
            }
        }
        order.add(cur);
    }

    static void dfs2(int cur, int comp) {
        vis[cur] = true;
        col[cur] = comp;
        components[comp].add(cur);
        for (int x : grr[cur]) {
            if (!vis[x]) {
                dfs2(x, comp);
            }
        }
    }

    static void addedge(int x, int y) {
        gr[x].add(y);
        grr[y].add(x);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = 4, m = 5;

//        for (int i = 0; i < m; i++) {
//            int x = scn.nextInt(), y = scn.nextInt();
//            gr[x].add(y);
//            grr[y].add(x);
//        }

        addedge(1,2);
        addedge(2,3);
        addedge(3,1);
        addedge(3,4);
        addedge(4,3);

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs1(i);
            }
        }

        Collections.reverse(order);
        Arrays.fill(vis, false);

        int comp = 1;
        for (int x : order) {
            if (!vis[x]) {
                dfs2(x, comp++);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + col[i]);

        }

        System.out.println("Total strongly components are -> " + (comp - 1));
        // complexity O(n+m)

    }
}
