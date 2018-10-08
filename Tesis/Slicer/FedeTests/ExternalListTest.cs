using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tests.Util;

namespace Tests.Cases
{
    class ExternalListTest
    {

        static void Main()
        {
            var a1 = new A
            {
                b = new B()
            };
            List<A> list = new List<A>();
            list.Add(a1);
            var b = list[0].b;
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
