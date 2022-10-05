package btree;

// (task 2) BST를 구현할 때 leaf 노드는 null 포인터가 없는 LNode 를 사용하도록 실습 코드를 수정해보세요.

public class LBST<K extends Comparable<K>,E> implements Dictionary<K,E> {

    class Entry{
        K key; E element;
        public Entry(K key, E element){
            this.key = key;
            this.element = element;
        }
    }
    protected BinNode<Entry> root;
    private int size;

    public LBST() {
        this.root = null;
        this.size = 0;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
    }

    public void insert(K k, E e) {
        root = insertHelper(root,k,e);
        size++;
    }
    private BinNode<Entry> insertHelper(BinNode<Entry> rt, K k, E e){
        if (rt == null) {
            BinNode<Entry> newnode = new LNode<>(new Entry(k, e));
            return newnode;
        } else if (rt.element().key.compareTo(k)==0){
            rt.element().element = e;
            size --;
        } else {
            // rt의 타입 확인 -> LNode 면 INode 로 바꿔주기
            // 그래야 재귀함수 돌아오면서 setRight/setLeft 적용가능
            if (rt instanceof LNode) {
                rt = ((LNode<Entry>) rt).toINode();
            }
            if (rt.element().key.compareTo(k) < 0) {
                rt.setRight(insertHelper(rt.right(), k, e));
            } else {
                rt.setLeft(insertHelper(rt.left(), k, e));
            }
        }
        return rt;
    }

    public E remove(K k) {
        E ret = findHelper(root,k);
        if(ret != null){
            root = removeHelper(root, k);
            size--;
        }
        return ret;
    }

    private BinNode<Entry> removeHelper(BinNode<Entry> rt, K k){
        if (rt.element().key.compareTo(k) < 0) {
            rt.setRight(removeHelper(rt.right(), k) );
            // rt가 왼오 자식 모두 없고 && 타입이 INode 이면 -> LNode 로 바꾸기
            if (rt.left() == null && rt.right() == null && rt instanceof INode){
                rt = ((INode) rt).toLNode();
            }
        } else if(rt.element().key.compareTo(k) > 0){
            rt.setLeft(removeHelper(rt.left(), k) );
            // rt가 왼오 자식 모두 없고 && 타입이 INode 이면 -> LNode 로 바꾸기
            if (rt.left() == null && rt.right() == null && rt instanceof INode){
                rt = ((INode) rt).toLNode();
            }
        } else{
            if(rt.left()==null){
                return rt.right();
            }
            if (rt.right()==null){
                return rt.left();
            } else {
                rt.setElement(getSmallestLeft(rt.right()) );
                rt.setRight(removeSmallestLeft(rt.right()));
            }
        }
        return rt;
    }
    private Entry getSmallestLeft(BinNode<Entry> rt){
        if(rt.left()==null){
            return rt.element();
        } else{
            return getSmallestLeft(rt.left());
        }
    }
    private BinNode<Entry> removeSmallestLeft(BinNode<Entry> rt){
        if (rt.left() == null){
            return rt.right();
        } else{
            rt.setLeft(removeSmallestLeft(rt.left()));
            // rt가 왼오 자식 모두 없고 && 타입이 INode 이면 -> LNode 로 바꾸기
            if (rt.right() ==null&& rt.left()==null& rt instanceof INode){
                rt = ((INode) rt).toLNode();
                return rt;
            }
            return rt;
        }
    }

    // 가장 큰 key를 가진 node를 삭제할 removeAny
    public E removeAny() {
        E ret =  findAnyHelper(root);
        removeAnyHelper(root);
        size --;
        return ret;
    }

    private E findAnyHelper(BinNode<Entry> rt) {
        if(rt.right() == null){
            return rt.element().element;
        }else{
            return findAnyHelper(rt.right());
        }
    }
    private BinNode<Entry> removeAnyHelper(BinNode<Entry> rt) {
        if(rt.right()==null){
            if(rt==root){
                root = rt.left();
            }
            rt = null;
        }else{
            rt.setRight(removeAnyHelper(rt.right()));
            // rt가 왼오 자식 모두 없고 && 타입이 INode 이면 -> LNode 로 바꾸기
            if (rt.left() ==null && rt instanceof INode){
                rt = ((INode) rt).toLNode();
                return rt;
            }
        }
        return rt;
    }

    public E find(K k) {
        return findHelper(root, k);
    }
    private E findHelper(BinNode<Entry> rt, K k){
        if (rt ==null)   {
            return null;
        } else if (rt.element().key.compareTo(k) ==0){
            return rt.element().element;
        } else if (rt.element().key.compareTo(k)< 0){
            return findHelper(rt.right(),k);
        } else {
            return findHelper(rt.left(),k);
        }
    }

    public int size() {
        return size;
    }

    private void Check(BinNode<Entry> rt){
        if (rt instanceof INode){
            System.out.println(rt.element().key+"("+rt.element().element+") is INode");
        }
        if(rt instanceof LNode){
            System.out.println(rt.element().key+"("+rt.element().element+") is LNode");
        }
    }


}
