#ifndef VECTORSEQUENCE_H
#define VECTORSEQUENCE_H

#include <vector>
#include "Vector.h"
#include <iterator>


class VectorSequence {
public:
    void addVector(const Vector& vector);

    class ConstIterator : public std::iterator<std::bidirectional_iterator_tag, double> {
    public:
        ConstIterator(const VectorSequence& sequence,int index);

        bool operator==(const ConstIterator& other) const;
        bool operator!=(const ConstIterator& other) const;

        double operator*() const;

        ConstIterator& operator++();
        ConstIterator operator++(int);

        ConstIterator& operator--();
        ConstIterator operator--(int);

    private:
        const VectorSequence& sequence;
        int index;

        double dotProduct(const Vector& v1, const Vector& v2) const;
    };

    ConstIterator begin() const;
    ConstIterator end() const;

private:
    std::vector<Vector> vectors;
};

#endif // VECTORSEQUENCE_H
