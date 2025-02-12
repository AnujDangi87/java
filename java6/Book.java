import java.util.Arrays;

public class Book 
{
    String bookName;
    String author;
    Page []pages;
    int pageCount;

    Book(String bookName, String author)
    {
        this.bookName = bookName;
        this.author = author;

        pages = new Page[1];
    }

    public void addPage(Page page)
    {
        pages[pageCount++] = page;

        pages = Arrays.copyOf(pages, pages.length+2);
    }

    public int countKeywordOccurrences(String keyword)
    {
        int count = 0;

        for(int i=0;i<pageCount;i++)
        {
            count += pages[i].countKeywordOccurrences(keyword);
        }

        return count;
    }
}
