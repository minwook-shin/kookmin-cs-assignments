#include<iostream>

using namespace std;

int main()
{
    int var;
    var = 97;

    char *ptr;
    ptr = (char *)&var;

    cout << *ptr << endl;
    cout << ptr << endl;
    cout << (void *)ptr << endl;

    return 0;
}