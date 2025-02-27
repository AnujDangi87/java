public class A
{
    int a;
    public int b;
    private int c;
    protected int d;
    static int s;

    public A()
    {
        a = 0;
        b = 1;
        c = 2;
        d = 3;
        s = 100;

        System.out.println("This is class A constructor zero argument constructor.");
    }

    public A(int a){
        this.a = a;
        b = 1;
        c = 2;
        d = 3;
        s = 100;

        System.out.println("This is class A only one argument constructor.");
    }

    public void sum(int e)
    {
        System.out.println("Sum is : " + (a+b+c+d+e));
    }

    public void sub()
    {
        System.out.println("sub in A is : "+(d-b));
    }

    public void setC(int c)
    {
        this.c = c;
    }

    public int getC()
    {
        return this.c;
    }
}