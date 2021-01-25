package academy.pocu.comp3500samples.w06.expressiontree;

public class Program {
    public static void main(String[] args) {
        Node root = ExpressionTreeParser.buildExpressionTree("6 + 3 * (2 - 5)");

        Node.traverseInOrderRecursive(root);
    }


}
