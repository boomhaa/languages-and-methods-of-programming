#ifndef declaration_h
#define declaration_h

#include <cmath>

template<typename T, int N>
class Polygon {
private:
    std::pair<T, T>* vertices;

public:
    Polygon(const std::pair<T, T>* verts) {
        vertices = new std::pair<T, T>[N];
        for (size_t i = 0; i < N; ++i) {
            vertices[i] = verts[i];
        }
    }



    double perimeter() const {
        double perimeter = 0.0;
        for (size_t i = 0; i < N - 1; ++i) {
            perimeter += distance(vertices[i], vertices[i + 1]);
        }
        perimeter += distance(vertices[N - 1], vertices[0]);
        return perimeter;
    }


    Polygon<T, N+1> addVertex(const std::pair<T, T>& vertex) const {
        std::pair<T, T>* newVertices = new std::pair<T, T>[N + 1];
        for (size_t i = 0; i < N; ++i) {
            newVertices[i] = vertices[i];
        }
        newVertices[N] = vertex;
        return Polygon<T, N + 1>(newVertices);
    }

    template<int M = N>
    typename std::enable_if<M == 3, double>::type
    area() const {
        double a = distance(vertices[0], vertices[1]);
        double b = distance(vertices[1], vertices[2]);
        double c = distance(vertices[2], vertices[0]);
        double s = (a + b + c) / 2.0;
        return sqrt(s * (s - a) * (s - b) * (s - c));
    }

    double distance(const std::pair<T, T>& p1, const std::pair<T, T>& p2) const {
        return sqrt(pow(p2.first - p1.first, 2) + pow(p2.second - p1.second, 2));
    }

};

#endif

