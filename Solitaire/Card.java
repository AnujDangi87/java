import java.awt.*;

public class Card 
{ 
    // internal data fields
    private boolean faceup;  // card face exposed?
    private int r;           // card rank
    private int s;           // card suit
    
  // public constants for card dimensions
    public final static int width = 50;
    public final static int height = 70;

  // public constants for card suits
    public final static int heart = 0;
    public final static int spade = 1;
    public final static int diamond = 2;
    public final static int club = 3;

  // constructors
    public Card (int sv, int rv) 
    { s = sv; r = rv; faceup = false; }

  // mutators 
    public final void flip() { faceup = ! faceup; }

  // accessors
    public final int rank () { return r; }

    public final int suit() { return s; }

    public final boolean faceUp() { return faceup; }

    public final Color color() 
    {   if (faceUp())
            if (suit() == heart || suit() == diamond)
                return Color.red;
            else
                return Color.black;
        return Color.yellow;
    }

    public void draw (Graphics g, int x, int y) 
    {
           String names[] = {"A", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "J", "Q", "K"};
            // clear rectangle, draw border
        g.clearRect(x, y, width, height);
        g.setColor(Color.blue);
        g.drawRect(x, y, width, height);
            // draw body of card
        g.setColor(color());
        if (faceUp()) 
        {   g.drawString(names[rank()], x+3, y+15);
            if (suit() == heart) 
            {   g.drawLine(x+25, y+30, x+35, y+20);
                g.drawLine(x+35, y+20, x+45, y+30);
                g.drawLine(x+45, y+30, x+25, y+60);
                g.drawLine(x+25, y+60, x+5, y+30);
                g.drawLine(x+5, y+30, x+15, y+20);
                g.drawLine(x+15, y+20, x+25, y+30);
            }
            else if (suit() == spade) 
            {   g.drawLine(x+25, y+20, x+40, y+50);
                g.drawLine(x+40, y+50, x+10, y+50);
                g.drawLine(x+10, y+50, x+25, y+20);
                g.drawLine(x+23, y+45, x+20, y+60);
                g.drawLine(x+20, y+60, x+30, y+60);
                g.drawLine(x+30, y+60, x+27, y+45); 
            }
            else if (suit() == diamond) 
            {   g.drawLine(x+25, y+20, x+40, y+40);
                g.drawLine(x+40, y+40, x+25, y+60);
                g.drawLine(x+25, y+60, x+10, y+40);
                g.drawLine(x+10, y+40, x+25, y+20);
            }
            else if (suit() == club) 
            {   g.drawOval(x+20, y+25, 10, 10);
                g.drawOval(x+25, y+35, 10, 10);
                g.drawOval(x+15, y+35, 10, 10);
                g.drawLine(x+23, y+45, x+20, y+55);
                g.drawLine(x+20, y+55, x+30, y+55);
                g.drawLine(x+30, y+55, x+27, y+45); 
            }
        }
        else 
        {       // face down
            g.drawLine(x+15, y+5, x+15, y+65);
            g.drawLine(x+35, y+5, x+35, y+65);
            g.drawLine(x+5, y+20, x+45, y+20);
            g.drawLine(x+5, y+35, x+45, y+35);
            g.drawLine(x+5, y+50, x+45, y+50);
        }

    }

  
}