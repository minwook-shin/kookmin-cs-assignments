// MyString3 - 신민욱

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
        memory = new char[i + 1];

        int j;
        for (j = 0; str[j] != 0; j++)
        {
            memory[j] = str[j];
        }
        memory[j + 1] = '\0';
    }

    MyString(MyString &s)
    {
        int i = 0;
        while (s.memory[i] != 0)
        {
            i++;
        }
        memory = new char[i+1];

        int i2;
        for (i2 = 0; s.memory[i2] != 0; i2++)
        {
            memory[i2] = s.memory[i2];
        }
        memory[i2] = '\0';
        
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
        memory = new char[idx + 1];

        int i;
        for (i = 0; s[i] != 0; i++)
        {
            memory[i] = s[i];
        }
        memory[i] = '\0';
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
        temp[idx + idx2] = '\0';

        delete[] memory;
        memory = temp;
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
        }
        if (memory[i])
            return 1;

        if (s[i])
            return -1;

        return 0;
    }
};

int main()
{
    MyString a("program");
    MyString b(a);
    int compare;

    cout << b.size() << endl;
    // a.cpy("program");
    cout << b.size() << endl;
    b.cat("ming");

    int i = 0;
    while (b.memory[i] != 0)
    {
        cout << b.memory[i];
        i++;
    };
    cout << endl;

    cout << b.size() << endl;
    compare = b.cmp("debuging");
    cout << compare << endl;
    return 0;
}