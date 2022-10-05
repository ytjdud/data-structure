package btree;

public class BSTTest {
    public static void main(String[] args) {

        Dictionary<Integer, String> bst = new BST<>();
        // new BST 했으니까 현재 root=null

        bst.insert(11,"a");
        // insert(k,e) => insert_helper(k,e,root) 호출 => insert(11,"e",null);
        bst.insert(3,"b");
        // => InternalNode 만들어서 return
        bst.insert(5,"c");
        bst.insert(2,"d");
        //bst.insert(2,"D");

        bst.remove(3);

        System.out.println(bst.find(2));
        System.out.println(bst.find(3));
        System.out.println(bst.find(11));
        System.out.println(bst.find(5));
        System.out.println(bst.find(30));
    }
}
