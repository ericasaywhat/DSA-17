import java.util.LinkedList;
import java.util.*;

public class Problems {

    public static Map<Integer, Integer> getCountMap(int[] arr) {
        MyLinearMap<Integer,Integer> countMap = new MyLinearMap<>();
        for(int num : arr){
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        return countMap;
    }


    public static List<Integer> removeKDigits(int[] num, int k) {
        LinkedList<Integer> small = new LinkedList<>();
        for (int i: num){
            while (!small.isEmpty() && i <= small.getLast() && k>0){
                small.removeLast();
                k--;
            }
            if (small.size() < num.length-k){
                small.addLast(i);
            }
        }
        return small;
    }


    private static int getNum (Node<Integer> h){
        int num = 0;
        while(h.next != null){
            num= num*10 + h.data;
            h = h.next;
        }
        num = num*10+h.data;
        return num;
    }

    public static int sumLists(Node<Integer> h1, Node<Integer> h2) {
        return getNum(h1) + getNum(h2);
    }






}
