import java.util.ArrayList;

public class Dequeue<T> implements Deque<T>{

    private ArrayList<T> _queue;
    private int _size;
    private int _capacity;

    public Dequeue(int capacity){
	_queue = new ArrayList<T>();
	_size = 0;
	_capacity = capacity;
    }

    public boolean isEmpty(){
	return _size == 0;
    }

    public T poll(){
	if (isEmpty())
	    return null;

	T ret = _queue.remove(0);
	return ret;
    }
}
