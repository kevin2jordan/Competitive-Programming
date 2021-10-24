import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static class pair {
        int x,y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isValid(int x, int y, int[][] grid) {
        int n = grid.length;

        return x>=0 && x<n && y>=0 && y<n && grid[x][y]==1;
    }

    private static boolean isAllRotten(int[][] grid) {
        int n = grid.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
    private static int minimumTimeToRotOranges(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int n = grid.length;
        int totalMinutes = 0;

        for(int i=0;i<n;i++) {
            for (int j=0;j<n;j++){
                if(grid[i][j] == 2) {
                    q.add(new pair(i,j));
                }
            }
        }
        int[] row = {-1,1,0,0};
        int[] col = {0,0,-1,1};

        while(!q.isEmpty()) {
           int size = q.size();
           boolean foundFreshOrange = false;
           for(int i=0;i<size;i++){
               pair temp = q.poll();
               for(int k=0; k<row.length; k++) {
                   if(isValid(temp.x+row[k], temp.y+col[k], grid)){
                       q.add(new pair(temp.x+row[k], temp.y+col[k]));
                       grid[temp.x+row[k]][temp.y+col[k]] = 2;
                       foundFreshOrange = true;
                   }
               }
           }
           if(foundFreshOrange) {
               totalMinutes++;
           }
        }
        return isAllRotten(grid) ? totalMinutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0},
                { 0, 1, 1}
            };

        System.out.println(minimumTimeToRotOranges(grid));
    }
}
