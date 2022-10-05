package btree;

// (task 4) BST에 10개 이상의 노드를 넣어보고, root에서부터 inorder traversal을 수행한 결과를 출력해보세요.
public class LBSTTest2 {
    public static void main(String[] args) {
        Dictionary<Integer, String> lbst2 = new LBST<>();

        lbst2.insert(20,"c");
        lbst2.insert(10,"m");
        lbst2.insert(30,"e");
        lbst2.insert(7,"e");
        lbst2.insert(15,"m");
        lbst2.insert(4,"y");
        lbst2.insert(1,"M");
        lbst2.insert(6,"h");
        lbst2.insert(5,"C");
        lbst2.insert(13,"o");
        lbst2.insert(17,"a");
        lbst2.insert(11,"R");
        lbst2.insert(18,"n");

        System.out.print("Inorder Traversal(element)\n : ");
        inorder(((LBST<Integer,String>)lbst2).root);
    }
    private static void inorder(BinNode<LBST<Integer,String>.Entry> rt) {
        if(rt == null) return;
        inorder(rt.left());
        System.out.print(rt.element().element);
        inorder(rt.right());
    }
}

/*
Dictionary 대신 LBST<Integer, String> lbst2 = new LBST<>(); 쓰면
inorder(lbst2.root);  이것만 바뀜
private static void inorder(BinNode<LBST<Integer,String>.Entry> rt)
 */
