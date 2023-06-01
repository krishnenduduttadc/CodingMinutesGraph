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
public class NoofDistinctIsland {
        static int[][] arr = {
        {0, 0, 1, 1},
        {0, 0, 1, 1},
        {1, 0, 0, 0},
        {1, 1, 0, 0}};
//    static int[][] arr = {
//        {0, 0, 1, 1, 1, 1, 1, 1},
//        {0, 0, 1, 1, 1, 1, 1, 1},
//        {0, 0, 0, 0, 0, 0, 0, 0},
//        {1, 1, 0, 0, 0, 0, 1, 0},
//        {1, 0, 1, 1, 0, 1, 1, 0},
//        {1, 0, 1, 0, 0, 1, 1, 0},
//        {1, 0, 0, 1, 1, 1, 1, 0},
//        {1, 1, 0, 1, 1, 1, 1, 0}
//    };

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static StringBuilder psf = new StringBuilder();

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    c++;
                    psf = new StringBuilder();
                    psf.append("x");
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

    private static void dfs(int row, int col) {
        arr[row][col] = 0;

        
       
        if (row - 1 >= 0 && arr[row - 1][col] == 1) {
            psf.append("u");
            dfs( row - 1, col);
        }
        if (col + 1 < arr[0].length && arr[row][col + 1] == 1) {
            psf.append("r");
            dfs( row, col + 1);
        }
        if (row + 1 < arr.length && arr[row + 1][col] == 1) {
            psf.append("d");
            dfs(row + 1, col);
        }
        if (col - 1 >= 0 && arr[row][col - 1] == 1) {
            psf.append("l");
            dfs(row, col - 1);
        }
        
        psf.append("z");
        
    }
}
