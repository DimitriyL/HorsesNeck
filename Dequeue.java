public class Dequeue<T> implements Deque<T>{

    private DLLNode<T> _front;
    private DLLNode<T> _end;
    private int _size;
    private int _capacity;

    public Dequeue(int capacity){
        _front = null;
	_end = null;
	_size = 0;
	_capacity = capacity;
    }

    public boolean isEmpty(){
	return size() == 0;
    }

    public T poll(){
	if (isEmpty())
	    return null;

        T ret = _front.getCargo();
	_front = _front.getNext();
	_size -= 1;
	return ret;
    }

    public T pollLast(){
	if (isEmpty())
	    return null;

	T ret = _end.getCargo();
	_end = _end.getPrev();
	_size -= 1;
	return ret;
    }

    public T peek(){
	if (isEmpty())
	    return null;

	return _front.getCargo();
    }

    public T peekLast(){
	if (isEmpty())
	    return null;

	return _end.getCargo();
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

    public boolean offerFirst(T x){
	if (_size == _capacity)
	    return false;
	_queue.add(0,x);
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

    public String toString(){
	String ret = "";
	for (int x = 0; x < size(); x += 1)
	    ret += _queue.get(x) + " ";
	return ret;
    }

    public static void main(String[] args){
	Dequeue<String> test = new Dequeue<String>(5);
	System.out.println("Upon initialization: size = " + test.size());

	System.out.println("\nTesting offer()...");
	System.out.println("one: " + test.offer("one"));
        System.out.println("two: " + test.offer("two"));
	System.out.println("three: " + test.offer("three"));
	System.out.println("four: " + test.offer("four"));
	System.out.println("five: " + test.offer("five"));
	System.out.println("six: " + test.offer("six"));

	System.out.println("\nTesting toString()...");
	System.out.println(test);
	System.out.println("size = " + test.size());

	System.out.println("\nTesting contains()...");
	System.out.println(test.contains("one"));
	System.out.println(test.contains("two"));
	System.out.println(test.contains("three"));
	System.out.println(test.contains("four"));
	System.out.println(test.contains("five"));
	System.out.println(test.contains("six"));

	System.out.println("\nTesting poll()...");
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
    }
}
