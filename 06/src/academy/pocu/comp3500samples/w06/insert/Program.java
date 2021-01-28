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

        int num = root.getData();
        System.out.println(num);

        num = root.getLeft().getData();
        System.out.print(num);

        System.out.print(" ");

        num = root.getRight().getData();
        System.out.print(num);

        System.out.println();

        num = root.getLeft().getLeft()
                .getData();
        System.out.print(num);

        System.out.print(" ");

        num = root.getLeft().getRight()
                .getData();
        System.out.print(num);

        System.out.print(" ");

        num = root.getRight().getLeft()
                .getData();
        System.out.print(num);

        System.out.print(" ");

        num = root.getRight().getRight()
                .getData();
        System.out.print(num);

        System.out.println();

        num = root.getLeft().getRight()
                .getLeft().getData();
        System.out.print(num);

        System.out.println();

        Node.insertRecursive(root, 53);

        num = root.getRight().getLeft()
                .getRight().getData();
        System.out.print(num);
    }
}
