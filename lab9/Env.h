
class Env {
private:
    int data;

public:

    Env(int initialData = 0) : data(initialData) {}

    int getData() const {
        return data;
    }

    void setData(int newData) {
        data = newData;
    }
};