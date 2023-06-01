/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSTreeAndBackedges;

import java.util.*;

/**
 *
 * @author krish
 */
public class DfsTreesAndBackEdges {

    static final int N = (int) (1e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static boolean[] vis = new boolean[N];
    static boolean cycle = false;

    static {
        for (int i = 0; i < gr.length; i++) {
            gr[i] = new ArrayList<>();
        }
    }

    static void dfs(int cur, int par) {
        System.out.println(cur + " ");
        vis[cur] = true;
        for (int x : gr[cur]) {
            if (vis[x] == false) {
                dfs(x, cur);
            } else if (x != par) {

                System.out.println(cur + "-" + x);
                cycle = true;
            }
        }
    }

    static void dfs1(int cur) {
        System.out.print("-" + cur);
        vis[cur] = true;
        for (int nbr : gr[cur]) {
            if (vis[nbr] == false) {
                dfs1(nbr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 7, m = 8;

//        for (int i = 0; i < m; i++) {
//            int x = scn.nextInt(), y = scn.nextInt();
//            gr[x].add(y);
//            gr[y].add(x);
//
//        }
        gr[1].add(2);
        gr[2].add(1);
        gr[1].add(3);
        gr[3].add(1);
        gr[2].add(3);
        gr[3].add(2);
        gr[2].add(4);
        gr[4].add(2);
        gr[4].add(5);
        gr[5].add(4);
        gr[5].add(6);
        gr[6].add(5);
        gr[6].add(7);
        gr[7].add(6);
        gr[7].add(4);
        gr[4].add(7);

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, 0);
                //dfs1(i);
            }
        }

        if (cycle) {
            System.out.print("Yes cycle found");
        } else {
            System.out.print("Not found");
        }
    }
}
