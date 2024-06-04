#include "ConstSubmatrixIterator.h"

ConstSubmatrixIterator::ConstSubmatrixIterator(const std::vector<std::vector<int>>& mat, bool end)
    : matrix(mat), rowIndex(0), colIndex(0), done(end) {
    if (matrix.rowCount() == 0 || matrix.colCount() == 0) {
        done = true;
    }
}

ConstSubmatrixIterator::container_type ConstSubmatrixIterator::operator*() const {
    container_type submatrix;
    for (size_t i = 0; i < matrix.rowCount(); ++i) {
        if (i != rowIndex) {
            std::vector<int> row;
            for (size_t j = 0; j < matrix.colCount(); ++j) {
                if (j != colIndex) {
                    row.push_back(matrix(i, j));
                }
            }
            submatrix.push_back(row);
        }
    }
    return submatrix;
}

ConstSubmatrixIterator& ConstSubmatrixIterator::operator++() {
    advance();
    return *this;
}

bool ConstSubmatrixIterator::operator!=(const ConstSubmatrixIterator& other) const {
    return done != other.done;
}

void ConstSubmatrixIterator::advance() {
    if (++colIndex >= matrix.colCount()) {
        colIndex = 0;
        if (++rowIndex >= matrix.rowCount()) {
            done = true;
        }
    }
}
