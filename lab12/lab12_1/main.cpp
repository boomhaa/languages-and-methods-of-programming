#include <iostream>
#include <fstream>
#include <filesystem>
#include <regex>
#include <string>

namespace fs = std::filesystem;

bool isDirected(const std::string& content) {
    std::regex directed_edge("->");
    return std::regex_search(content, directed_edge);
}

std::string convertToUndirected(const std::string& content) {
    std::regex directed_edge("->");
    return std::regex_replace(content, directed_edge, "--");
}

void processDotFile(const fs::path& filePath, const fs::path& outputPath) {
    std::ifstream inputFile(filePath);
    if (!inputFile.is_open()) {
        std::cerr << "Failed to open file: " << filePath << std::endl;
        return;
    }

    std::string content((std::istreambuf_iterator<char>(inputFile)),
                        std::istreambuf_iterator<char>());
    inputFile.close();

    bool directed = isDirected(content);
    if (directed) {
        content = convertToUndirected(content);
    }

    std::ofstream outputFile(outputPath);
    if (!outputFile.is_open()) {
        std::cerr << "Failed to open output file: " << outputPath << std::endl;
        return;
    }

    outputFile << content;
    outputFile.close();
}

void findAndProcessDotFiles(const fs::path& inputDir, const fs::path& outputDir) {
    for (const auto& entry : fs::directory_iterator(inputDir)) {
        if (entry.is_regular_file() && entry.path().extension() == ".dot") {
            fs::path outputPath = outputDir / entry.path().filename();
            processDotFile(entry.path(), outputPath);
        }
    }
}

int main() {
    std::string inputDirectory;
    std::cout << "Enter the input directory: ";
    std::cin >> inputDirectory;

    fs::path currentPath = fs::current_path();
    findAndProcessDotFiles(inputDirectory, currentPath);

    std::cout << "Processing completed." << std::endl;
    return 0;
}
