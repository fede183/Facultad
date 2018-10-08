using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tests.Util;

namespace Tests.Cases
{
    class SimpleListCycleTest
    {

        static void Main()
        {
            SimpleList<A> list = new SimpleList<A>();
            for (var i = 0; i < 4; i++)
            {   
                list.Add(new A
                {
                    b = new B()
                });
            }
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
   
}
