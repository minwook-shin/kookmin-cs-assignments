#include<iostream>

using namespace std;

int main()
{
    double x;
    // x = (1.0e20 + 5.0)-1.0e20;
    x = 1.0e20 - 1.0e20 + 5.0;
    cout<<x<<endl;
    return 0;
}