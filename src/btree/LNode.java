package btree;

public class LNode<E> implements BinNode<E> {
    public E data;

    public LNode(E data) {
        this.data = data;
    }
    public E element() {
        return data;
    }
    public E setElement(E item) {
        return this.data = item;
    }
    public BinNode<E> left() {
        return null;
    }
    public BinNode<E> right() {
        return null;
    }

    public void setLeft(BinNode<E> n) { }
    public void setRight(BinNode<E> n) { }

    public boolean isLeaf() {
        return true;
    }

    public BinNode<E> toINode(){
        return new INode<>(this.data, null , null);
    }

}
