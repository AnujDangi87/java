class test2 extends test1
{
    int a;
    test2()
    {
        this.a = 1;
    }

    void sum()
    {
        super.sum();
        System.out.println("this is test2 sum is : "+(a+b));
    }
}