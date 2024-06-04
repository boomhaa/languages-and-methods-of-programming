#include <iostream>
#include <fstream>
#include <filesystem>
#include <regex>
#include <string>
#include <vector>


namespace fs = std::filesystem;

struct ClassInfo {
    std::string className;
    int lineNumber;
};

bool findPublicClass(const std::string& filePath, ClassInfo& classInfo) {
    std::ifstream inputFile(filePath);
    if (!inputFile.is_open()) {
        std::cerr << "Failed to open file: " << filePath << std::endl;
        return false;
    }

    std::regex classPattern(R"(\bpublic\s+class\s+(\w+))");
    std::string line;
    int lineNumber = 0;
    while (std::getline(inputFile, line)) {
        lineNumber++;
        std::smatch match;
        if (std::regex_search(line, match, classPattern)) {
            classInfo.className = match[1];
            classInfo.lineNumber = lineNumber;
            inputFile.close();
            return true;
        }
    }

    inputFile.close();
    return false;
}

void findAndProcessJavaFiles(const fs::path& inputDir, std::vector<ClassInfo>& classes) {
    for (const auto& entry : fs::directory_iterator(inputDir)) {
        if (entry.is_regular_file() && entry.path().extension() == ".java") {
            ClassInfo classInfo;
            if (findPublicClass(entry.path().string(), classInfo)) {
                classes.push_back(classInfo);
            }
        }
    }
}

void writeClassesToFile(const std::string& outputFilePath, const std::vector<ClassInfo>& classes) {
    std::ofstream outputFile(outputFilePath);
    if (!outputFile.is_open()) {
        std::cerr << "Failed to open output file: " << outputFilePath << std::endl;
        return;
    }

    for (const auto& classInfo : classes) {
        outputFile << classInfo.className << " " << classInfo.lineNumber << std::endl;
    }

    outputFile.close();
}

int main() {
    std::string inputDirectory;
    std::cout << "Enter the input directory: ";
    std::cin >> inputDirectory;

    std::vector<ClassInfo> classes;
    findAndProcessJavaFiles(inputDirectory, classes);

    std::sort(classes.begin(), classes.end(), [](const ClassInfo& a, const ClassInfo& b) {
        return a.className < b.className;
    });

    fs::path currentPath = fs::current_path();
    fs::path outputFilePath = currentPath / "classes.txt";
    writeClassesToFile(outputFilePath.string(), classes);
    return 0;
}
