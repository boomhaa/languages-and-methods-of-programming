#ifndef CONSTSUBMATRIXITERATOR_H
#define CONSTSUBMATRIXITERATOR_H

#include "Matrix.h"

class ConstSubmatrixIterator {
public:
    using container_type = std::vector<std::vector<int>>;

    ConstSubmatrixIterator(const Matrix& mat, bool end = false);

    container_type operator*() const;

    ConstSubmatrixIterator& operator++();
    bool operator!=(const ConstSubmatrixIterator& other) const;

private:
    const Matrix& matrix;
    size_t rowIndex;
    size_t colIndex;
    bool done;

    void advance();
};

#endif // CONSTSUBMATRIXITERATOR_H
