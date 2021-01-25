package academy.pocu.comp3500samples.w06.expressiontree;

import java.util.Stack;

public final class ExpressionTreeParser {
    private ExpressionTreeParser() {
    }

    public static Node buildExpressionTree(String s) {
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

                int j = i;

                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    sb.append(s.charAt(j++));
                }

                Node node = new Node(sb.toString());
                nodeStack.add(node);
                i = j - 1;
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty()
                        && !operatorStack.peek().equals("(")
                        && c != '('
                        && getOperatorPriority(operatorStack.peek()) >= getOperatorPriority(Character.toString(c))) {
                    addNewNodeToNodeStack(nodeStack, operatorStack);
                }

                operatorStack.push(Character.toString(c));
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    addNewNodeToNodeStack(nodeStack, operatorStack);
                }

                operatorStack.pop();
            }
        }

        assert operatorStack.size() == 1;
        assert nodeStack.size() == 2;

        addNewNodeToNodeStack(nodeStack, operatorStack);

        return nodeStack.pop();
    }

    private static void addNewNodeToNodeStack(Stack<Node> nodeStack, Stack<String> operatorStack) {
        Node node = new Node(operatorStack.pop());

        Node right = nodeStack.pop();
        Node left = nodeStack.pop();

        node.setRight(right);
        node.setLeft(left);

        nodeStack.add(node);
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
                throw new IndexOutOfBoundsException(String.format("Unknown operator: %s", operator));
        }
    }
}
