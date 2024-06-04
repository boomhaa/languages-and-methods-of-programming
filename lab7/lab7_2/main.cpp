#include <iostream>
#include "implementation.cpp"

using namespace std;

void printMatrix(IntegerMatrix &matrix) {
    for (int i = 0; i < matrix.getRows(); ++i) {
        for (int j = 0; j < matrix.getCols(); ++j) {
            cout << matrix.getElement(i, j) << " ";
        }
        cout << endl;
    }
}

int main() {
    IntegerMatrix mat(3, 3);

    int value = 1;
    for (int i = 0; i < mat.getRows(); ++i) {
        for (int j = 0; j < mat.getCols(); ++j) {
            mat.getElement(i, j) = value++;
        }
    }

    cout << "Original matrix:" << endl;
    printMatrix(mat);

    IntegerMatrix copiedMat = mat;
    cout << "\nCopied matrix:" << endl;
    printMatrix(copiedMat);

    IntegerMatrix assignedMat(2, 2);
    assignedMat = mat;
    cout << "\nAssigned matrix:" << endl;
    printMatrix(assignedMat);
    cout << "\nSwaped cols 1 and 2"<<endl;
    mat.swapCols(1,2);
    printMatrix(mat);
    return 0;
}