public class SimpleList<T>
    {
        Node _first;
        Node _last;
        int _size;

        public SimpleList()
        {
            _size = 0;
            _first = null;
            _last = null;
        }

        public void Add(T item)
        {
            if (item == null)
                throw new NullPointerException();

            if (_first == null)
            {
                _first = new Node(item);
                _last = _first;
            }
            else
            {
                _last._next = new Node(item);
                _last = _last._next;
            }
            _size++;
        }

        public T GetAt(int index) throws Exception {
            if (index < 0 || index >= _size)
                throw new Exception("Index must be in range");

            Node next = _first;
            for (int i = 0; i < index; i++)
                next = next._next;

            return next._element;
        }


        protected class Node
        {
            public T _element;
            public Node _next;

            public Node(T element)
            {
                _element = element;
            }
        }
    }