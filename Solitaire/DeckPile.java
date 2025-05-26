import java.util.Random ;

class DeckPile extends CardPile 
{
  //  constructors
    public DeckPile (int x, int y) 
    {       // first initialize parent
        super(x, y);
            // then create the new deck
            // first put them into a local pile
        for (int i = 0; i < 4; i++)
            for (int j = 0; j <= 12; j++) 
                addCard(new Card(i, j));

            // then shuffle the cards
        Random generator = new Random();
        for (int i = 0; i < 52; i++) 
        {   int j = Math.abs(generator.nextInt() % 52);
                // swap the two card values
            Object temp = thePile.elementAt(i);
            thePile.setElementAt(thePile.elementAt(j), i);
            thePile.setElementAt(temp, j);
        }
    }

  // mutators
    public void select(int tx, int ty) 
    {   if (isEmpty()) 
            return;
        Solitaire.discardPile.addCard(pop());
    }
}