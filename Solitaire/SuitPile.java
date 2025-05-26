class SuitPile extends CardPile 
{
  // constructors
    public SuitPile (int x, int y) { super(x, y); }

  // accessors
    public boolean canTake (Card aCard)  // overrides parent
    {   if (isEmpty())
            return aCard.rank() == 0;
        Card topCard = top();
        return (aCard.suit() == topCard.suit()) &&
            (aCard.rank() == 1 + topCard.rank());
    }
}