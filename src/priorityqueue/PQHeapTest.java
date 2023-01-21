package priorityqueue;

public class PQHeapTest {
    public static void main(String[] args) {
        PQHeap<Integer> pq = new PQHeap<>();
        pq.insert(88);
        pq.insert(90);
        pq.insert(40);
        pq.removeMax();
        System.out.println(pq.heapSize());
        System.out.println(pq.rightchild(2));


    }
}
