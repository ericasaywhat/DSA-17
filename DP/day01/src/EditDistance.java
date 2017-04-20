public class EditDistance {

    private static int min (int a, int b, int c){
        return Math.min(Math.min(a,b), Math.min(b,c));
    }

    public static int minEditDist(String a, String b) {
        int[][] memo = new int[a.length()+1][b.length()+1];

        for (int i = 0; i <a.length()+1; i++) {
            for (int j = 0; j <b.length()+1 ; j++) {
                memo[i][j] = -1;
                if(i==0) memo[i][j] = j;
                if(j==0) memo[i][j] = i;
            }
        }

        for (int i = 1; i < a.length()+1 ; i++) {
            for (int j = 1; j < b.length()+1; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) memo[i][j] = 0;
                if(memo[i][j] == -1)  memo[i][j] = min(memo[i-1][j-1], memo[i][j-1], memo[i-1][j]) +1;
                if(memo[i][j] == 0) memo[i][j] = memo[i-1][j-1];
            }
        }
        return memo[a.length()][b.length()];
    }

}
