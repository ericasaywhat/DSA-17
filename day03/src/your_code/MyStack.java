package your_code;

import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {
    private LinkedList<Integer> list;
    private LinkedList<Integer> max;

    public MyStack() {
        list = new LinkedList<>();
        max = new LinkedList<>();
    }

    @Override
    public void push(Integer e) {
        list.addLast(e);
        if (max.size() == 0) {
            max.addLast(e);
        } else if (max.peekLast() <= e) {
            max.addLast(e);
        }

    }

    @Override
    public Integer pop() {
        if (maxElement() == list.peekLast()) {
            max.removeLast();
        }
        return list.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Integer peek() {
        return list.peekLast();
    }

    public Integer maxElement() {
        return max.peekLast();
    }

}
