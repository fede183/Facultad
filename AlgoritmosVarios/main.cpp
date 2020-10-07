#include <iostream>
#include <stdio.h>
#include "include\Algoritmos.h"
#include <conio.h>
using namespace std;

int main()
{
   char letra1,letra2=' ';
    bool d=true,linea=false;
    string palabra;
    while(d){
        letra1=getch();
        cout<<letra1;
        if(letra1==' '&&letra2!=' '){
            reescrivir(palabra);
        }
        else{
            palabra=palabra+letra1;
        }
        letra2=letra1;
    }
    return 0;
}
