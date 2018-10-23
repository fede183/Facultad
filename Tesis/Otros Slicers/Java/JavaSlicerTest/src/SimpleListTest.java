

class SimpleListTest{
    public static void main(String[] args) throws Exception {
        A a1 = new A();

        a1.b = new B();

        SimpleList<A> list = new SimpleList<A>();
        list.Add(a1);
        B b = list.GetAt(0).b;
    }

    static class A
    {
        public B b;
    }

    static class B
    {

    }
}