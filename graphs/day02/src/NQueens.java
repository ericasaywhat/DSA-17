import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }


    public static List<char[][]> nQueensSolutions(int n) {
        Permutations perm = new Permutations();
        ArrayList<Integer> al = new ArrayList<>();
        char[][] board = new char[n][n];
        List<char[][]> allBoards = new LinkedList<>();

        for(int i = 1; i<=n;i++){
            al.add(i);
        }

        for(List<Integer> config : perm.permutationsQueens(al)){
            for(int row = 0; row < n; row++){
                Arrays.fill(board[row], '.');
                board[row][config.get(row)-1] = 'Q';
            }
            allBoards.add(copyOf(board));


        }
        return allBoards;
    }
    
}
