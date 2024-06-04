
#include "declaration.h"
#include <cmath>


Polynomial::Polynomial() : degree_(0), coefficients_(nullptr) {}


Polynomial::Polynomial(int degree) : degree_(degree), coefficients_(new int[degree + 1]) {
    for (int i = 0; i <= degree_; ++i) {
        coefficients_[i] = 0;
    }
}


Polynomial::Polynomial(Polynomial& other) : degree_(other.degree_), coefficients_(new int[other.degree_ + 1]) {
    for (int i = 0; i <= degree_; ++i) {
        coefficients_[i] = other.coefficients_[i];
    }
}


Polynomial::~Polynomial() {
    delete[] coefficients_;
}


Polynomial& Polynomial::operator=(Polynomial& other) {
    if (this != &other) {
        delete[] coefficients_; 
        degree_ = other.degree_;
        coefficients_ = new int[degree_ + 1];
        for (int i = 0; i <= degree_; ++i) {
            coefficients_[i] = other.coefficients_[i];
        }
    }
    return *this;
}

int Polynomial::evaluate(int x) const {
    int result = 0;
    for (int i = 0; i <= degree_; ++i) {
        result += coefficients_[i] * pow(x, i);
    }
    return result;
}


int Polynomial::getDegree() const {
    return degree_;
}


int& Polynomial::coefficientAt(int power) {
    return coefficients_[power];
}

Polynomial Polynomial::operator+( Polynomial& other) const {
    int maxDegree = std::max(degree_, other.degree_);
    Polynomial result(maxDegree);
    for (int i = 0; i <= maxDegree; ++i) {
        int coeff1 = (i <= degree_) ? coefficients_[i] : 0;
        int coeff2 = (i <= other.degree_) ? other.coefficients_[i] : 0;
        result.coefficients_[i] = coeff1 + coeff2;
    }
    return result;
}
