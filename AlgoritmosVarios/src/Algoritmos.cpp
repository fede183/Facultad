#include "include\Algoritmos.h"
#include <iostream>
#include <conio.h>
#include <stdio.h>

void reescrivir(string s){
    cout<<"\b";
    for(int e=0;s.length()>e;e++){
        cout<<"\b";
    }

    for(int e=0;s.length()>e;e++){
        cout<<s.at(e);
    }

    cout<<" ";
}
