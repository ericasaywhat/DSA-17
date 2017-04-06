import java.util.HashSet;
import java.util.Set;

/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    private int n;
    public int[][] tiles;
    private int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

    /*
     * Set the global board size and tile state
     */
    public Board(int[][] b) {
        n = b.length;
        tiles = b;


    }

    /*
     * Size of the board (equal to 3 for 8 puzzle, but in theory the Board
     * class should  work for any puzzle size)
     */
    private int size() {
        return n;
    }

    /*
     * Sum of the manhattan distances between the tiles and the goal
     * Estimated cost from the current node to the goal for A* (h(n))
     */
    public int manhattan() {
        int row, col, num;
        int sum = 0;
		for(int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++) {
                num = tiles[i][j];
                if (num!=0) {
                    row = (num-1)/n;
                    col = (num-1)%n;
                    sum += Math.abs(row-i)+Math.abs(col-j);
                }
            }
        }
        return sum;
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        return (manhattan()==0);
    }

    /*
     * Returns true if the board is solvable
     */
    private int inversions(int[][] tiles){
        int sum = 0;
        int boardLength = (int)Math.pow((double)n, (double)2);
        for (int i = 0; i < boardLength-1  ; i++) {
            int ival = tiles[i/n][i%n];
            if (ival!=0) {
                for (int j = i + 1; j < boardLength; j++) {
                    int jval = tiles[j / n][j % n];
                    if (ival > jval && jval != 0) sum++;
                }
            }
        }
        return sum;
    }


    public boolean solvable() {
        return (inversions(tiles)%2==0);
    }

    /*
     * Return the neighboring boards in the state tree
     * One possible method: Create a duplicate board state, try moving the
     * blank space up, down, left, and right, and if the resulting board state
     * is valid, add it to an accumulator.
     */

    private static int[][] copyOf(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    private Iterable<Board> swap(Set<Board> accumulator, int[][] boardState, int blankRow, int blankCol){

            if(blankRow-1>=0) {
                int[][] newBoard = copyOf(boardState);
                int temp = newBoard[blankRow - 1][blankCol];
                newBoard[blankRow][blankCol] = temp;
                newBoard[blankRow - 1][blankCol] = 0;
                accumulator.add(new Board(newBoard));
            }
            if(blankRow+1<n) {
                int[][] newBoard = copyOf(boardState);
                int temp = newBoard[blankRow+1][blankCol];
                newBoard[blankRow][blankCol] = temp;
                newBoard[blankRow+1][blankCol] = 0;
                accumulator.add(new Board(newBoard));
            }
            if(blankCol-1>=0) {
                int[][] newBoard = copyOf(boardState);
                int temp = newBoard[blankRow][blankCol-1];
                newBoard[blankRow][blankCol] = temp;
                newBoard[blankRow][blankCol-1] = 0;
                accumulator.add(new Board(newBoard));
            }
            if(blankCol+1<n) {
                int[][] newBoard = copyOf(boardState);
                int temp = newBoard[blankRow][blankCol + 1];
                newBoard[blankRow][blankCol] = temp;
                newBoard[blankRow][blankCol + 1] = 0;
                accumulator.add(new Board(newBoard));
            }
        return accumulator;
    }

    public Iterable<Board> neighbors() {

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(tiles[i][j] == 0) return swap(new HashSet<>(), tiles, i, j);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "";
        for (int[] tile : tiles) {
            for (int aTile : tile) s+= aTile + " ";
            s += "\n";
        }
        return s;
    }

    /*
     * Prints out the board state nicely for debugging purposes
     */
    public void printBoard() {
        for (int[] tile : tiles) {
            for (int aTile : tile) System.out.print(aTile + " ");
            System.out.println();
        }
        System.out.println();
    }

    /*
     * Check if this board equals a given board state
     */
    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
//        int[][] initState = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        int[][] initState = {{8, 6, 7}, {3, 4, 2}, {0, 1, 5}};
        Board board = new Board(initState);


        board.printBoard();
        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
        for (Board b : it)
            b.printBoard();


    }


}
