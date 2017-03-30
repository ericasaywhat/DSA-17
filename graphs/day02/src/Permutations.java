import java.util.*;

public class Permutations {

    private static void backtrack(List<Integer> sublist, List<Integer> possible, List<List<Integer>> answers){
        if (possible.isEmpty()) {
            if(!answers.contains(sublist)) answers.add(new ArrayList<>(sublist));
            return;
        }

        for(int i = 0; i<possible.size(); i++){
//  //      for(int i : possible){
//        Iterator<Integer> iter = possible.iterator();
//        while(iter.hasNext()){
//            int i = iter.next();
            int num = possible.get(i);
            sublist.add(num);
            possible.remove(i);
            backtrack(sublist, possible, answers);
            sublist.remove(sublist.indexOf(num));
            possible.add(i, num);
//            iter = possible.iterator();

        }
        return;

    }


    private static void backtrackQueens(List<Integer> A, List<Integer> sublist, List<Integer> possible, List<List<Integer>> answers, List<Integer> nonoleft, List<Integer> nonoright) {
        if (possible.isEmpty()) {
            if (!answers.contains(sublist)) answers.add(new ArrayList<>(sublist));
            return;
        }
        for (int i = 0; i < possible.size(); i++) {
            int num = possible.get(i);
            if((!nonoleft.contains(num) && !nonoright.contains (num))){
                sublist.add(num);
                possible.remove(i);
                for(int x = 0; x<nonoleft.size();x++){
                    int j = nonoleft.get(x);
                    nonoleft.remove(x);
                    nonoleft.add(x,j-1);
                }
                nonoleft.add(num-1);
                for(int y = 0; y<nonoright.size(); y++){
                    int k = nonoright.get(y);
                    nonoright.remove(y);
                    nonoright.add(y,k+1);
                }
                nonoright.add(num+1);
                backtrackQueens(A, sublist, possible, answers, nonoleft,nonoright);
                sublist.remove(sublist.indexOf(num));
                possible.add(i, num);

                if (nonoleft.contains(num-1)) nonoleft.remove(nonoleft.size()-1);
                for(int x = 0; x<nonoleft.size();x++){
                    int j = nonoleft.get(x);
                    nonoleft.remove(x);
                    nonoleft.add(x,j+1);
                }
                if (nonoright.contains(num+1)) nonoright.remove(nonoright.size()-1);
                for(int y = 0; y<nonoright.size(); y++){
                    int k = nonoright.get(y);
                    nonoright.remove(y);
                    nonoright.add(y,k-1);
                }
            }
        }
        return;
    }

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> answers = new LinkedList<>();
        backtrack(new ArrayList<>(), new ArrayList<>(A), answers);

        return answers;
    }


    public static List<List<Integer>> permutationsQueens(List<Integer> A) {
        List<List<Integer>> answers = new LinkedList<>();
        backtrackQueens(A,new ArrayList<>(), new ArrayList<>(A), answers, new ArrayList<>(), new ArrayList<>());

        return answers;
    }

}
