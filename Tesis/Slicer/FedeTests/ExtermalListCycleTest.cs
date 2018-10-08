using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tests.Util;

namespace Tests.Cases
{
    class ExtermalListCycleTest
    {

        static void Main()
        {
            List<A> list = new List<A>();
            for (var i = 0; i < 4; i++)
            {   
                list.Add(new A
                {
                    b = new B()
                });
            }
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
