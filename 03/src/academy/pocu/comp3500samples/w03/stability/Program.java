package academy.pocu.comp3500samples.w03.stability;

import java.util.Arrays;
import java.util.Comparator;

public class Program {

    public static void main(String[] args) {
        Book[] books = new Book[10];

        books[0] = new Book(5, "My Book 5 copy 1");
        books[1] = new Book(1, "My Book 1");
        books[2] = new Book(5, "My Book 5");
        books[3] = new Book(1, "My Book 1 copy 2");
        books[4] = new Book(3, "My Book 3");
        books[5] = new Book(2, "My Book 2");
        books[6] = new Book(4, "My Book 4 copy 1");
        books[7] = new Book(4, "My Book 4");
        books[8] = new Book(1, "My Book 1 copy 1");
        books[9] = new Book(4, "My Book 4 copy 2");

        Book[] booksCopy = copyBooks(books);

        quickSort(booksCopy);

        printBooks(booksCopy);

        booksCopy = copyBooks(books);

        Arrays.sort(booksCopy, Comparator.comparingInt(Book::getID));

        printBooks(booksCopy);
    }

    private static Book[] copyBooks(Book[] books) {
        Book[] newBooks = new Book[10];

        for (int i = 0; i < books.length; ++i) {
            newBooks[i] = new Book(books[i].getID(), books[i].getTitle());
        }

        return newBooks;
    }

    private static void printBooks(Book[] books) {
        System.out.println("--------------Books--------------");

        for (Book book : books) {
            System.out.println(String.format("%d. %s", book.getID(), book.getTitle()));
        }

        System.out.println("--------------end--------------");
    }

    private static void quickSort(Book[] books) {
        quickSortRecursive(books, 0, books.length - 1);
    }

    private static void quickSortRecursive(Book[] books, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotPos = partition(books, left, right);

        quickSortRecursive(books, left, pivotPos - 1);
        quickSortRecursive(books, pivotPos + 1 , right);
    }

    private static int partition(Book[] books, int left, int right) {
        Book pivot = books[right];
        int i = (left - 1);

        for (int j = left; j < right; ++j) {
            if (books[j] == null || pivot == null) {
                var x = 10;
            }

            if (books[j].getID() < pivot.getID()) {
                ++i;
                swap(books, i, j);
            }
        }

        int pivotPos = i + 1;

        swap(books, pivotPos, right);

        return pivotPos;
    }

    private static void swap(Book[] books, int pos1, int pos2) {
        Book temp = books[pos1];
        books[pos1] = books[pos2];
        books[pos2] = temp;
    }
}
