import java.util.Enumeration ;
import java.awt.*;

class TablePile extends CardPile
{ // constructors
    public TablePile (int x, int y, int c) 
    {       // initialize the parent class
        super(x, y);
            // then initialize our pile of cards
        for (int i = 0; i < c; i++) 
        {   addCard(Solitaire.deckPile.pop()); }
            // flip topmost card face up
        top().flip();
    }

  // mutators
    public void select (int tx, int ty) 
    {   if (isEmpty())
            return;

            // if face down, then flip
        Card topCard = top();
        if (! topCard.faceUp()) 
        {   topCard.flip();
            return;
        }

            // else see if any suit pile can take card
        topCard = pop();
        for (int i = 0; i < 4; i++)
            if (Solitaire.suitPile[i].canTake(topCard)) 
            {   Solitaire.suitPile[i].addCard(topCard);
                return;
            }

            // else see if any other table pile can take card
        for (int i = 0; i < 7; i++)
            if (Solitaire.tableau[i].canTake(topCard)) 
            {   Solitaire.tableau[i].addCard(topCard);
                return;
            }

            // else put it back on our pile
        addCard(topCard);
    }

  // accessors
    public boolean canTake (Card aCard) 
    {   if (isEmpty())
            return aCard.rank() == 12;
        Card topCard = top();
        return (aCard.color() != topCard.color()) &&
               (aCard.rank() == topCard.rank() - 1);
    }

    public boolean includes (int tx, int ty) 
    {       // don't test bottom of card
        return x <= tx && tx <= x + Card.width && y <= ty; 
    }

    public void display (Graphics g) 
    {   int localy = y;
        for (Enumeration e = thePile.elements(); e.hasMoreElements();) 
        {   Card aCard = (Card) e.nextElement();
            aCard.draw (g, x, localy);
            localy += 35;
        }
    }
}