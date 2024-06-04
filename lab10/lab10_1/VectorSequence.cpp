#include "VectorSequence.h"

void VectorSequence::addVector(const Vector& vector) {
    vectors.push_back(vector);
}

VectorSequence::ConstIterator::ConstIterator(const VectorSequence& sequence, int index)
    : sequence(sequence), index(index) {}

bool VectorSequence::ConstIterator::operator==(const ConstIterator& other) const {
    return &sequence == &other.sequence && index == other.index;
}

bool VectorSequence::ConstIterator::operator!=(const ConstIterator& other) const {
    return !(*this == other);
}

double VectorSequence::ConstIterator::operator*() const {
    return dotProduct(sequence.vectors[index], sequence.vectors[index + 1]);
}

VectorSequence::ConstIterator& VectorSequence::ConstIterator::operator++() {
    ++index;
    return *this;
}

VectorSequence::ConstIterator VectorSequence::ConstIterator::operator++(int) {
    ConstIterator temp = *this;
    ++(*this);
    return temp;
}

VectorSequence::ConstIterator& VectorSequence::ConstIterator::operator--() {
    --index;
    return *this;
}

VectorSequence::ConstIterator VectorSequence::ConstIterator::operator--(int) {
    ConstIterator temp = *this;
    --(*this);
    return temp;
}

double VectorSequence::ConstIterator::dotProduct(const Vector& v1, const Vector& v2) const {
    double result = 0.0;
    for (int i = 0; i < v1.size(); ++i) {
        result += v1[i] * v2[i];
    }
    return result;
}

VectorSequence::ConstIterator VectorSequence::begin() const {
    return ConstIterator(*this, 0);
}

VectorSequence::ConstIterator VectorSequence::end() const {
    return ConstIterator(*this, vectors.size() - 1);
}
