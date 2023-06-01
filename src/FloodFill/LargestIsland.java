/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloodFill;

import java.util.HashSet;

/**
 *
 * @author krish
 */
public class LargestIsland {

//    static int[][] arr = {
//        {0, 0, 1, 1},
//        {0, 0, 1, 1},
//        {1, 0, 0, 0},
//        {1, 1, 0, 0}};
    static int[][] arr = {
        {0, 0, 1, 1, 1, 1, 1, 1},
        {0, 0, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 0, 0, 0, 0, 1, 0},
        {1, 0, 1, 1, 0, 1, 1, 0},
        {1, 0, 1, 0, 0, 1, 1, 0},
        {1, 0, 0, 1, 1, 1, 1, 0},
        {1, 1, 0, 1, 1, 1, 1, 0}
    };

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static StringBuilder psf = new StringBuilder();

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    c++;
                    psf = new StringBuilder();
                    psf.append("X");
                    dfs(i, j);
                    set.add(psf.toString());
                }
            }
        }
        int largest=0;
        for (String s : set) {
            if(s.length()>largest){
                largest=s.length();
            }
            System.out.println(" " + s);
        }
        System.out.println(" " + largest);
    }

    private static void dfs(int i, int j) {
        arr[i][j] = 0;
        for (int k = 0; k < 4; k++) {

            int ii = i + dx[k];
            int jj = j + dy[k];
            if (ii >= 0 && ii < arr.length && jj >= 0 && jj < arr[0].length && arr[ii][jj] == 1) {
                psf.append("C");
                dfs(ii, jj);
            }

        }
    }

}
