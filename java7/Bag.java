import java.util.Arrays;

class Bag
{
    private Book[] books;               //Instance Book array variable to store the book object.
    private int size;                   //Instance int variable to store the no of books in Bag Class.

    //Constructor to set size to 0 and initialize or allocate memory for 1 book array.
    Bag()
    {
        this.size = 0;

        books = new Book[1];
    }

    //Method to insert a already existed book object to the book array.
    public void insertBook(Book book)
    {
        if(size < 10)
        {
            books[size++] = book;

            books = Arrays.copyOf(books, books.length+1);               //Increasing the size of book array by 1.
        }
        else
            System.out.println("Error, Book is full!");
    }

    //Method to return Book array of all the book in which argument keyword is found in book text.
    public Book[] searchBooksByKeyword(String keyword)
    {
        Book []newBook = new Book[1];               //Creating a newBook array to store the matched keyword book.
        int current = 0;
        for(int i=0;i<size;i++)
        {
            if(books[i].countKeywordOccurrences(keyword) > 0)               //Checking if keyword is present in book or not.
            {   
                newBook[current++] = books[i];
                newBook = Arrays.copyOf(newBook, newBook.length+1);
            }
        }

        return newBook;
    }

    //Method that returns Book in which argument keyword is most occurred.
    public Book searchBookWithMostOccurrences(String keyword)
    {
        Book highOccuBook = books[0];               //Pointing highOccuBook Book variable to Book array 0th index.
        for(int i=1;i<size;i++)
        {
            if(books[i].countKeywordOccurrences(keyword) > highOccuBook.countKeywordOccurrences(keyword))               //If other Book apart from Book[0] has high occurrence of keyword then set highOccBook to that Book.
            {
                highOccuBook = books[i];
            }
        }

        return highOccuBook;
    }
}