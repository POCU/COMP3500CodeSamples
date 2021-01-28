package academy.pocu.comp3500samples.w06.preorder;

import java.util.Stack;

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

    public static void traversePreOrderRecursive(final Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        traversePreOrderRecursive(node.left);
        traversePreOrderRecursive(node.right);
    }

    public static void traversePreOrder(final Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> nodes = new Stack<>();

        nodes.push(root);

        while (!nodes.empty()) {
            Node node = nodes.pop();

            System.out.println(node.data);

            if (node.right != null) {
                nodes.push(node.right);
            }

            if (node.left != null) {
                nodes.push(node.left);
            }
        }
    }
}
