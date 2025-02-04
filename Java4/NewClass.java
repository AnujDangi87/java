public class NewClass {
    static Stack st = new Stack(5);

    static void modifiyStack(){
        st.top = 2;
        System.out.println(st.top);
    }

    public static void main(String[] args)
    {
        NewClass.modifiyStack();
        UseStack.main(new String[]{});
    }
    
}
