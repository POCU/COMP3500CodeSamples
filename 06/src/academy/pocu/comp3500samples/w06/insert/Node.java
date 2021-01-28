package academy.pocu.comp3500samples.w06.insert;

public class Node {
    private final int data;
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

    public static Node insertRecursive(final Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertRecursive(node.left,
                    data);
        } else {
            node.right = insertRecursive(node.right,
                    data);
        }

        return node;
    }
}
