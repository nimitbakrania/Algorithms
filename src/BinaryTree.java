import java.util.ArrayList;
import java.util.List;

class TNode<T extends Comparable<T>> {
    T data;
    public TNode<T> left;
    public TNode<T> right;

    public TNode(T data){
        this.data = data;
    }
}


public class BinaryTree<T extends Comparable<T>> {
    private TNode root;

    public TNode getRoot() {
        return this.root;
    }

    public void add(T data) {
        TNode<T> newNode = new TNode<T>(data);
        if (root == null) {
            root = newNode;
        } else {
            TNode<T> tempNode = root;
            TNode<T> prev = null;
            while (tempNode != null) {
                prev = tempNode;
                if (data.compareTo(tempNode.data) > 0) {
                    tempNode = tempNode.right;
                } else {
                    tempNode = tempNode.left;
                }
            }
            if (data.compareTo(prev.data) < 0) {
                prev.left = newNode;
            } else {
                prev.right = newNode;
            }

        }
    }


    public void traverseInOrder(TNode<T> root, List<T> storageList) {
        if (root != null) {
            traverseInOrder(root.left, storageList);
            storageList.add(root.data);
            traverseInOrder(root.right, storageList);
        }
    }

    public void traversePreOrder(TNode<T> root, List<T> storageList) {
        if (root != null) {
            storageList.add(root.data);
            traversePreOrder(root.left, storageList);
            traversePreOrder(root.right, storageList);
        }
    }

    public void traversePostOrder(TNode<T> root, List<T> storageList) {
        if (root != null) {
            traversePostOrder(root.left, storageList);
            traversePostOrder(root.right, storageList);
            storageList.add(root.data);
        }
    }

    public void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
    public static void main(String args[]) {
        BinaryTree<Integer> bTree = new BinaryTree<>();
        bTree.add(50);
        bTree.add(30);
        bTree.add(60);
        bTree.add(25);
        bTree.add(40);
        bTree.add(35);
        bTree.add(70);
        bTree.add(65);

        System.out.println("#### Inorder Traversal ####");
        List<Integer> inOrderList = new ArrayList<>();
        bTree.traverseInOrder(bTree.getRoot(), inOrderList);
        bTree.printList(inOrderList);

        System.out.println("#### Pre Traversal ####");
        List<Integer> preOrderList = new ArrayList<>();
        bTree.traversePreOrder(bTree.getRoot(), preOrderList);
        bTree.printList(preOrderList);


        System.out.println("#### Post Traversal ####");
        List<Integer> postOrderList = new ArrayList<>();
        bTree.traversePostOrder(bTree.getRoot(), postOrderList);
        bTree.printList(postOrderList);

    }
}


