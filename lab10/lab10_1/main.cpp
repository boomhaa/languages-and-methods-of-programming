#include <iostream>
#include "Vector.h"
#include "VectorSequence.h"

int main() {
    VectorSequence sequence;
    sequence.addVector(Vector({1.0, 1.0, 1.0}));
    sequence.addVector(Vector({1.0, 1.0, 1.0}));
    sequence.addVector(Vector({7.0, 8.0, 9.0}));

    for (auto it = sequence.begin(); it != sequence.end(); ++it) {
        std::cout << *it << " ";
    }


    return 0;
}
