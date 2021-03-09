package academy.pocu.comp3500samples.w09.directorytree;

import java.io.File;

public class Program {
    private static final int INDENT_LENGTH = 2;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println(String.format("Wrong number of arguments: %d", args.length));
            System.exit(1);
        }

        String path = args[0];

        File file = new File(path);

        if (!file.isDirectory()) {
            System.err.println("The path provided is not a directory.");
            System.exit(1);
        }

        printDirectoryTree(file, 0);
    }

    private static void printDirectoryTree(File file, int depth) {
        String filename = file.getName();

        String message = String.format("- %s", filename);
        message = padLeft(INDENT_LENGTH * depth, message);

        System.out.println(message);

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (File f : files) {
                printDirectoryTree(f, depth + 1);
            }
        }
    }

    private static String padLeft(int padLength, String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padLength; i++) {
            sb.append(' ');
        }

        sb.append(message);

        return sb.toString();
    }
}
