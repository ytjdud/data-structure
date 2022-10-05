package btree;

public class TreeTest {
    public static void main(String[] args) { // static 함수에서는 static 만 호출가능

        // 아래부터 만들어야  윗줄 만드는게 편하다캄 ....포인터때매
		/*
		BinNode<String> d= new INode<>("D", null,null);
		BinNode<String> g= new INode<>("G", null,null);
		BinNode<String> h= new INode<>("H", null,null);
		BinNode<String> i= new INode<>("I", null,null);
		*/
        BinNode<String> d= new LNode<>("D");
        BinNode<String> g= new LNode<>("G");
        BinNode<String> h= new LNode<>("H");
        BinNode<String> i= new LNode<>("I");

        BinNode<String> b= new INode<>("B", null,d);
        BinNode<String> e= new INode<>("E", g,null);
        BinNode<String> f= new INode<>("F", h,i);
        BinNode<String> c= new INode<>("C", e,f);

        BinNode<String> a= new INode<>("A", b,c);

        System.out.println(a.right().left().left().element());
        System.out.println(a.right().right().left().element());

        System.out.println();
        preorder(a);
        System.out.println();
        inorder(a);
        System.out.println();
        postorder(a);
    }

    //traversal 구현
    static public <E> void preorder(BinNode<E> rt) {
        if(rt == null) return;
        System.out.print(rt.element()); //visit
        preorder(rt.left());
        preorder(rt.right());
    }

    static public <E> void inorder(BinNode<E> rt) {
        if(rt == null) return;
        inorder(rt.left());
        System.out.print(rt.element()); //visit
        inorder(rt.right());
    }

    static public <E> void postorder(BinNode<E> rt) {
        if(rt == null) return;
        postorder(rt.left());
        postorder(rt.right());
        System.out.print(rt.element()); //visit
    }
}
