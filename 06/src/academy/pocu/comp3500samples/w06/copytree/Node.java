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

    public static Node insertRecursive(final Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    public static Node copyRecursive(final Node node) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.data);
        newNode.left = copyRecursive(node.left);
        newNode.right = copyRecursive(node.right);

        return newNode;
    }

    public static void traverseInOrderRecursive(final Node node) {
        if (node == null) {
            return;
        }

        traverseInOrderRecursive(node.left);
        System.out.println(node.data);
        traverseInOrderRecursive(node.right);
    }
}
