package linear;

public class Link<E> {

    public E item;
    public Link<E> next; // 이게먼데  그 다음 아이템이 무엇인지 포인터 역할
    // ppt랑 다르게 getter setter 안씀
    //setNext나 setItem 안썼다고

    public Link(E item, Link<E> next) {
        this.item= item;
        this.next= next;
    }


}
