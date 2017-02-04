package your_code;

import ADTs.QueueADT;

import java.util.LinkedList;

/**
 * An implementation of the Queue interface.
 */
public class MyQueue implements QueueADT<Integer> {

    private LinkedList<Integer> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(Integer item) {
        queue.addLast(item);
    }

    @Override
    public Integer dequeue() {
        return queue.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Integer front() {
        return queue.peek();
    }
}