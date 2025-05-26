import java.awt.*;
import java.util.Stack;
import java.util.EmptyStackException;

public class CardPile 
{       
  // constructors
    public CardPile (int xl, int yl) 
    { x = xl; y = yl; thePile = new Stack(); }

  // mutators
    public final Card pop() 
    {   try { return (Card) thePile.pop(); }
        catch (EmptyStackException e) { return null; }
    }

    public void addCard (Card aCard)  // sometimes overridden
    { thePile.push(aCard); }

    public void select (int tx, int ty)  // sometimes overridden
    {   /* do nothing */ }

  // accessors
    public final Card top() 
    { return (Card) thePile.peek(); }

    public final boolean isEmpty() 
    { return thePile.empty(); }

    public boolean includes (int tx, int ty) // sometimes overridden
    {   return x <= tx && tx <= x + Card.width &&
            y <= ty && ty <= y + Card.height;
    }
    
    public boolean canTake (Card aCard)  // sometimes overridden
    { return false; }

    public void display (Graphics g)  // sometimes overridden
    {   g.setColor(Color.blue);
        if (isEmpty())
            g.drawRect(x, y, Card.width, Card.height);
        else
            top().draw(g, x, y);
    }

// protected data fields
    protected int x;          // coordinates of the card pile
    protected int y;          //     (x,y) is upper left corner
    protected Stack thePile;  // cards in the pile
}