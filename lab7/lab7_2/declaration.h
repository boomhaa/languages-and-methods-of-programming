#ifndef DECLARATION_H
#define DECLARATION_H

class IntegerMatrix {
private:
    int **matrix;
    int rows;
    int cols;

public:
    IntegerMatrix(int m, int n);
    IntegerMatrix(IntegerMatrix &other); 

    virtual ~IntegerMatrix();
    IntegerMatrix& operator=(IntegerMatrix &other);

    int getRows() const;
    int getCols() const;
    int& getElement(int row, int col);

    void swapRows(int row1, int row2);
    void swapCols(int col1, int col2);
};

#endif