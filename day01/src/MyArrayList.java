public class MyArrayList {
    private Cow[] elems;
	private int size;

	public MyArrayList() {
	    size = 0;   //keeps track number of 'active' cows
	    elems = new Cow[10];
	}

	public MyArrayList(int capacity) {
	    size = 0;
        elems = new Cow[capacity];
	}

	public void add(Cow c) {
	    if (size >= elems.length) {
	        Cow[] resized = new Cow[elems.length * 2];
	        System.arraycopy(elems, 0, resized ,0, elems.length);
	        elems = resized;
        }
	    elems[size] = c;
	    size++;
	}

	public int size() {
	    return size;
	}

	public Cow get(int index){
	    if (index < 0 || index >= size){
	        throw new IndexOutOfBoundsException();
        } else {
            return elems[index];
        }
	}

	public Cow remove(int index) {
        Cow removedCow =  this.get(index);
        for(int i = index; i < size-1; i++) {
            elems[i] = elems[i + 1];
        }
        size--;
        if (size <= elems.length/4) {
            Cow[] resized = new Cow[elems.length / 2];
            System.arraycopy(elems, 0, resized ,0, elems.length);
            elems = resized;
        }
        return removedCow;
    }

	public void add(int index, Cow c) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        } else {
            add(c);     //to resize just in case
            for (int numCows = size(); numCows > index; numCows--){
                elems[numCows] = elems[numCows - 1];
            }
            elems[index] = c;
        }
	}
}
