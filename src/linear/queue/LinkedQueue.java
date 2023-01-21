package linear.queue;

import linear.Link;
import linear.interfaces.Queue;

public class LinkedQueue<E> implements Queue<E> {
    Link<E> head, tail;
    int size;

    public LinkedQueue() {
        head = tail = new Link<>(null,null);
        size = 0;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public void enqueue(E item) {
        Link<E> n = new Link<>(item, null);
        if(size == 0) { head = n; }
        else { tail.next = n; }
        tail = n;

        size ++;
    }
    public void dequeue() {
        head = head.next ;
        size --;
    }
    public E front() { return head.item; }
    public E rear() { return tail.item; }
    public int length() { return size; }

    public String toString() {
        String a = "";
        Link<E> curr = head;
        for(int i=0; i<size; i++) {
            a += curr.item + " ";
            curr = curr.next;
        }
        return a;
    }
	/*
	public static void main(String[] args) {
		Queue<Integer> myLQueue = new LinkedQueue<>();
		System.out.println("<Test3: Linked Queue>");

		myLQueue.enqueue(12); myLQueue.enqueue(23); myLQueue.enqueue(4);
		myLQueue.dequeue(); myLQueue.enqueue(9);
		System.out.println(" myLQueue: "+myLQueue);

		System.out.println(" front value: "+ myLQueue.front());
		System.out.println(" rear value: "+ myLQueue.rear());
		System.out.println(" length: "+ myLQueue.length());
	}
	*/
}
