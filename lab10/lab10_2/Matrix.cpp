#include "Matrix.h"

Matrix::Matrix(size_t rows, size_t cols) : data(rows, std::vector<int>(cols)) {}

size_t Matrix::rowCount() const {
    return data.size();
}

size_t Matrix::colCount() const {
    return data[0].size();
}

const int& Matrix::operator()(size_t row, size_t col) const {
    return data[row][col];
}

ConstSubmatrixIterator Matrix::begin() const {
    return ConstSubmatrixIterator(*this);
}

ConstSubmatrixIterator Matrix::end() const {
    return ConstSubmatrixIterator(*this, true);
}
