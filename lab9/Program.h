#include <vector>
#include "Statement.h"

template<class Statement, class Env>
class Program {
private:
    std::vector<Statement> statements;

public:

    Program() {}

    Program& operator<<(const Statement& statement) {
        statements.push_back(statement);
        return *this;
    }


    Program& operator>>(const Statement& statement) {
        statements.insert(statements.begin(), statement);
        return *this;
    }

    void operator()(Env& env) {
        for (auto& statement : statements) {
            int nextCommand = statement(env);
            if (nextCommand == -1) {
                break;
            }
        }
    }

    Program operator+(const Program& other) const {
        Program result = *this;
        for (const auto& statement : other.statements) {
            result << statement;
        }
        return result;
    }

    bool operator==(const Program& other) const {
        return statements == other.statements;
    }

    bool operator!=(const Program& other) const {
        return !(*this == other);
    }
};
