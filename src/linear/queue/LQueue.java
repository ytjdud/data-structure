package linear.queue;

public class LQueue<E> {
    E item;
    LQueue<E> next;

    public LQueue(E item, LQueue<E> next) {
        this.item = item;
        this.next = next;
    }

}
