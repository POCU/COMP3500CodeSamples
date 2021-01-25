package academy.pocu.comp3500samples.w06.insert;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(final int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setLeft(final Node node) {
        this.left = node;
    }

    public void setRight(final Node node) {
        this.right = node;
    }

    public static Node insertRecursive(final Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }
}
