// MyString.cpp
#include "MyString.h"

MyString::MyString()
{ // memory에 저장장소를 할당받고 NULL String 저장
  memory = new char[1];
  *memory = '\0';
}

MyString::MyString(const char str[])
{
  int count = 0;
  while (str[count] != '\0')
    count++;

  memory = new char[count + 1];

  int idx = 0;
  while (str[idx] != '\0')
  {
    memory[idx] = str[idx];
    idx++;
  }

  memory[idx] = '\0';
}

MyString::MyString(MyString &s)
{ // 깊은 복사로 구현
  int str_size = 0;
  while (s.memory[str_size] != '\0')
    str_size++;

  memory = new char[str_size + 1];
  for (int i = 0; i < str_size; i++)
    memory[i] = s.memory[i];

  memory[str_size] = '\0';
}

MyString::~MyString() { delete[] memory; } // 소멸자

int MyString::size() const
{ // 저장된 문자열 길이를 반환
  int count = 0;
  while (memory[count] != '\0')
    count++;
  return count;
}

MyString &MyString::operator=(const MyString &s)
{ // 깊은 복사로 구현
  if (&s == this)
    return *this;
  int length = s.size();

  delete[] memory;
  memory = new char[length + 1];

  for (int i = 0; i < length; i++)
    memory[i] = s.memory[i];

  memory[length] = '\0';

  return *this;
}

MyString MyString::operator+(const MyString &s)
{
  char *tmp = new char[size() + s.size() + 1];
  int i;
  for (i = 0; i < size(); i++)
  {
    tmp[i] = memory[i];
  }

  int j;
  for (j = 0; j < s.size(); j++)
  {
    tmp[i] = s.memory[j];
    i++;
  }
  tmp[i] = '\0';

  MyString r(tmp);
  delete[] tmp;
  return r;
}

char &MyString::operator[](int i)
{
  if (0 <= i && i < size())
  {
    return memory[i];
  }
}

ostream &operator<<(ostream &os, const MyString &s)
{

  for (int i = 0; i < s.size(); i++)
  {
    os << s.memory[i] << " ";
  }
  os <<endl;
  return os;
}

bool operator==(const MyString &v1, const MyString &v2)
{

  int i = 0;
  while (v1.memory[i] != 0 ||  v2.memory[i] != 0)
  {
    if (v1.memory[i] != v2.memory[i])
    {
      return false;
    }
    i++;
  }
  return true;
}

bool operator!=(const MyString &v1, const MyString &v2)
{

  int i = 0;
  while (v1.memory[i] != 0 ||  v2.memory[i] != 0)
  {
    if (v1.memory[i] != v2.memory[i])
    {
      return true;
    }
    i++;
  }
  return false;
}