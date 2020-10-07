#include<cstring>
#include<vector>
#include<cassert>

using namespace std;

class Ejercicio{
public:

    int solve(int L, vector<int> cortes)
    {

    }
};

class Test{
public:
    void test0()
    {
        Ejercicio e;
        vector<int> cortes{2,5,10};
        assert(e.solve(20,cortes) == 35);
    }
    void test1()
    {
        Ejercicio e;
        vector<int> cortes{2,3,5,7,11,13,17,19};
        assert(e.solve(23,cortes) == 72);
    }
    void test2()
    {
        Ejercicio e;
        vector<int> cortes{1,2,4,8,16,32,64};
        assert(e.solve(128,cortes) == 254);
    }
    void test3()
    {
        Ejercicio e;
        vector<int> cortes{1,2,3,5,8,13,21,34,55,89};
        assert(e.solve(144,cortes) == 374);
    }
    void test4()
    {
        Ejercicio e;
        vector<int> cortes{5,14,23,32,41};
        assert(e.solve(50,cortes) == 132);
    }
    void test5()
    {
        Ejercicio e;
        vector<int> cortes;
        for(int i=1;i<1000;i++)
        {
            if(i%60 == 3 ||
               i%60 == 14 ||
               i%60 == 23 ||
               i%60 == 31 ||
               i%60 == 42 ||
               i%60 == 55)
                cortes.push_back(i);
        }
        assert(e.solve(1000,cortes) == 6677);
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
    t.test5();
}
