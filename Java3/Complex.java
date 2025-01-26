
/**
 * Write a description of class Complex here.
 *
 * @author (23MCCE16)
 * @version (26-01-25)
 */
class Complex
{
    double a;           //Initializing variable a and b to double.
    double b;

    Complex()           //Constructor with no argument assigning 1, 1 to both a and b.
    {          
        a = 1;
        b = 1;
    }

    Complex(double c)           //Constructor with only one double argument assigning value to variable a.
    {          
        a = c;
        b = 0;
    }

    Complex(double a, double d)         //Constructor with only twop (double) argument assigning value to variable a and b.
    {        
        this.a = a;
        b = d;
    }
    
    Complex(Complex c)          //Constructor taking another Complex class object as argument.
    {
        this.a = c.a;
        this.b = c.b;
    }

    Complex addWith(Complex oth)            //Method to add two complex numbers.
    {
        double re;
        double im;
        re = this.a + oth.a;
        im = this.b + oth.b;
        Complex c2 = new Complex(re, im);           //Memory allocating to new obect to return it.

        return c2;
    }
    
    Complex multiplyWith(Complex c1)        //Method to multiply two complex numbers.
    {
        double re;
        double im;
        re = (this.a * c1.a) - (this.b*c1.b);
        im = (this.a*c1.b) + (this.b*c1.a);
        
        Complex c3 = new Complex(re, im);           //Memory allocating to new obect to return it.
        
        return c3;
    }
    
    Complex divisionWith(Complex c1)            //Method to divide two complex numbers.
    {
        double re;
        double im;
        
        c1.negate();
        Complex c4 = multiplyWith(c1);
        
        re = c4.a/((c1.a*c1.a) + (c1.b*c1.b));
        im = c4.b/((c1.b*c1.b) + (c1.b*c1.b));
        
        Complex c5 = new Complex(re, im);           //Memory allocating to new obect to return it.
        
        return c5;
    }

    void display()          //Method to print the expected output.
    {
        if (b > 0)
        {
            System.out.println(a+"+"+b+"i");
        }
        else if(b==0)
        {
            System.out.println(a);
        }
        else
            System.out.println(a+""+b+"i");
    }

    void negate()           //Method to negate the complex number(negation).
    {
        this.b = -this.b;
    }
}