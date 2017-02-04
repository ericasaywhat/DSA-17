package your_code;

import ADTs.StackADT;

public class PsetProblems {

    public static int longestValidSubstring(String s) {
        MyStack hold = new MyStack();
        MyStack countHold = new MyStack();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                hold.push(1);
            } else if (s.charAt(i) == ')' &&  hold.isEmpty()){
                countHold.push(count);
                count = 0;
            } else {
                hold.pop();
                count += 2;
                if (hold.isEmpty()){
                    countHold.push(count);
                    count = 0;
                }
            }
        }

        return countHold.maxElement();
    }

    public static StackADT<Integer> sortStackLimitedMemory(StackADT<Integer> s) {
        MyStack sorted = new MyStack();
        int temp;
        while(s.peek() != null){
            if(sorted.isEmpty()) {
                sorted.push(s.pop());
            }
            if(s.peek() <= sorted.peek()) {
                sorted.push(s.pop());
            } else {
                temp = s.pop();
                while (!sorted.isEmpty() && temp > sorted.peek()) {
                    s.push(sorted.pop());
                }
                sorted.push(temp);
            }
        }
        return sorted;
    }

}
