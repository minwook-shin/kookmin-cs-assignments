#include<fstream>
#include"BoolGenerator.cpp"
#include<iostream>
#include <bits/stdc++.h>
#include<algorithm>
#include<cctype>

using namespace std;

enum class PVAR{
    P,Q,R
};

class OpAnd{
    public:
    bool operator()(bool val1, bool val2){
        return val1 && val2;
    }
};

void PrintEval(BoolGenerator &gen, PropVar &var)
{
    std::vector<PropVar> pvars = gen.GetPropVars();
    for (auto prop : pvars){
        std::cout<< std::setw(6) << prop.name << " ";
    }
    
    std::cout << "\t" << var.name << std::endl;
    const int rows = int(pvars[0].rows.size());
    const int cols = int(pvars.size());
    for (int row = 0; row < rows; ++row)
    {
        for (int col = 0; col < cols; ++col)
        {
            std::cout << std::setw(7) << std::boolalpha << gen[col].rows[row];
        }
        std::cout << "\t" << std::setw(var.name.size()) << var[row];
        std::cout << std::endl;
    }
}

int main(int argc, char *argv[])
{
    std::ofstream output;
    try
    {
        BoolGenerator gen;
        gen.AddVarProp("P").AddVarProp("Q").AddVarProp("R").Build();
        // Get propositional Variables
        PropVar p = gen[int(PVAR::P)];
        PropVar q = gen[int(PVAR::Q)];
        PropVar r = gen[int(PVAR::R)];
        // Negation
        PropVar rNot(" Not P", p.rows);
        // Evaluate using std::transform
        PrintEval(gen, rNot);
        std::cout << std::endl;

        // Conjunction
        PropVar rAnd("P and Q", q.rows);
        std::transform(p.rows.begin(),p.rows.end(),rAnd.rows.begin(),rAnd.rows.begin(),OpAnd());
        // Evaluate using std::transform
        PrintEval(gen, rAnd);
        std::cout << std::endl;

        // Disjunction
        PropVar rOr("P or Q", q.rows);
        // Evaluate using std::transform
        PrintEval(gen, rOr);
        std::cout << std::endl;
        // Exclusive Disjunction
        PropVar rXor("P xor Q", q.rows);
        // Evaluate using std::transform
        PrintEval(gen, rXor);
        std::cout << std::endl;
        // Evauate on Compound Proposition "((P or Q) and R)"
        PropVar rEval("(P or Q) and R", r.rows);
        // Evaluate using std::transform
        PrintEval(gen, rEval);
        std::cout << std::endl;

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


