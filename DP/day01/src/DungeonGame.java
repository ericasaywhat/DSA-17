public class DungeonGame {

    public static int minInitialHealth(int[][] map) {
        if(map.length == 0 || map[0].length == 0) return -1;
        int[][] memo = new int[map.length+1][map[0].length+1];

        minHealthHelper(map, memo, map.length-1, map[0].length-1);
        return memo[0][0] + 1;
    }

    private static void minHealthHelper(int[][] map, int[][] memo, int row, int column){

        for (int i = 0; i < map.length +1 ; i++) memo[i][map[0].length] = Integer.MAX_VALUE;
        for (int i = 0; i < map[0].length ; i++) memo[map.length][i] = Integer.MAX_VALUE;

        memo[map.length][map[0].length-1] = 0;
        memo[map.length-1][map[0].length] = 0;

        for (int i = row; i >= 0; i--) {
            for (int j = column; j >= 0; j--) memo[i][j] = Math.max(Math.min(memo[i+1][j], memo[i][j+1]) - map[i][j], 0);
        }
    }
}
