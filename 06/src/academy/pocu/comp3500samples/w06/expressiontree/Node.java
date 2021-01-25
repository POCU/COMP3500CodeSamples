package academy.pocu.comp3500samples.w06.expressiontree;

public class Node {
    private String operand;
    private Node left;
    private Node right;

    public Node(final String operand) {
        this.operand = operand;
    }

    public String getOperand() {
        return this.operand;
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

    public static void traverseInOrderRecursive(final Node node) {
        if (node != null) {
            traverseInOrderRecursive(node.left);
            System.out.print(node.operand);
            traverseInOrderRecursive(node.right);
        }
    }

    public static void traversePreOrderRecursive(final Node node) {
        if (node != null) {
            System.out.print(node.operand);
            traversePreOrderRecursive(node.left);
            traversePreOrderRecursive(node.right);
        }
    }
}
