public class Dequeue implements Deque{

    private ArrayList<T> _queue;
    private int _size;
    private int _capacity;

    public Dequeue(int capacity){
	_queue = new ArrayList<T>();
	_size = 0;
	_capacity = capacity;
    }
}
