#include <iostream>
#include "Matrix.h"
#include "ConstSubmatrixIterator.h"

int main() {
    Matrix mat(3, 3);

    int value = 1;
    for (size_t i = 0; i < mat.rowCount(); ++i) {
        for (size_t j = 0; j < mat.colCount(); ++j) {
            mat(i, j) = value++;
        }
    }

    for (auto it = mat.begin(); it != mat.end(); ++it) {
        const auto& submatrix = *it;
        for (const auto& row : submatrix) {
            for (const auto& elem : row) {
                std::cout << elem << " ";
            }
            std::cout << std::endl;
        }
        std::cout << "----" << std::endl;
    }

    return 0;
}
