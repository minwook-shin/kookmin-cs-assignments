#include<vector>
#include<string>

class PropVar
{
    public:
    PropVar(const std::string &name):name(name){
    }
    public:
    std::string name;
    std::vector<bool> rows;
};