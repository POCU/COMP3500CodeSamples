package academy.pocu.comp3500samples.w06.copytree;

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

    public void setData(final int data) {
        this.data = data;
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

    public static Node copyTree(final Node root) {
        if (root == null) {
            return null;
        }

        Node node = new Node(root.data);
        node.left = copyTree(root.left);
        node.right = copyTree(root.right);

        return node;
    }

    public static void traverseInOrderRecursive(final Node node) {
        if (node != null) {
            traverseInOrderRecursive(node.left);
            System.out.println(node.data);
            traverseInOrderRecursive(node.right);
        }
    }
}
