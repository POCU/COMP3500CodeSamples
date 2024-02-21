package academy.pocu.comp3500samples.w06.copytree;

public class Program {
    public static void main(String[] args) {
        Node root = new Node(50);

        Node.insertRecursive(root, 24);
        Node.insertRecursive(root, 42);
        Node.insertRecursive(root, 33);
        Node.insertRecursive(root, 22);

        Node.insertRecursive(root, 55);
        Node.insertRecursive(root, 52);
        Node.insertRecursive(root, 57);

        Node.traverseInOrderRecursive(root);

        System.out.println("--------------------------");

        Node rootCopy = Node.copyRecursive(root);

        Node.traverseInOrderRecursive(rootCopy);

        System.out.println("--------------------------");

        root.getLeft().setData(100);
        Node.traverseInOrderRecursive(root);

        System.out.println("--------------------------");

        Node.traverseInOrderRecursive(rootCopy);

        root.getLeft().setData(24);

        System.out.println("--------------------------");

        Node.insertRecursive(root, 15);

        Node.traverseInOrderRecursive(root);

        System.out.println("--------------------------");

        Node.traverseInOrderRecursive(rootCopy);
    }
}
