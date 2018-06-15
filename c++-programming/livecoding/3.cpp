#include <iostream>
#include <fstream>
#include <cstdlib>

using namespace std;

int main()
{
    ifstream file;

    int numcase, a, b;

    file.open("input.txt");

    file >> numcase;

    for (int i = 0; i < numcase; i++)
    {
        int b2 = 0;
        int b3 = 0;
        int count = -1;
        int count2 = -1;
        int a3 = 0;
        int score;
        int score2;
        file >> a;
        file >> b;

        for (int a2 = 0; a2 <= a; a2 += 16)
        {
            count++;
            a3 = a2;
        }
        score = (count * 2) + (a - a3);
        // cout << score << endl;

        for (int b2 = 0; b2 <= b; b2 += 16)
        {
            count2++;
            b3 = b2;
        }
        score2 = (count2 * 2) + (b - b3);
        // cout << score2 << endl;

        if (score > score2)
        {
            cout<< score <<endl;
        }
        else
        {
            cout << score2<<endl;
        }
    }
    file.close();
    return 0;
}