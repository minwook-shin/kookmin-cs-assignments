#include <iostream>
#include <fstream>
#include <cstdlib>
#define SIZE 100

using namespace std;

int main()
{
    ifstream file;
    ifstream file2;
    int numcase, num, tmp, tmp2, tmp3, trash;
    int count = 0;

    file.open("input.txt");
    file2.open("input.txt");

    file >> numcase;
    file2 >> trash;

    for (int i = 0; i < numcase; i++)
    {
        int max = 0;
        int max2 = 0;
        file >> num;
        file >> tmp;
        file2 >> trash;
        // file2 >> trash;

        max = tmp;
        for (int j = 1; j < num; j++)
        {
            file >> tmp2;
            if (max < tmp2)
                max = tmp2;
        }
        // cout << max <<endl;

        for (int j = 0; j < num; j++)
        {
            file2 >> tmp3;
            // cout << tmp3<<endl;
            if (max2 < tmp3 && max != tmp3)
            {
                max2 = tmp3;
            }
            
        }
        cout << max2 << endl;
    }
    file.close();
    file2.close();
    return 0;
}