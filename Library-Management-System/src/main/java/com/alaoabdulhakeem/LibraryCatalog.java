package com.alaoabdulhakeem;

import java.util.ArrayList;

class LibraryCatalog {
    private final ArrayList<Book> books;

    // Constructor
    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    // Add a book to the catalog
    public void addBook(Book book) {
        books.add(book);
    }

    // Search for books by title
    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                results.add(book);
            }
        }
        return results;
    }

    // Search for books by author
    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }

    // Check out a book by title
    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isCheckedOut()) {
                book.checkOut();
                System.out.println("You have successfully checked out: " + title);
                return;
            }
        }
        System.out.println("The book is either not available or already checked out.");
    }

    // Return a book by title
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isCheckedOut()) {
                book.returnBook();
                System.out.println("You have successfully returned: " + title);
                return;
            }
        }
        System.out.println("The book is either not available or not checked out.");
    }

    // Display all books in the catalog
    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

