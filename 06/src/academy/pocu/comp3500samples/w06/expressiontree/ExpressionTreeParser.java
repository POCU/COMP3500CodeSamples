package academy.pocu.comp3500samples.w06.expressiontree;

import java.util.Stack;

public final class ExpressionTreeParser {
    private ExpressionTreeParser() {
    }

    public static Node buildExpressionTree(String s) {
        // Stack to hold nodes
        Stack<Node> nodeStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (c == '(') {
                operatorStack.add(Character.toString(c));
            } else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i++));
                }

                Node node = new Node(sb.toString());
                nodeStack.add(node);
            } else if (isOperator(c)) {

                // If an operator with lower or
                // same associativity appears
                while (!operatorStack.isEmpty()
                        && operatorStack.peek() != "("
                        && getOperatorPriority(operatorStack.peek()) >= getOperatorPriority(Character.toString(c))) {

                    // Get and remove the top element
                    // from the character stack
                    Node node = new Node(operatorStack.pop());

                    // Get and remove the top element
                    // from the node stack
                    Node right = nodeStack.pop();

                    // Get and remove the currently top
                    // element from the node stack
                    Node left = nodeStack.pop();

                    // Update the tree
                    node.setRight(right);
                    node.setLeft(left);

                    // Push the node to the node stack
                    nodeStack.add(node);
                }

                // Push s[i] to char stack
                operatorStack.push(Character.toString(c));
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != "(") {
                    Node node = new Node(operatorStack.pop());
                    Node right = nodeStack.pop();
                    Node left = nodeStack.pop();
                    node.setLeft(left);
                    node.setRight(right);
                    nodeStack.add(node);
                }

                operatorStack.pop();
            }
        }

        return nodeStack.pop();
    }

    private static boolean isOperator(final char c) {
        if (c == '-' || c == '+' || c == '*' || c == '/') {
            return true;
        }

        return false;
    }

    private static int getOperatorPriority(final String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 0;

            case "*":
            case "/":
                return 1;

            default:
                throw new IndexOutOfBoundsException(String.format("Unknown operator: %c", operator));
        }
    }
}
