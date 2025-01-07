
class FirstProgram{

    static int []arr = new int[10];

    static int sum(int a, int b)
    {
        return a+b;
    }
    public static void main(String[] args)
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(arr[i]);
            System.out.println(sum(i, i+1));
        }
    }
}