package btree;

// PPT L05.30~
public interface Dictionary<K,E> {
    public void clear();
    public void insert(K k, E e);
    public E remove(K k);
    public E removeAny();
    public E find(K k);
    public int size();
}
