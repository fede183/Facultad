/**
 * A linked list container.
 **/

public class HList 
{
  ListNode head;
  ListNode tail;

  public HList()
  {
    head = null;
    tail = null;
  }

  public void add(Patient p)
  {
    ListNode node = new ListNode(p);
    if (head == null)
      head = node;
    else
      tail.next = node;
    tail = node;
  }

  public void delete(object o)
  {
    if (head == null) 
		return;

    if (tail._object == o) 
      tail = null;

    if (head._object == o) 
    {
      head = head.next;
      return;
    }

    ListNode p = head;
    for (ListNode ln = head.next; ln != null; ln = ln.next) 
    {
        if (ln._object == o) 
        {
	        p.next = ln.next;
	        return;
        }
        p = ln;
    }
  }

  public ListEnumerator elements()
  {
    return new ListEnumerator(this);
  }

  class ListNode
  {
    public ListNode next;
    public object _object;

    public ListNode(object o)
    {
      _object = o;
      next = null;
    }
  }

  public class ListEnumerator
  {
    ListNode curNode;

    public ListEnumerator(HList l) 
    {
      curNode = l.head;
    }

    public object nextElement()
    {
      object o = curNode._object;
      curNode = curNode.next;
      return o;
    }

    public bool hasMoreElements()
    {
      return curNode != null;
    }
  }
}
