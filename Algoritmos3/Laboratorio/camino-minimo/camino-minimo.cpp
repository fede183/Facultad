#include<cstring>
#include<vector>
#include<cassert>
#include<queue>


using namespace std;

struct Red{
    vector<Ciudad> red;
};

struct Ciudad{
    vector<Autopista> vec;
    int id;
};

struct Autopista{
    int ciudad; ///Ciudad a la que va la autopista
    int peaje; ///Costo del peaje de dicha autopista
    Autopista(int c,int p)
    {
        ciudad = c;
        peaje = p;
    }
};

class Ejercicio{
public:
    /**
     * ListaDeAdyacencia contiene en el i-esimo vector
     * las autopistas que salen de la i-esima ciudad.
     * Las autopistas son unidireccionales.
     */
    int solve(Red listaDeAdyacencia, int BuenosAires, int RioCuarto)
    {

    }
};

class Test{
public:
    void test0()
    {
        Ejercicio e;
        vector<vector<Autopista> > vec;
        vec.resize(3);
        vec[0].push_back(Autopista(1,10));
        vec[0].push_back(Autopista(2,10));
        vec[1].push_back(Autopista(2,10));
        assert(e.solve(vec,0,2) == 10);
    }
    void test1()
    {
        Ejercicio e;
        vector<vector<Autopista> > vec;
        vec.resize(9);
        vec[0].push_back(Autopista(1,10));
        vec[0].push_back(Autopista(2,15));
        vec[2].push_back(Autopista(4,15));
        vec[4].push_back(Autopista(6,15));
        vec[6].push_back(Autopista(8,15));
        vec[1].push_back(Autopista(3,10));
        vec[3].push_back(Autopista(5,10));
        vec[5].push_back(Autopista(7,10));
        vec[7].push_back(Autopista(8,10));
        assert(e.solve(vec,0,8) == 50);
    }
    void test2()
    {
        Ejercicio e;
        vector<vector<Autopista> > vec;
        vec.resize(15);
        for(int i=0;i<15;i++)
        for(int j=0;j<15;j++)
        {
            if(((i+j)*(i+j)*(i+j))%17 < 3)
                vec[i].push_back(Autopista(j,10));
            else if(((i+j)*(i+j))%5 == 3)
                vec[i].push_back(Autopista(j,15));
        }
        assert(e.solve(vec,0,3) == 50);

    }
    void test3()
    {
        Ejercicio e;
        vector<vector<Autopista> > vec;
        vec.resize(50);
        for(int i=0;i<50;i++)
        {
            if(i+3 < 50)
                vec[i].push_back(Autopista(i+3,10));
            if(i+4 < 50)
                vec[i].push_back(Autopista(i+4,15));
        }
        assert(e.solve(vec,0,49) == 165);
    }
    void test4()
    {
        Ejercicio e;
        vector<vector<Autopista> > vec;
        vec.resize(10007);
        for(long long i=0;i<10007;i++)
        {
            vec[i].push_back(Autopista(((i+2)*(i+2))%10007,10));
            vec[i].push_back(Autopista(((i+2)*(i+2)*(i+2))%10007,15));
        }
        assert(e.solve(vec,1000,2000) == 175);
    }
};

int main()
{
    Test t;
    t.test0();
    t.test1();
    t.test2();
    t.test3();
    t.test4();
}
