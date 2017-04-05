//Team HorsesNeck {Dimitriy Leksanov, Michael Ruvinshteyn, Manahal Tabassum}
//APCS2 pd 1
//Lab 02 -- All Hands on Deque!
//2017 - 4 - 2

import java.util.Iterator;
import java.util.NoSuchElementException;

//Dequeue is the implementation of Deque
public class DLDeque<T> implements Deque<T>{

    //_front and _end are "tracking" nodes, connecting to the first and last
    //nodes of the list
    private DLLNode<T> _front;
    private DLLNode<T> _end;
    //the amount of elements currently in the list
    private int _size;
    //the amount of elements that can be in the list
    //since it is not an ArrayList, the capacity cannot expand on its own
    private int _capacity;

    /*
      public DLDeque()
      default constructor for class Dequeue<T>
      preconds: attributes are not initialized
      postconds: _front and _end set to null; _size set to 0
                 _capacity set to 10 to indicate an empty Dequeue, with nice
		 values
     */
    public DLDeque(){
	_front = null;
	_end = null;
	_size = 0;
	//default capacity value
	_capacity = 10;
    }

    /*
      public DLDeque(int capacity)
      overloaded constructor for class Dequeue<T>
      preconds: attributes _front, _end, _size, _capacity not set
      postconds: _front and _end set to null automatically; _size to 0
                 _capacity is set as indicated by the capacity attribute
		 indicates an empty Dequeue
     */
    public DLDeque(int capacity){
        _front = null;
	_end = null;
	_size = 0;
	//indicates emptiness
	_capacity = capacity;
    }

    /*
      public boolean isEmpty()
      preconds: size() tracks the number of elements in the Dequeue
      postconds: returns true if size() is 0 (Dequeue is empty); else, false
                 acts as a substitute for simply writing (size() == 0)
     */
    public boolean isEmpty(){
	//one way to track
	//another could be evaluating _front == _end, or even the value of
	//_front.getNext()
	return size() == 0;
    }
    //O(1)

    /*
      public T poll() and pollLast()
      substitute for pop() and remove()/removeLast()
      preconds: an instantiated Dequeue exists
                actually fewer preconds than pop()/remove(), since there is no
		need for an exception to be thrown if the Dequeue is empty
      postconds: if the Dequeue is empty, it returns a null "T"
                 else, for poll(), the first element's cargo is returned, and 
		 that element is passed over by _front, resulting in removal
		 _size also decrements by 1
		 for pollLast(), it is similar, except the last element is
		 returned, and _end moves ahead by 1 to skip over said element
		          
     */
    public T poll(){
	if (isEmpty())
	    return null;
	//to avoid the exception

        T ret = _front.getCargo();
	//item to return
	_front = _front.getNext();
	//passes over the first element
	_size -= 1;
	return ret;
    }
    //O(1)

    public T pollLast(){
	if (isEmpty())
	    return null;

	T ret = _end.getCargo();
	//gets last element
	_end = _end.getPrev();
	//skips over the last element to ignore it
	_size -= 1;
	return ret;
    }
    //O(1)

    /*
      public T peek()/peekLast()
      substitute for getFirst() and getLast()
      preconds: tests for emptiness to avoid throwing an exception, as in the
                "get" methods
      postconds: if the Dequeue is empty, "null" is returned
                 for peek(), the first element's cargo is returned
		 for peekLast(), the return item is the cargo of the last
		 element
		 the structure or size of the Dequeue is unaffected; this is
		 simply an accessor
     */
    public T peek(){
	if (isEmpty())
	    return null;
	//emptiness test

	return _front.getCargo();
	//uses _front as a "ghost node" to get the cargo
    }
    //O(1)

    //same, but for the back
    public T peekLast(){
	if (isEmpty())
	    return null;

	return _end.getCargo();
    }
    //O(1)

    /*
      public int size()
      accessor method for _size
      preconds: there exists an attribute that tracks the size of the Dequeue
      postconds: using the _size attribute, which is private, the number of
                 elements in the Dequeue is returned, making it accessible
     */
    public int size(){
	return _size;
    }
    //O(1)

    /*
      public boolean offer(T x)/offerFirst(T x)
      substitute for push() and add() methods
      preconds: unlike push() and add(), there is no need for an exception if
                the Dequeue is full
		argument x is a "T" value to be inserted into the Dequeue, and
		_size and _capacity attributes must exist to make sure the
		Dequeue is not full
      postconds:
                if _size == _capacity, or if the Dequeue is full, false is
		returned, indicating that an element could not be inserted
		else, true is returned, and...
		   if the Dequeue is empty, a new node with cargo x is added
		   if not, for offer(), x is appended at the end, and _end and
		   _size are updated to reflect this
		   for offerFirst, the bi-directional functionality is used to
		   insert a node with cargo x at the front, and update _front
		   and _size accordingly
     */
    public boolean offer(T x){
	//tests for emptiness to avoid the exception
	if (_size == _capacity)
	    //boolean indicates whether the process has beeen completed
	    return false;
	//if the new node is the first, _front and _end must both connect
	//to it
	if (isEmpty()){
	    _front = _end = new DLLNode<T>(x,null,null);
	    //update _size
	    _size += 1;
	    return true;
	}
        //only _end appears as an argument
	DLLNode<T> newNode = new DLLNode<T> (x, _end, null);
	//appending: only _end is affected, and simply moved over one space
	_end.setNext(newNode);
	_end = newNode;
	_size += 1;
	return true;
    }
    //O(1)

    public boolean offerFirst(T x){
	//first two parts are identical to offer()
	if (_size == _capacity)
	    return false;
	if (isEmpty()){
	    _front = _end = new DLLNode<T>(x,null,null);
	    _size += 1;
	    return true;
	}
	//here, setPrev() is used to insert at the beginning, and only 
	//_front appears as an argument
	DLLNode<T> newNode = new DLLNode<T> (x, null, _front);
	//_front updates
	_front.setPrev(newNode);
	_front = newNode;
	_size += 1;
	//_size increments by one in either case
	return true;
	//process is complete
    }
    //O(1)

    /*
      public boolean contains(Object x)
      preconds: since the Dequeue is limited to the ambiguously-defined "T"
                type, using Object is smart since it carries fewer limitations
		the while loop condition accounts for an empty or single-
		element dequeue, so exceptions should not be an issue
		takes param x of type Object to search for within Dequeue's
		cargo
      postconds: if the x param matches to the cargo of any of the Dequeue's
                 elements, by use of .equals(), return true; else, return 
		 false, as the element is not in there
      should be effective if we ever need to implement removeFirstOccurrence()
      or removeLastOccurrene()
     */
    public boolean contains(Object x){
	DLLNode<T> temp = _front;
	//"ghost" node to traverse the list
	//when null, you have reached the end
	while (temp != null){
	    if (temp.getCargo().equals(x))
		//this would indicate that the specific element exists
		return true;
	    temp = temp.getNext();
	    //continue traversing
	}
	return false;
	//element not found
    }
    //O(n)

    public boolean removeFirstOccurrence(Object o){
	if (isEmpty())
	    return false;
	DLLNode<T> temp = _front;
	while (temp != null){
	    if (temp.getCargo().equals(o) && temp.getPrev().equals(null)){
		temp.getNext().setPrev(null);
		return true;
	    }
	    if (temp.getCargo().equals(o) && temp.getNext().equals(null)){
		temp.getPrev().setNext(null);
		return true;
	    }
	    if (temp.getCargo().equals(o)){
		temp.getPrev().setNext(temp.getNext());
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }					 
    //O(n)

    public boolean removeLastOccurrence(Object o){
	if(isEmpty())
	    return false;
	DLLNode<T> temp = _end;
	while (temp != null){
	    if (temp.getCargo().equals(o) && temp.getNext().equals(null)){
		temp.getPrev().setNext(null);
		return true;
	    }
	    if (temp.getCargo().equals(o) && temp.getPrev().equals(null)){
		temp.getNext().setPrev(null);
		return true;
	    }
	    if (temp.getCargo().equals(o)){
		temp.getNext().setPrev(temp.getPrev());
		return true;
	    }
	    temp = temp.getPrev();
	}
	return false;
    }					 
    //O(n)

    /*
      public String toString()
      overriden toString() method for the Dequeue
      preconds: the Dequeue exists, and is of type String in order to avoid
                exceptions
      postconds: under the assumption that the Dequeue is of type String, 
                 the cargo of each element is appended onto the ret String
		 (return value), and ret is then returned as a wholesome
		 representation of the Dequeue
		 since ret is initialized as "", this accounts for empty 
		 Dequeues
     */
    public String toString(){
	//assumption of type: String
	//return value- starts empty
	String ret = "";
	DLLNode<T> temp = _front;
	//"ghost" node for traversal
        while (temp != null){
	    //separates each element by a single space
	    ret += temp.getCargo() + " ";
	    temp = temp.getNext();
	}
	return ret;
    }
    //O(n)

    //return an Iterator over this list
    public Iterator<T> iterator() 
    { 
	return new MyIterator();
    }

    /*****************************************************
     * inner class MyIterator
     * Adheres to specifications given by Iterator interface.
     * Uses dummy node to facilitate iterability over LList.
     *****************************************************/
    private class MyIterator implements Iterator<T> 
    {

	private DLLNode<T> _dummy; // dummy node to tracking pos
	private boolean _okToRemove; //flag indicates next() was called

	//constructor 
	public MyIterator() 
	{
	    //place dummy node in front of head
	    _dummy = new DLLNode<T>( null, null, _front );
	    //set oktorem flag
	    _okToRemove = false;
	}

	//--------------v  Iterator interface methods  v-------------
	//return true if iteration has more elements.
	public boolean hasNext() 
	{
	    return _dummy.getNext() != null;
	}


	//return next element in this iteration
	public T next() 
	{
	    _dummy = _dummy.getNext();
	    if ( _dummy == null )
		throw new NoSuchElementException();
	    _okToRemove = true;
	    return _dummy.getCargo();
	}


	//remove last element returned by this iterator (from last next() call)
	public void remove() 
	{
	    if ( ! _okToRemove )
		throw new IllegalStateException("must call next() beforehand");
	    _okToRemove = false;

	    //If removing only remaining node...
	    //maintain invariant that _dummy always points to a node
	    //   (...so that hasNext() will not crash)
	    if ( _front == _end ) {
		_front = _end = null;
	    }
	    //if removing first node...
	    else if ( _front == _dummy ) {
		_front = _front.getNext();
		_front.setPrev( null ); //just to save mem
	    }
	    //if removing last node...
	    else if ( _end == _dummy ) {
		_end = _end.getPrev();
		_end.setNext( null );
	    }
	    //if removing an interior node...
	    else {
		_dummy.getNext().setPrev( _dummy.getPrev() );
		_dummy.getPrev().setNext( _dummy.getNext() );
		//Q: How could the line below cause trouble?
		//_dummy = _dummy.getPrev();
	    }
	    _size--; //decrement size attribute of outer class LList
	}
	//--------------^  Iterator interface methods  ^--------------
    }//*************** end inner class MyIterator ***************

    public static void main(String[] args){

	//tests offer() and poll()
	DLDeque<String> test = new DLDeque<String>(5);
	System.out.println("Upon initialization: size = " + test.size());

	System.out.println("\nTesting offer()...");
	//adding elements until capacity of 5
	System.out.println("one: " + test.offer("one"));
        System.out.println("two: " + test.offer("two"));
	System.out.println("three: " + test.offer("three"));
	System.out.println("four: " + test.offer("four"));
	System.out.println("five: " + test.offer("five"));
	System.out.println("six: " + test.offer("six") + "-past capacity");

	System.out.println("\nTesting toString()...");
	System.out.println(test);
	System.out.println("size = " + test.size());

	System.out.println("\nTesting contains()...");
	System.out.println(test.contains("one"));
	System.out.println(test.contains("two"));
	System.out.println(test.contains("three"));
	System.out.println(test.contains("four"));
	System.out.println(test.contains("five"));
	//"six" does not exist
	System.out.println(test.contains("six" + "- 'six' was never inserted"));

	System.out.println("\nTesting poll()...");
	//removes elements one by one
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	//polling an empty Dequeue
	System.out.println(test.poll() + "-list empty");

	System.out.println("\nEnd of test 1\n");

	//tests offerFirst() and pollLast()
	DLDeque<String> test2 = new DLDeque<String>(5);
	System.out.println("Upon initialization: size = " + test2.size());

	System.out.println("\nTesting offerFirst()...");
	System.out.println("one: " + test2.offerFirst("one"));
        System.out.println("two: " + test2.offerFirst("two"));
	System.out.println("three: " + test2.offerFirst("three"));
	System.out.println("four: " + test2.offerFirst("four"));
	System.out.println("five: " + test2.offerFirst("five"));
	//should not work, as the Dequeue is to capacity
	System.out.println("six: " + test2.offerFirst("six"));

	System.out.println("\nTesting toString()...");
	System.out.println(test2);
	//elements are backwards, as they were added to the front (stacky?)
	System.out.println("size = " + test2.size());

	System.out.println("\nTesting contains()...");
	System.out.println(test2.contains("one"));
	System.out.println(test2.contains("two"));
	System.out.println(test2.contains("three"));
	System.out.println(test2.contains("four"));
	System.out.println(test2.contains("five"));
	System.out.println(test2.contains("six") + "-never inserted 'six'");

	System.out.println("\nTesting pollLast()...");
	//"last" elements were actually the first to be inserted
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast() + "-past capacity");
    }
}
