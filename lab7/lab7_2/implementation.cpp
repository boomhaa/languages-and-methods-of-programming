#include "declaration.h"

IntegerMatrix::IntegerMatrix(int m, int n) : rows(m), cols(n) {
    matrix = new int*[rows];
    for (int i = 0; i < rows; ++i) {
        matrix[i] = new int[cols];
        for (int j = 0; j < cols; ++j) {
            matrix[i][j] = 0; 
        }
    }
}

IntegerMatrix::IntegerMatrix(IntegerMatrix &other) : rows(other.rows), cols(other.cols) {
    matrix = new int*[rows];
    for (int i = 0; i < rows; ++i) {
        matrix[i] = new int[cols];
        for (int j = 0; j < cols; ++j) {
            matrix[i][j] = other.matrix[i][j];
        }
    }
}


IntegerMatrix::~IntegerMatrix() {
    for (int i = 0; i < rows; ++i) {
        delete[] matrix[i];
    }
    delete[] matrix;
}

IntegerMatrix& IntegerMatrix::operator=(IntegerMatrix &other) {
    if (this != &other) {
   
        for (int i = 0; i < rows; ++i) {
            delete[] matrix[i];
        }
        delete[] matrix;

        rows = other.rows;
        cols = other.cols;
        matrix = new int*[rows];
        for (int i = 0; i < rows; ++i) {
            matrix[i] = new int[cols];
            for (int j = 0; j < cols; ++j) {
                matrix[i][j] = other.matrix[i][j];
            }
        }
    }
    return *this;
}

int IntegerMatrix::getRows() const {
    return rows;
}

int IntegerMatrix::getCols() const {
    return cols;
}

int& IntegerMatrix::getElement(int row, int col) {
    return matrix[row][col];
}

void IntegerMatrix::swapRows(int row1, int row2) {
    if (row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows) {
        int *temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }
}

void IntegerMatrix::swapCols(int col1, int col2) {
    if (col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols) {
        for (int i = 0; i < rows; ++i) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
    }
}