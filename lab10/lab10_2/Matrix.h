#ifndef MATRIX_H
#define MATRIX_H

#include <vector>
#include "ConstSubmatrixIterator.h"

class Matrix {
public:



    Matrix(size_t rows, size_t cols);

    size_t rowCount() const;
    size_t colCount() const;

    const int& operator()(size_t row, size_t col) const;

    ConstSubmatrixIterator begin() const;
    ConstSubmatrixIterator end() const;

private:
    std::vector<std::vector<int>> data;
};

#endif // MATRIX_H
