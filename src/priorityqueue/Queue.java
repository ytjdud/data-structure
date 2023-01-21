package priorityqueue;

public interface Queue <E> {

    public void clear();
    public void insert(E value);
    public void buildHeap();
    public void siftDown(int pos);
    public void swap(int i, int j);
    public E removeMax();

    public int heapSize();


}
