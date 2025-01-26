
/**
 * Write a description of class UseComplex here.
 *
 * @author (23MCCE16)
 * @version (26-01-25)
 */
class UseComplex{           //Class to use Complex class.
    static Complex retGreater(Complex m, Complex n)             //Method to return which is greater of the complex number.
    {
        if (m.a >= n.a && m.b >= n.b)
        {
            return m;
        }
        else if (n.a >= m.a && n.b >= m.b)
            return n;
        else
            return null;
    }
    
    public static void main(String[] args)
    {
        Complex c1 = new Complex();
        c1.display();
        
        Complex c2 = new Complex(4,5);
        c2.display();
        
        Complex c3 = new Complex(c1);       
        c3.display();
        
        Complex c4 = c1.addWith(c2);            //To Add c1 with c2 and save it into c4 and display it.
        c4.negate();
        c4.display();
        
        Complex c5 = c1.multiplyWith(c2);           //To multiply c1 with c2 and save it into c5 and display it.
        c5.display();
        
        Complex c6 = c1.divisionWith(c2);           //To divide c1 with c2 and save in into c6 and display it.
        c6.display();
        
    }
}