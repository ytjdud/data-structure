package btree;

// (task 3) 구현한 BST가 올바르게 동작하는지 확인해보세요.
public class LBSTTest1 {
    public static void main(String[] args) {
        Dictionary<Integer, String> lbst1 = new LBST<>();
        lbst1.insert(14,"a");
        lbst1.insert(10,"b");
        lbst1.insert(26,"c");
        lbst1.insert(15,"y");
        lbst1.insert(26,"s"); // insert the same key but different element
        lbst1.remove(14);

        System.out.println("Find the element of key14: " + lbst1.find(14));
        System.out.println("Find the element of key26: " + lbst1.find(26));

        lbst1.removeAny(); // remove the biggest keyValue
        System.out.println("Find the element of key26: " +lbst1.find(26));
        System.out.println("Size of lbst1 is " + lbst1.size());
        System.out.println();
    }
}
