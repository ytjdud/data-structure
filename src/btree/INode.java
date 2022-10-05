package btree;

public class INode<E> implements BinNode<E> {
    private E data;
    private BinNode<E> l,r ;
    // BinNode<E> = 곧 interface 받을 객체.
    // INode 면 INode 가 될 것이고, LNode 면 LNode 가 될것임

    // Initialize INode
    public INode(E data, BinNode<E> l, BinNode<E> r) {
        this.data = data;
        this.l=l;
        this.r=r;
    }
    @Override
    public E element() {
        return data;
    }

    @Override
    public E setElement(E item) {
        return this.data = item;
    }

    @Override
    public BinNode<E> left() {
        return l;
    }

    @Override
    public BinNode<E> right() {
        return r;
    }
    public void setLeft(BinNode<E> n) {
        this.l = n;
    }
    public void setRight(BinNode<E> n) {
        this.r = n;
    }
    @Override
    public boolean isLeaf() {
        return l == null && r == null;
    }

    public BinNode<E> toLNode(){
        return new LNode<>(this.data);
    }
}
