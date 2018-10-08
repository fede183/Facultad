using System.Collections;

public class Hashtable
{
	private HashEntry[] array;
	private int size;

	public Hashtable(int sz)
	{
		size = sz;
        array = new HashEntry[size];
		for (int i = 0; i < size; i++)
			array[i] = null;
	}

	private int hashMap(object key)
	{
		return ((key.GetHashCode() >> 3) % size);
	}

	public object get(object key)
	{
		int j = hashMap(key);

		HashEntry ent = null;

        for (ent = array[j]; ent != null && ent.key() != key; ent = ent.next());

		if (ent != null)
			return ent.entry();

        return null;
	}

	public void put(object key, object value)
	{
		int j = hashMap(key);
		HashEntry ent = new HashEntry(key, value, array[j]);
		array[j] = ent;
	}

	public void remove(object key)
	{
		int j = hashMap(key);
		HashEntry ent = array[j];
		if (ent != null && ent.key() == key)
			array[j] = ent.next();
		else
		{
			HashEntry prev = ent;
            for (ent = ent.next(); ent != null && ent.key() != key; prev = ent, ent = ent.next());
			prev.Next = ent.next();
		}
	}
}

class HashEntry
{
    private object _key;
    private object _entry;
    private HashEntry _next;

    public HashEntry(object key, object entry, HashEntry next)
    {
        _key = key;
        _entry = entry;
        _next = next;
    }

    public object key()
    {
        return _key;
    }

    public object entry()
    {
        return _entry;
    }

    public HashEntry next()
    {
        return _next;
    }

    public HashEntry Next
    {
        set { _next = value; }
    }
}
