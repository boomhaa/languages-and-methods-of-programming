#ifndef VECTOR_H
#define VECTOR_H

#include <vector>


class Vector {
public:
    Vector(const std::vector<double>& components);

    int size() const;
    double operator[](int index) const;

private:
    std::vector<double> components;
};

#endif // VECTOR_H
