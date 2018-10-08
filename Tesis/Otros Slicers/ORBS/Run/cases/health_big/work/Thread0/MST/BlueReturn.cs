using System;

class BlueReturn
{
    private MSTVertex _vert;
    private int _dist;

    public MSTVertex vert()
    {
        return _vert;
    }

    public MSTVertex Vert
    {
        set { _vert = value; }
    }

    public int dist()
    {
        return _dist;
    }

    public int Dist
    {
        set { _dist = value; }
    }
}
