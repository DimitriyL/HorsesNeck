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
	return size() == 0;
    }

    public T poll(){
	if (isEmpty())
	    return null;

	T ret = _queue.remove(0);
	_size -= 1;
	return ret;
    }

    public T peek(){
	if (isEmpty())
	    return null;

	return _queue.get(0);
    }

    public int size(){
	return _size;
    }

    public boolean offer(T x){
	if (_size == _capacity)
	    return false;
	_queue.add(x);
	_size += 1;
	return true;
    }

    public boolean contains(Object x){
	for (T o:_queue){
	    if (o.equals(x))
		return true;
	}
	return false;
    }
}
