#include <iostream>
static void printMessage();
int main(int argc, char *argv[])
{
    int i = 100;
    std::cout << "i = " << i << std::endl;
    printMessage();
    return 0;
}
void printMessage()
{
    std::cout << "Happy Debugging" << std::endl;
}