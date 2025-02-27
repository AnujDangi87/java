public class B extends A
{
    int a;
    public int b;
    //Constructor B can't access variable c because it is private.
    //Its also overriding the Constructor A
    public B()
    {
        super(100);
        a = 10;
        System.out.println("a of class B : " + this.a);
        System.out.println("a of class A : "+super.a);
        this.b = 11;

        System.out.println("This is class B constructor.overriding a and b variable");
    }

    public void sumB(int y)
    {
        System.out.println("sum in B class : "+(a+b+d+y));
    }

    //Overriding the sub method form parent class A and using current a and b values
    public void sub()
    {
        System.out.println("sub in B class is : "+ (d-b));
    }
}
