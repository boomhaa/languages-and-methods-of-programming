#include <iostream>
#include <filesystem>
#include <fstream>
#include <regex>
#include <string>

namespace fs = std::filesystem;
using namespace std;
void processRTFFile(const fs::path& filePath) {

    ifstream inputFile(filePath);
    if (!inputFile.is_open()) {
        cerr << "Не удалось открыть файл: " << filePath << endl;
        return;
    }

    string fileContent((istreambuf_iterator<char>(inputFile)), istreambuf_iterator<char>());
    inputFile.close();

    regex italicPattern(R"(\\i\b)");
    regex boldPattern(R"(\\b\b)");

    fileContent = regex_replace(fileContent, italicPattern, "\\TEMPITALIC");

    fileContent = regex_replace(fileContent, boldPattern, "\\i");

    fileContent = regex_replace(fileContent, regex(R"(\\TEMPITALIC)"), "\\b");

    ofstream outputFile(filePath);
    if (!outputFile.is_open()) {
        cerr << "Не удалось записать в файл: " << filePath << endl;
        return;
    }
    outputFile << fileContent;
    outputFile.close();
}

void findAndProcessRTFFiles(const fs::path& directoryPath) {
    if (!fs::exists(directoryPath) || !fs::is_directory(directoryPath)) {
        cerr << "Неверный путь к каталогу: " << directoryPath << endl;
        return;
    }

    for (const auto& entry : fs::recursive_directory_iterator(directoryPath)) {
        if (entry.is_regular_file() && entry.path().extension() == ".rtf") {
            processRTFFile(entry.path());
        }
    }
}

int main() {
    string directoryPath;
    cout << "Введите путь к каталогу: ";
    cin >> directoryPath;

    findAndProcessRTFFiles(directoryPath);

    return 0;
}
