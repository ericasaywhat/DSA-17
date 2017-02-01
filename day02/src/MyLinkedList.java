public class MyLinkedList<T> {

	private Node head;
	private Node tail;
	private int size;	//keeps track of number of elements

	private class Node {
		T val;
		Node prev;
		Node next;

		private Node(T d, Node prev, Node next) {
			this.val = d;
			this.prev = prev;
			this.next = next;
		}
	}

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(T e) {
		addLast(e);
	}

	public T pop() {
		return removeLast();
	}

	public void addLast(T e) {
		if (isEmpty()){
		    head = new Node(e, null, null);
		    tail = head;
        } else {
		    Node temp = new Node(e, tail, null);
		    tail.next = temp;
		    tail = temp;
        }
        size ++;
	}

	public void addFirst(T e) {
	    if (isEmpty()){
	        head = new Node(e, null, null);
	        tail = head;

        } else {
            Node temp = new Node(e, null, head);
            head.prev = temp;
            head = temp;
        }
        size ++;
	}

	public Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node pointer = head;
        for (int i = 0; i < index; i++){
            pointer = pointer.next;
        }
	    return pointer;
    }

	public T get(int index) {
		return getNode(index).val;
	}

	public T remove(int index) {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
	        return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
	        Node problem = getNode(index);
	        problem.prev.next = problem.next;
	        problem.next.prev = problem.prev;
	        size--;
            return problem.val;
        }
	}

	public T removeFirst() {
	    if (isEmpty()) {
	        throw new IndexOutOfBoundsException();
        }
        T problem = head.val;
        if (size != 1){
            head = head.next;
            head.prev = null;
        } else {
            head= null;
            tail = null;
        }

	    size --;
		return problem;
	}

	public T removeLast() {
	    if (isEmpty()) {
	        throw new IndexOutOfBoundsException();
        }
	    T problem = tail.val;
	    if (size != 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
	        head = null;
	        tail = null;
        }
        size--;
		return problem;
	}
}