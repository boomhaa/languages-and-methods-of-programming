#include "Env.h"
#include <iostream>

class Statement {
private:
    std::string id;
    std::string type;
public:
    Statement(const std::string& identifier, const std::string& type) : id(identifier), type(type) {}
    int operator()(Env& env) {
        int newData = env.getData();
        if (type == "plus") {
            newData++;
        } else if(type == "minus") {
            newData--;
        }else if(type == "divide") {
            newData/=2;
        }else if(type == "product") {
            newData*=2;
        }else {
            return -1;
        }
        env.setData(newData);
        if (newData > 100) {
            return -1;
        }
        std::cout << "Data: " << newData << std::endl;
        return 0;
    }
    bool operator==(const Statement& other) const {
        return id == other.id;
    }

};