//20171640 신민욱

#include <iostream>
using namespace std;

class MyString
{
  public:
    char memory[80];

    MyString()
    {
        memory[0] = '\0';
    }

    int size()
    {
        int i = 0;
        while (memory[i] != 0)
        {
            i++;
        };
        return i;
    }

    void cpy(const char *s)
    {
        int i;
        for (i = 0; s[i] != 0; i++)
        {
            if (i == 79)
            {
                break;
            }
            memory[i] = s[i];
        }
        memory[i + 1] = '\0';
    }
    void cat(const char *s)
    {
        int val = 0;
        while (memory[val] != 0)
        {
            val++;
        };
        int i;
        for (i = 0; s[i] != 0; i++)
        {
            if (val == 79)
            {
                break;
            }
            memory[val] = s[i];
            val++;
        }
        memory[val + i + 1] = '\0';
    }
    int cmp(const char *s)
    {
        int i = 0;
        while (memory[i] != 0 || s[i] != 0)
        {
            if (memory[i] < s[i])
            {
                return -1;
            }
            if (memory[i] > s[i])
            {
                return 1;
            }
            if (memory[i] == s[i])
            {
                i++;
            }
            else
            {
                return 0;
            }
        }
    }
};

int main()
{
    MyString a;
    int compare;

    cout << a.size() << endl;
    a.cpy("program");
    // cout << a.size() << endl;
    a.cat("ming");

    // int i = 0;
    // while (a.memory[i] != 0)
    // {
    //     cout << a.memory[i];
    //     i++;
    // };
    // cout << endl;

    // cout << a.size() << endl;
    compare = a.cmp("debuging");
    // cout << compare << endl;
    return 0;
}