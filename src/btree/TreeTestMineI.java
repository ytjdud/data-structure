package btree;

//using InternalNode
public class TreeTestMineI {
    public static void main(String[] args) {

        BinNode<String> C= new INode<>("C", null,null);
        BinNode<String> M= new INode<>("M", null,null);
        BinNode<String> h= new INode<>("h", C,null);
        BinNode<String> R= new INode<>("R", null,null);
        BinNode<String> n= new INode<>("n", null,null);

        BinNode<String> y= new INode<>("y", M,h);
        BinNode<String> o= new INode<>("o", R,null);
        BinNode<String> a= new INode<>("a", null,n);

        BinNode<String> e1= new INode<>("e", y,null);
        BinNode<String> m2= new INode<>("m", o,a);

        BinNode<String> m1= new INode<>("m", e1,m2);
        BinNode<String> e2= new INode<>("e", null,null);

        BinNode<String> c= new INode<>("c", m1,e2);

        System.out.print("preorder traversal: "); preorder(c);
        System.out.println();
        System.out.print("inorder traversal: "); inorder(c);
        System.out.println();
        System.out.print("postorder traversal: "); postorder(c);
        System.out.println();
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
