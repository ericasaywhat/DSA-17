package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    private LinkedList<Integer> mQueue;

    public MyPriorityQueue() {
        mQueue = new LinkedList<>();
    }

    public void enqueue(int item) {
        if (mQueue.isEmpty()){
            mQueue.add(item);
        } else{
            for(int i = 0 ; i<= mQueue.size(); i++){
                if (item > mQueue.get(i) ){
                    mQueue.add(i, item);
                    return;
                }
            }
            mQueue.add(item);
        }
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        return mQueue.removeFirst();
    }

}