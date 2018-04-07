#include <iostream>
using namespace std;
int main()
{
    int a[] = {1, 2, 3, 4, 5};
    int *ptr = a;

    int *pi = new int;

    cout << "&a[0] = " << &a[0] << endl;
    cout << "&a[1] = " << &a[1] << endl;
    cout << "&a[2] = " << &a[2] << endl;
    cout << "&a[3] = " << &a[2] << endl;
    cout << "&a[4] = " << &a[2] << endl;
    cout << "a = " << a << endl;

    delete pi;
    
    return 0;
}