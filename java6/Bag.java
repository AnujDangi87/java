import java.util.Arrays;

class Bag
{
    private Book []books;
    private int size;

    Bag()
    {
        this.size = 0;

        books = new Book[1];
    }

    public void insertBook(Book book)
    {
        if(size < 10)
        {
            books[size++] = book;

            books = Arrays.copyOf(books, books.length+1);
        }
        else
            System.out.println("Error, Book is full!");
    }

    public Book[] searchBooksByKeyword(String keyword)
    {
        Book []newBook = new Book[1];
        int current = 0;
        for(int i=0;i<size;i++)
        {
            if(books[i].countKeywordOccurrences(keyword) > 0)
            {   
                newBook[current++] = books[i];
                newBook = Arrays.copyOf(newBook, newBook.length+1);
            }
        }

        return newBook;
    }

    public Book searchBookWithMostOccurrences(String keyword)
    {
        Book highOccuBook = books[0];
        for(int i=1;i<size;i++)
        {
            if(books[i].countKeywordOccurrences(keyword) > highOccuBook.countKeywordOccurrences(keyword))
            {
                highOccuBook = books[i];
            }
        }

        return highOccuBook;
    }
}