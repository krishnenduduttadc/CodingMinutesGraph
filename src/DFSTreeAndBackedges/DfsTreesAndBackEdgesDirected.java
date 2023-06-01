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
public class DfsTreesAndBackEdgesDirected {

    static final int N = (int) (1e5 + 1);

    static ArrayList<Integer>[] gr = new ArrayList[N];
    static int[] vis = new int[N];
    static boolean cycle = false;

    static {
        for (int i = 0; i < N; i++) {
            gr[i] = new ArrayList<>();
        }
    }
    
    static void dfs(int cur, int par) {
        vis[cur] = 1;
        for (int x : gr[cur]) {
            if (vis[x] == 0) {
                dfs(x, cur);
            }
            else if (x != par && vis[x] == 1) {
                // backedge
                System.out.println(cur+"-"+x);
                cycle = true;
            }
        }
        // visited and not in call stack
        vis[cur] = 2;
        return;
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
        gr[1].add(3);
        gr[1].add(2);           
        gr[2].add(3);
        gr[2].add(4);
        gr[4].add(5);
        gr[5].add(6);
        gr[6].add(7);
        gr[7].add(4);

        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                dfs(i, 0);
            }
        }

        if (cycle) {
            System.out.print("Yes cycle found");
        } else {
            System.out.print("Not found");
        }
    }
}
