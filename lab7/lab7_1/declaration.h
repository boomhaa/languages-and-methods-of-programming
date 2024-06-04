

#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H

class Polynomial {
public:

    Polynomial();
    Polynomial(int degree);
    Polynomial(Polynomial& other);

    
    virtual ~Polynomial();


    Polynomial& operator=(Polynomial& other);

    int evaluate(int x) const;
    int getDegree() const;
    int& coefficientAt(int power);

  
    Polynomial operator+(Polynomial& other) const;

protected:
    int degree_;
    int* coefficients_;
};

#endif 
