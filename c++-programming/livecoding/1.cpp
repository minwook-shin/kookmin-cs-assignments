#include <iostream>
#include <fstream>
#include <cstdlib>
#define SIZE 100

using namespace std;

int main()
{
    ifstream file;
    int numcase, num, find, tmp;
    int count = 0;

    int arr[SIZE];

    file.open("input.txt");

    file >> numcase;

    for (int i = 0; i < numcase; i++)
    {
        int count = 0;
        file >> num;
        file >> find;
        for (int j = 0; j < num; j++)
        {
            file >> tmp;
            if (find == tmp)
            {
                count++;
            }
            // cout << j  << " "<< tmp <<endl;
        }
        cout << count << endl;
    }

    return 0;
}