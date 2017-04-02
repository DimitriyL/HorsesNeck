public interface Deque<T>{

    public T poll();

    public T pollLast();

    public T peek();

    public T peekLast();

    public int size();

    public boolean offer(T x);

    public boolean offerFirst(T x);

    public boolean contains(Object x);

}
