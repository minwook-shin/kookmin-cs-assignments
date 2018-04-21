//20171640 신민욱

#include <iostream>
using namespace std;

class MyString
{
  public:
    char *memory;

    MyString()
    {
        memory = new char[1];
        memory[0] = '\0';
    }

    MyString(const char *str)
    {
        int i = 0;
        while (str[i] != 0)
        {
            i++;
        };
        memory = new char[i+1];

        int j;
        for (j = 0; str[j] != 0; j++)
        {
            memory[j] = str[j];
        }
        memory[j + 1] = '\0';
    }

    ~MyString()
    {
        delete[] memory;
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
        delete[] memory;

        int idx = 0;
        while (s[idx] != 0)
        {
            idx++;
        };
        char *memory = new char[idx + 1];

        int i;
        for (i = 0; s[i] != 0; i++)
        {
            memory[i] = s[i];
        }
        memory[i + 1] = '\0';
    }
    void cat(const char *s)
    {
        int idx = 0;
        while (memory[idx] != 0)
        {
            idx++;
        }

        int idx2 = 0;
        while (s[idx2] != 0)
        {
            idx2++;
        }

        char *temp = new char[idx + idx2 + 1];

        int i;
        for (i = 0; memory[i] != 0; i++)
        {
            temp[i] = memory[i];
        }

        int i2;
        for (i2 = 0; s[i2] != 0; i2++)
        {
            temp[i] = s[i2];
            i++;
        }
        temp[idx + idx2 + 1] = '\0';

        delete[] memory;
        char *memory = new char[idx + idx2 + 1];

        int i3;
        for (i3 = 0; temp[i3] != 0; i3++)
        {
            memory[i3] = temp[i3];
        }

        memory[i3 + 1] = '\0';

        delete[] temp;
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
    MyString a("pri");
    int compare;

    cout << a.size() << endl;
    a.cpy("program");
    cout << a.size() << endl;
    a.cat("ming");

    int i = 0;
    while (a.memory[i] != 0)
    {
        cout << a.memory[i];
        i++;
    };
    cout << endl;

    cout << a.size() << endl;
    compare = a.cmp("debuging");
    cout << compare << endl;
    return 0;
}