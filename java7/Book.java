import java.util.Arrays;

public class Book 
{
    String bookName;            //Instance String variable to store book name.
    String author;              //Instance String variable to store author name.
    Page []pages;               //Instance Page variable to store pages in book.
    int pageCount;              //Instance variable to store no of pages in book.

    //Constructor to set Bookname and author to given argument book name and author and also allocating memory to one page.
    Book(String bookName, String author)
    {
        this.bookName = bookName;
        this.author = author;

        pages = new Page[1];
    }

    //Method to add page to the array pages by taking external page as argument.
    public void addPageText(String text)
    {
        pages[pageCount++] = new Page(text);

        pages = Arrays.copyOf(pages, pages.length+1);               //Increasing the size of array by 1.
    }

    //Method to total no of occurrence of a argument taken keyword in book.
    public int countKeywordOccurrences(String keyword)
    {
        int count = 0;

        for(int i=0;i<pageCount;i++)
        {
            count += pages[i].countKeywordOccurrences(keyword);
        }

        return count;
    }

    private class Page {
        private String text;            //Instance String variable text to store text of the page.
    
        //Constructor to set the variable String text to the argument text.
        Page(String text)
        {
            this.text = text;
        }
        
        //Method that returns the no of occcurrences of String keyword in text.
        public int countKeywordOccurrences(String keyword)
        {
            int count = 0;
    
            String []str = text.trim().split(" ");          //First removing starting and trailing spaces using trim() function and then using split() to create a String array for each word.
    
            for(int i=0;i<str.length;i++)           //Checking if keyword matches with String word in text and then increasing count by 1.
            {
                if(str[i].equalsIgnoreCase(keyword))
                {
                    count++;
                }
            }
    
            return count;
        }
    }
    
}

