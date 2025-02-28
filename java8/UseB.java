public class UseB
{
    public static void main(String[] args)
    {
        B b = new B();

        b.sum(0);
        b.a = 3;        //default
        b.b = 1;        //public
        b.d = 8;        //protected
        B.s = 12;       //staic
        System.out.println("staic variable s : " + B.s);
        b.sum(0);
        b.sumB(0);
        b.sub();

        A a = new A();
        a.sub();
        System.out.println("staic variable class A s : "+A.s);
    }
}