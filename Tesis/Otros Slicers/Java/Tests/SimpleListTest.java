

class SimpleListTest{
    public static void Main(){
        var a1 = new A
        {
            b = new B()
        };
        SimpleList<A> list = new SimpleList<A>();
        list.Add(a1);
        var b = list.GetAt(0).b;
    }

    class A
    {
        public B b;
    }

    class B
    {

    }
}