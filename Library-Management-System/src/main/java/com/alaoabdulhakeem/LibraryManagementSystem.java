package com.alaoabdulhakeem;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        // Add some books to the catalog
        catalog.addBook(new Book("1984", "George Orwell"));
        catalog.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        catalog.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        // Simple text-based menu for user interaction
        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Author");
            System.out.println("4. Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    catalog.addBook(new Book(title, author));
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    ArrayList<Book> booksByTitle = catalog.searchByTitle(title);
                    if (booksByTitle.isEmpty()) {
                        System.out.println("No books found with the title: " + title);
                    } else {
                        for (Book book : booksByTitle) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter author to search: ");
                    author = scanner.nextLine();
                    ArrayList<Book> booksByAuthor = catalog.searchByAuthor(author);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books found by the author: " + author);
                    } else {
                        for (Book book : booksByAuthor) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter title to check out: ");
                    title = scanner.nextLine();
                    catalog.checkOutBook(title);
                    break;
                case 5:
                    System.out.print("Enter title to return: ");
                    title = scanner.nextLine();
                    catalog.returnBook(title);
                    break;
                case 6:
                    catalog.displayAllBooks();
                    break;
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
