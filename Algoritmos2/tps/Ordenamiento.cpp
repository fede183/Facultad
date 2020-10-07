#include <stdio.h>

unsigned int posicionMin(int A[], int inicio, int fin){
	unsigned int posMin = inicio;
	for(unsigned int i = inicio + 1; i < fin; i++){
		if(A[posMin] > A[i]){
			posMin = i;
		}
	}
	return posMin;
}

void SelectionSort(int A[], int n){
	unsigned int MinPos;
	int Aux;
	for(unsigned int i = 0; i < n; i++){
		MinPos = posicionMin(A, i, n);
		Aux = A[i];
		A[i] = A[MinPos];
		A[MinPos] = Aux;
	}
}

void InsertionSort(int A[], int n){
	int j, elem;
	bool NoEncontre;
	for(unsigned int i = 0; i < n; i++){
		j = i - 1;
		elem = A[i];
		NoEncontre = true;
		while(j >= 0 && NoEncontre){
			if(A[j] > elem){
				A[j + 1] = A[j];
				j--;
			}
			else{
				NoEncontre = false;
			}
		}
		A[j + 1] = elem;
	}
}

void merge(int A[], int inicio, int fin, int medio){
	int i, j, k;
    int tamIzq = medio - inicio + 1;
    int tamDer =  fin - medio;
    int Izquierda[tamIzq], Derecha[tamDer];
    //Copio la parte izquierda y derecha

	for(i = 0; i < tamIzq; i++)
        Izquierda[i] = A[inicio + i];
    for(j = 0; j < tamDer; j++)
        Derecha[j] = A[medio + 1 + j];

    i = 0;
    j = 0;
    k = inicio;
    while (i < tamIzq && j < tamDer){
        if (Izquierda[i] <= Derecha[j]){
            A[k] = Izquierda[i];
            i++;
        }
        else{
            A[k] = Derecha[j];
            j++;
        }
        k++;
    }

    while (i < tamIzq){
        A[k] = Izquierda[i];
        i++;
        k++;
    }

    while (j < tamDer){
        A[k] = Derecha[j];
        j++;
        k++;
    }
} 



void MergeSort(int A[], int fin, int inicio = 0){
	int n = fin - inicio;
	if (n >= 2){
		int mitad = n/2;
		printf("%i\n", mitad);
		MergeSort(A, mitad, inicio);
		MergeSort(A, fin, mitad + 1);
		//merge(A, inicio, fin, mitad);
	}
}



int main(){
	//int res[] = {3,15,1,535,78,32,9,6,865,32};
	int res[] = {3,15,1,535,78};
	MergeSort(res, 5);
	for(unsigned int i = 0; i < 5 ;i++){
		printf("%i\n", res[i]);
	}
	return 0;
}