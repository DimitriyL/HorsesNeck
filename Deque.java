public interface Deque<T>{

    public T poll();

    public T peek();

    public int size();

    public boolean offer(T x);

    public boolean contains(Object x);

}
