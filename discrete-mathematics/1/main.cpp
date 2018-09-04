#include<fstream>
#include"BoolGenerator.cpp"
#include<iostream>

using namespace std;

int main(int argc, char *argv[])
{
    std::ofstream output;
    try
    {
        BoolGenerator gen;
        gen.AddVarProp("P")
        .AddVarProp("Q")
        .AddVarProp("S")
        .Build();
        std::cout << gen << std::endl;

        output.exceptions(std::ofstream::failbit|std::ofstream::badbit);
        output.open("TruthTable.out");
        output << gen;
        output.close();
    }
    catch (const std::exception &ex)
    {
        output.close();
        std::cerr << ex.what() << std::endl;
    }
    return 0;
}