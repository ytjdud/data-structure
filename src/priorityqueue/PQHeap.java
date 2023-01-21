package priorityqueue;

import java.util.NoSuchElementException;

public class PQHeap<E extends Comparable<? super E>> implements Queue<E> {

    static int DefaultSize =10;
    E[] Heap; // heap 담을 배열
    int size; // heap의 현재 사이즈(== 맨끝 인덱스)

    public PQHeap(){ // 생성자
        this(DefaultSize);
    }

    public PQHeap(int size) { // 생성자
        this.size = 0;
        this.Heap = (E[]) new Comparable[size+1]; // new Object[size] 라고 못쓰는 이유?
            // E.g. String b means that b is an instance of String class. Java is statically an and strongly typed language.
            // So Comparable[] a says that a is an array of instances of some class implementing Comparable interface.
    }

    // 인덱스0 비우고 1부터 시작 <- size랑 마지막 idx 일치시키게

    // leaf 인지 확인
    public boolean isLeaf(int idx){
        // node(idx) is a leaf if (size/2+1) <= idx < size+1
        // node(idx) is an internal if 1 <= idx < (size/2+1)
        return (idx >= size/2 +1) && (idx< size+1);
    }

    // idx의 leftchild idx 반환
    public int leftchild(int idx) throws IllegalArgumentException{
        // idx의 2*idx<=size 면 leftchild 가 있음
        if ( !(2*idx<=size)) {
            throw new IllegalArgumentException(idx+" has no left child");
        }
        return 2*idx;
    }

    // idx의 rightchild idx 반환
    public int rightchild(int pos) throws IllegalArgumentException{
        // idx의 2*idx+1<=size 면 rightchild 가 있음
        if ( !(2*pos+1 <= size)){
            throw new IllegalArgumentException(pos+" has no right child");
        }
        return 2*pos+1;
    }

    // idx의 parent idx 반환
    public int parent(int pos) throws IllegalArgumentException {
        // idx>1(제일 위) 면 parent 가 있음
        if( !(pos>1)){
            throw new IllegalArgumentException(pos+" has no parent");
        }
        return pos/2;
    }

    public void clear(){
        Heap = null ;
        size = 0;
    }

    // siftUp 방식 insert
    public void insert(E value) {
        // 힙의 현재 default size == 현재 size 면 insert 불가능 -> 더블링 후 insert
        if ( size == this.size) { // array가 다 차있는 상태
            doubling();
        }
        Heap[++size] = value; // 전위연산자(<- idx 1 부터 시작해서) / (size == 맨 마지막 idx) value 집어넣음
        // (tree 구조로 나타냈을때) root 가 아니고 && 본인과 parent의 값을 비교했을때 본인이 더 크면 계속 swap 으로 siftUp
        while ((size>1) && (Heap[size].compareTo( Heap[parent(size)])>0)) {
            swap(size, parent(size));
        }
    }
    public void doubling(){
        E[] doubledH = (E[]) new Comparable[size *2]; // 2배 늘어난 배열 만들고
        // 기존 heap 에서 doubled heap 으로 데이터 복사
        for(int i = 0; i< size; i++){
            doubledH[i] = Heap[i];
        }
        this.size = size *2; // size = size*2 랑 this.size = size*2 차이? (line59.60 도..)
        this.Heap = null; this.Heap = doubledH; // 기존 heap 없애고 doubled heap 으로 업데이트 (?) 맞게 쓴건지 모르겠음
    }
    public void swap(int i, int j) {
        E tmp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = tmp;
    }

    // parent 노드와 자식 노드를 비교하면서 적절한 위치까지 내리기
    public void siftDown(int idx) throws IllegalArgumentException {
        if( idx<1 || idx > size) {
            throw new IllegalArgumentException("Illegal heap position");
        }
        // idx 가 적절한 위치로 내려갈때 까지 -> 첫번째 조건은 idx가 leaf 가 아니어야
       while ( !isLeaf(idx)){
            // 자식 노드중에 큰 쪽이랑 바꾸기전 leftchild 와 rightchilde 중 어떤게 비교하교 바꿀 노드 정하기
            int t = leftchild(idx); // t for target
            if ((t<size) && (Heap[t].compareTo(Heap[t+1]))<0){ // right sibling 이 있고 && right sibling 이 더 크면
                t++; // target을 right sibling으로 재정의 <- line 88 swap 할거니까
            }
            // 본인이 자식보다 더 크면 더이상 siftDown xx
           if( Heap[idx].compareTo(Heap[t])>=0) {
               return;
           }
           swap(idx,t);
        }
    }

    // insert(siftUp) 방식으로 하나씩 값을 넣어 힙 구현 하는 건 O(nlogn)의 시간이 걸림
    // 꽉 차있는 array의 아래부터 siftDown 으로 작업하면 O(n)
    public void buildHeap() {
        /// leaf 노드를 제외한 나머지 노드들에 모두 적용 거꾸로...
        for(int i = size /2; i>0; i--){
            siftDown(i);
        }
    }

    // 가장 큰 값 지우기
    public E removeMax() throws NoSuchElementException {
        if (size<1) {
            throw new NoSuchElementException("It's empty");
        }
        E ret = Heap[1]; // Heap[1]: MaxValue
        swap(1, size); // 루트노드 <-> 마지막 노드 자리바꾸기
        Heap[size--] =null; // 마지막노드(제일 큰 값) 지우고 size -1
        // 루트노드 혼자 있는게 아니면 루트노드자리에 온 가장 작은 마지막노드 siftDown
        if(size>1){
            siftDown(1);
        }
        return ret;
    }

    public int heapSize() {
        return size;
    }
}

