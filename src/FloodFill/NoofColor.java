/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloodFill;

/**
 *
 * @author krish
 */
public class NoofColor {

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

    public static void main(String[] args) {

        int color = 3;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    //color++;
                    dfs(i, j, color);
                    color++;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

    }

    private static void dfs(int i, int j, int color) {
        arr[i][j] = color;
        for (int k = 0; k < 4; k++) {

            int ii = i + dx[k];
            int jj = j + dy[k];
            if (ii >= 0 && ii < arr.length && jj >= 0 && jj < arr[0].length && arr[ii][jj] == 1) {
                dfs(ii, jj, color);
            }

        }
    }
}
