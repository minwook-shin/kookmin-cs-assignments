#include<vector>
#include<string>

class PropVar
{
    public:
    PropVar(const std::string &name):name(name){
    }
    public:
    PropVar(const std::string &name, std::vector<bool> rows){
        this->name = name;
        
        for(int i = 0; i < rows.size(); i++)
        {
           this->rows.push_back(rows[i]);
        }
        
    }
    public:
    bool operator[](const int index){
        return rows[index];
    }
    public:
    std::string name;
    std::vector<bool> rows;
};