package academy.pocu.comp3500samples.w06.insert;

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

        System.out.println(root.getData());

        System.out.print(root.getLeft().getData());
        System.out.print(" ");
        System.out.print(root.getRight().getData());

        System.out.println();

        System.out.print(root.getLeft().getLeft().getData());
        System.out.print(" ");
        System.out.print(root.getLeft().getRight().getData());
        System.out.print(" ");
        System.out.print(root.getRight().getLeft().getData());
        System.out.print(" ");
        System.out.print(root.getRight().getRight().getData());

        System.out.println();

        System.out.print(root.getLeft().getRight().getLeft().getData());

        System.out.println();

        Node.insertRecursive(root, 53);

        System.out.print(root.getRight().getLeft().getRight().getData());
    }
}
