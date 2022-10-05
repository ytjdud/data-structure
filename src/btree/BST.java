package btree;

public class BST< K extends Comparable<K>, E > implements Dictionary<K,E> {
    // K 는 comparable<K> 를 구현함.
        // comparable 이란 자기자신과 매개변수 객체를 비교
            // compareTo() 메소드는 객체를 비교한 기준을 정의
                // 자기자신은 ClassName 으로 생성한 객체 자신이 되고,
                // 매개변수 객체는 ClassName.compareTo(o); 를 통해 들어온 파라미터 o가 비교 할 객체가 되는 것이다.
    class Entry{
        K key; E element; // ! int num
        public Entry(K key, E element) {
            this.key = key;
            this.element = element;
        }
    }
    private BinNode<Entry> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public void insert(K k, E e) {
        root = insert_helper(k,e,root);
        size++;
    }
    public BinNode<Entry> insert_helper(K k,E e, BinNode<Entry> rt) {
        if (rt == null) {
            return new INode<>(new Entry(k,e),null,null);
        }

        // modify : node14-홍길동 을 node14-김철수 로 변경
        else if (rt.element().key.compareTo(k)==0) {
            rt.element().element = e;
        }

        else if (rt.element().key.compareTo(k) < 0) {
            rt.setRight(insert_helper(k,e,rt.right()));
        }
        else {
            rt.setLeft(insert_helper(k,e,rt.left()));
        }

        return rt;
    }


    public E remove(K k) {
        E ret = find_helper(k, root);
        if (ret != null) {
            root = remove_helper(k,root);
            size --;
        }
        return ret;
    }

    private BinNode<Entry> remove_helper(K k, BinNode<Entry> rt)
    {
        if (rt.element().key.compareTo(k) > 0) {
            rt.setLeft(remove_helper(k, rt.left()));
        }
        else if (rt.element().key.compareTo(k) < 0){
            rt.setRight(remove_helper(k, rt.right()) );
        }
        else {
            if (rt.left()==null){
                return rt.right();
            }
            else if (rt.right()==null){
                return rt.left();
            }
            else {
                Entry leftmost = getLeftMost(rt.right()); // getLeftMost(the smallest) from rt.right
                rt.setElement(leftmost);
                rt.setRight(removeLeftMost(rt.right()));
            }
        }
        return rt;
    }

    private Entry getLeftMost(BinNode<Entry> rt) {
        BinNode<Entry> cur =rt; // 이거  재귀함수로 구현해보기
        while(cur.left() != null){
            cur = cur.left();
        }
        return cur.element() ;
    }

    private BinNode<Entry> removeLeftMost (BinNode<Entry> rt){
        if (rt.left() == null){
            return rt.right();
        }
        else {
            rt.setLeft(removeLeftMost(rt.left()));
            return rt;
        }
    }

    public E removeAny() {
        return null;
    }


    public E find(K k) {
        return find_helper(k, root);
    }
    private E find_helper(K k, BinNode<Entry> rt) {
        if ( rt == null )   return null;
        else if ( rt.element().key.compareTo(k) == 0 ) {
            return rt.element().element;
        }
        else if(rt.element().key.compareTo(k)<0) {
            return find_helper(k,rt.right());
        }
        else {
            return find_helper(k,rt.left());
        }
    }

    public int size() {
        return size;
    }

}
