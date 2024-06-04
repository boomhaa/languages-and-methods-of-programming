
#include <iostream>
#include "declaration.h"

void testPolynomial(const Polynomial& poly) {
    std::cout << "Testing Polynomial:" << std::endl;

    int x = 2;
    std::cout << "Value of polynomial at x = " << x << ": " << poly.evaluate(x) << std::endl;


    std::cout << "Degree of polynomial: " << poly.getDegree() << std::endl;


    Polynomial poly2(3);
    poly2.coefficientAt(2) = 3;
    poly2.coefficientAt(1) = -2;
    poly2.coefficientAt(0) = 1;
    Polynomial sum = poly + poly2;
    std::cout << "Sum of two polynomials at x = " << x << ": " << sum.evaluate(x) << std::endl;
}

int main() {

    Polynomial poly(2);
    poly.coefficientAt(2) = 1;
    poly.coefficientAt(1) = -3;
    poly.coefficientAt(0) = 2;

    testPolynomial(poly);
    poly.coefficientAt(0) = 100;
    testPolynomial(poly);

    Polynomial poly3 = poly;
    poly3.coefficientAt(1) = 20;
    testPolynomial(poly3);

    return 0;
}
