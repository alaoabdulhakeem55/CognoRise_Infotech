package com.alaoabdulhakeem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
class Book {
    private final String title;
    private final String author;
    private boolean isCheckedOut;

    // Check out the book
    public void checkOut() {
        if (!isCheckedOut) {
            isCheckedOut = true;
        } else {
            System.out.println("The book is already checked out.");
        }
    }

    // Return the book
    public void returnBook() {
        if (isCheckedOut) {
            isCheckedOut = false;
        } else {
            System.out.println("The book is already available.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " + (isCheckedOut ? "Checked Out" : "Available");
    }
}
