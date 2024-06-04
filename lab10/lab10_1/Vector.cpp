#include "Vector.h"

Vector::Vector(const std::vector<double>& components) : components(components) {}

int Vector::size() const {
    return components.size();
}

double Vector::operator[](int index) const {

    return components[index];
}
