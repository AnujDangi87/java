public class UseB
{
    public static void main(String[] args)
    {
        B b = new B();

        b.a = 3;
        b.b = 1;
        b.d = 8;
        b.sum(0);
        b.sumB(0);
        b.sub();

        A a = new A();
        a.sub();
    }
}