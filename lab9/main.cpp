#include <iostream>
#include "Program.h"

int main() {
    Env env(5);
    Env env2(6);
    Env env3(7);
    Statement statement1("1", "plus"), statement2("2", "minus"), statement3("3", "divide"), statement4("4", "product");
    Program<Statement, Env> program;
    Program<Statement, Env> program2;
    Program<Statement, Env> program3;
    program2 << statement1 << statement2 << statement3 >> statement4;
    program3 << statement1 << statement2 >> statement3 >> statement4;
    program << statement1 << statement2 >> statement3 >> statement4;
    program(env);
    program2(env2);
    program3(env3);
    if (program==program2) {
        std::cout << "Programs are equal." << std::endl;
    } else {
        std::cout << "Programs are not equal." << std::endl;
    }
    if (program != program3) {
        std::cout << "Programs are not equal." << std::endl;
    } else {
        std::cout << "Programs are equal." << std::endl;
    }
    return 0;
}
