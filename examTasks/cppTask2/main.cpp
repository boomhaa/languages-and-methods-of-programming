#include <iostream>
#include <vector>

using namespace std;

class SubsequenceIterator {
public:
    SubsequenceIterator(const vector<int>& sequence, int maxSum)
        : sequence(sequence), maxSum(maxSum), start(0), end(0), currentSum(0) {}

    bool hasNext() {
        return start < sequence.size();
    }

    vector<int> next() {
        while (start < sequence.size()) {
            while (end < sequence.size() && currentSum + sequence[end] <= maxSum) {
                currentSum += sequence[end];
                end++;
            }

            if (start < end) {
                vector<int> subsequence(sequence.begin() + start, sequence.begin() + end);
                currentSum -= sequence[start];
                start++;
                return subsequence;
            } else {
                start++;
                end = start;
                currentSum = 0;
            }
        }

    }

private:
    const vector<int> &sequence;
    int maxSum;
    int currentSum;
    int start;
    int end;
};

int main() {
    vector<int> sequence = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
    int maxSum = 21;

    SubsequenceIterator it(sequence, maxSum);

    while (it.hasNext()) {
        vector<int> subsequence = it.next();
        for (int num : subsequence) {
            cout << num << " ";
        }
        cout << endl;
    }

    return 0;
}
