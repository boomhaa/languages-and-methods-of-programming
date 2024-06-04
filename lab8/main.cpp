#include <iostream>
#include "declaration.h"

int main() {
    std::pair<double, double> vertices[3] = { {0.0, 0.0}, {3.0, 0.0}, {0.0, 4.0} };
    Polygon<double, 3> triangle(vertices);

    std::cout << "Perimeter of the triangle: " << triangle.perimeter() << std::endl;
    std::cout << "Area of the triangle: " << triangle.area() << std::endl;

    std::pair<double, double> newVertex(2.0, 2.0);
    Polygon<double, 4> updatedTriangle = triangle.addVertex(newVertex);

    std::cout << "Perimeter of the updated triangle: " << updatedTriangle.perimeter() << std::endl;



    return 0;
}
