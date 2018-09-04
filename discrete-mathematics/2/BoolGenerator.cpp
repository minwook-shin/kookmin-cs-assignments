#include<fstream>
#include<vector>
#include"PropVar.cpp"
#include <iomanip>

using namespace std;

class BoolGenerator
{
    public:
    BoolGenerator &AddVarProp(const std::string &name){
        props.push_back(name);
        return *this;
    }
    public:
    void Build(){
        
        if (props.empty()) {
            throw exception();
        }
        
        const int len = 1 << props.size();
        auto iter = props.begin();
        for(int pos = len/2; pos>0;pos = pos/2, ++iter)
        {
            auto &prop = *iter;
            for(int idx = 0; idx < len; ++idx)
            {
                prop.rows.push_back(Generate(idx / pos));
            }
            
        }
        
    }
    public:
    bool Generate(const int num){
        return num % 2 == 0;
    }
    std::vector<PropVar> props;

    inline friend std::ostream &operator<<(std::ostream &os, const BoolGenerator &gen){
        for(auto prop : gen.props){
            os  << setw(6) << prop.name << "";
        }
        os << std::endl;
        const int rows = int(gen.props[0].rows.size());
        const int cols = int(gen.props.size());
        
        for(int row = 0; row < rows; ++row)
        {
            
            for(int col = 0; col < cols; ++col)
            {
                os << std::setw(7) << std::boolalpha << gen.props[col].rows[row];
            }
            os<<std::endl;
            
        }
        return os;
        
    }
    
    public:
    PropVar operator[](const int index){
        return props[index];
    }
    
    public:
    std::vector<PropVar> GetPropVars(){
        return props;
    }
};