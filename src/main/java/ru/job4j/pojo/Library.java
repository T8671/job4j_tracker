package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("firstBook", 15);
        Book secondBook = new Book("secondBook", 30);
        Book thirdBook = new Book("thirdBook", 45);
        Book fourthBook = new Book("Clean code", 60);
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getTitle() + " - " + book.getQuantity());
        }
        Book temp;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        System.out.println("Replace book 1 to book 4.");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getTitle() + " - " + book.getQuantity());
        }

        System.out.println("Shown only book - Clean code");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getTitle())) {
                System.out.println(book.getTitle());
            }
        }
    }
}
