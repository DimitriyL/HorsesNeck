//Team HorsesNeck {Dimitriy Leksanov, Michael Ruvinshteyn, Manahal Tabassum}
//APCS2 pd 1
//Lab 02 -- All Hands on Deque!
//2017 - 4 - 2

//implementation by Dequeue
//uses elements relevant for now
//poll(), peek(), and offer() were chosen to avoid exceptions
//further explanations in the Dequeue() class comments
public interface Deque<T>{

    //removes and returns the first element of the Deque if not empty
    //simply returns null otherwise
    public T poll();

    //like poll(), but for the last element
    public T pollLast();

    //only returns the first element if Deque is not empty
    //returns null is it is empty to avoid an exception
    public T peek();

    //like peek(), but for the last element
    public T peekLast();

    //returns the private _size attribute's value, or the length of the Deque
    public int size();

    //if not at capacity, appends a new node and "T" value at the end of the 
    //Deque, and returns true to indicate completion
    //otherwise, returns false
    public boolean offer(T x);

    //like offer(), but inserts the value x at the front of the Deque
    public boolean offerFirst(T x);

    //returns true if x is contained in the Deque; false otherwise
    //could be useful for future implementation, like removing instances
    //of a particular element
    public boolean contains(Object x);

    public boolean removeFirstOccurrence(Object o);

    public boolean removeLastOccurrence(Object o);

}
