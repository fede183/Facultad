using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tests.Util;

namespace Tests.Cases
{
    class ExternalListInheritanceTest
    {
        public static void Main()
        {
            new OneListItem<List<WithVoidClass>, WithVoidClass>().AddOneElement();
        }
    }
}
