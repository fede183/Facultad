using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tests.Cases
{
    class OneListItem<T, C> where T : class, IList<C>, new() where C : WithVoidClass, new()
    {
        public void AddOneElement()
        {
            var c1 = new C
            {
                voidClass = new VoidClass()
            };
            T list = new T();
            list.Add(c1);
            var b = list.First().voidClass;
        }    
    }
   
}
