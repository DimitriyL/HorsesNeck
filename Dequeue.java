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
	if (isEmpty()){
	    _front = _end = new DLLNode<T>(x,null,null);
	    _size += 1;
	    return true;
	}
	DLLNode<T> newNode = new DLLNode<T> (x, _end, null);
	_end.setNext(newNode);
	_end = newNode;
	_size += 1;
	return true;
    }

    public boolean offerFirst(T x){
	if (_size == _capacity)
	    return false;
	if (isEmpty()){
	    _front = _end = new DLLNode<T>(x,null,null);
	    _size += 1;
	    return true;
	}
	DLLNode<T> newNode = new DLLNode<T> (x, null, _front);
	_front.setPrev(newNode);
	_front = newNode;
	_size += 1;
	return true;
    }

    public boolean contains(Object x){
	DLLNode<T> temp = _front;
	while (temp != null){
	    if (temp.getCargo().equals(x))
		return true;
	    temp = temp.getNext();
	}
	return false;
    }

    public String toString(){
	String ret = "";
	DLLNode<T> temp = _front;
        while (temp != null){
	    ret += temp.getCargo() + " ";
	    temp = temp.getNext();
	}
	return ret;
    }

    public static void main(String[] args){

	//tests offer() and poll()
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

	//tests offerFirst() and pollLast()
	Dequeue<String> test2 = new Dequeue<String>(5);
	System.out.println("Upon initialization: size = " + test2.size());

	System.out.println("\nTesting offerFirst()...");
	System.out.println("one: " + test2.offerFirst("one"));
        System.out.println("two: " + test2.offerFirst("two"));
	System.out.println("three: " + test2.offerFirst("three"));
	System.out.println("four: " + test2.offerFirst("four"));
	System.out.println("five: " + test2.offerFirst("five"));
	System.out.println("six: " + test2.offerFirst("six"));

	System.out.println("\nTesting toString()...");
	System.out.println(test2);
	System.out.println("size = " + test2.size());

	System.out.println("\nTesting contains()...");
	System.out.println(test2.contains("one"));
	System.out.println(test2.contains("two"));
	System.out.println(test2.contains("three"));
	System.out.println(test2.contains("four"));
	System.out.println(test2.contains("five"));
	System.out.println(test2.contains("six"));

	System.out.println("\nTesting pollLast()...");
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
    }
}
