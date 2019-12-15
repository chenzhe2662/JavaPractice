
public class BinarySearchTree {
   static class Node {
        int val;

        Node left;
        Node right;

       public Node(int val) {
           this.val = val;
       }
   }
   Node root = null;
   public void insert(int key) {
       if (root == null) {
           root = new Node(key);
           return;
       }
       Node cur = root;
       Node parent = null;
       while (cur != null) {
           if (cur.val == key) {
               return;
           }else if (cur.val < key) {
               parent = cur;
               cur = cur.right;
           }else {
               parent = cur;
               cur = cur.left;
           }
       }
       Node node = new Node(key);
       if (key < parent.val) {
           parent.left = node;
       }else {
           parent.right = node;
       }
   }
   public Node search(int key) {
       if (root == null) {
           return null;
       }
       Node cur = root;
       while (cur != null) {
           if (cur.val == key) {
               return cur;
           }else if (cur.val < key) {
               cur = cur.right;
           }else {
               cur = cur.left;
           }
       }
       return null;
   }
   public void remove(int key) {
       Node cur = root;
       Node parent = null;
       while (cur != null) {
           if (cur.val == key) {

                removeNode(parent,cur);
                return;

           }else if (cur.val > key){
               parent = cur;
               cur = cur.left;
           } else {
               parent = cur ;
               cur = cur.right;
           }
       }
   }
   public  void removeNode(Node parent,Node cur) {
       if (cur.left == null){
           if (cur == root) {
               root = root.right;
           }else if (cur == parent.left) {
               parent.left = cur.right;
           }else {
               parent.right = cur.right;
           }
       }else if (cur.right == null) {
           if (cur == root) {
               root = root.right;
           }else if (cur == parent.left) {
               parent.left = cur.left;
           }else {
               parent.right = cur.left;
           }
       }else {
           Node newParent = cur;
           Node newCur = cur.right;
           while (newCur.left != null) {
               newParent = newCur;
               newCur = newCur.left;
           }
           cur.val = newCur.val;
           if (newCur == newParent.left) {
               newParent.left = newCur.right;
           }else {
               newParent.right = newCur.right;
           }
       }
   }

}
