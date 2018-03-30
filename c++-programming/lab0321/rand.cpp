#include <iostream>
#include <cstdlib>

#define SIZE 1000
#define TESTSIZE 100

using namespace std;

int main()
{
    srand(time(0));

    int list[SIZE] = {};
    int test[SIZE] = {};

    for (int i = 0; i < SIZE; i++)
    {
        list[i] = (rand() % 201 - 100);
    }

    for (int i = 0; i < SIZE; i++)
    {
        cout << " " << list[i];
    }

    return 0;
}