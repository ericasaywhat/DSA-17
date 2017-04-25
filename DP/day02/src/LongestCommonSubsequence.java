public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String S, String T) {
        int [][] memo = new int [S.length()+1][T.length()+1];

        for (int k = 0; k<=S.length(); k++) {
            for (int l = 0; l<=T.length(); l++){
                if (k == 0 || l == 0) memo[k][l] = 0;
                else if(S.charAt(k-1) == T.charAt(l-1)) memo[k][l] = memo[k-1][l-1] + 1;
                else memo[k][l] = Math.max(memo[k-1][l], memo[k][l-1]);
            }
        }

        return memo[S.length()][T.length()];
    }
}
