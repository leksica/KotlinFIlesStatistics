# Kotlin File Statistics 📝

[![JetBrains Plugin](https://img.shields.io/jetbrains/plugin/v/7275-KotlinFileStatistics.svg)](https://plugins.jetbrains.com/plugin/7275)

## Overview

**Kotlin File Statistics** is an IntelliJ IDEA plugin that provides insightful metrics for your Kotlin files. With a single click, obtain valuable statistics such as the total number of lines, the count of `TODO` comments, and identification of the longest function within your Kotlin source code. Enhance your development workflow by easily monitoring and maintaining your codebase's quality and structure.


## Features

- **Total Lines Count**: Instantly view the total number of lines in the current Kotlin file.
- **TODO Count**: Automatically counts the number of `TODO` comments, helping you track pending tasks.
- **Longest Function Identification**: Detects and displays the longest function in your file based on line count.
- **User-Friendly Dialog**: Presents all statistics in a clean and concise dialog box.
- **Seamless Integration**: Easily accessible from the Tools menu within IntelliJ IDEA.
- **Theme Compatible**: Adapts to both light and dark themes, ensuring optimal readability.

## Usage

1. **Open a Kotlin File**:
   - Open any `.kt` file within IntelliJ IDEA.

2. **Access the Plugin**:
   - Navigate to `Tools` > `Kotlin File Statistics`.

3. **View Statistics**:
   - A dialog will appear displaying:
     - **Total Number of Lines**
     - **Number of TODOs**
     - **Longest Function Name and Its Line Count**
       
![Plugin Screenshot](https://github.com/leksica/KotlinFileStatistics/main/images/example.png)


## Building from Source

### Prerequisites

- **JDK 17**: Ensure you have Java Development Kit 17 installed.
- **Gradle**: Included via the Gradle Wrapper.

### Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/leksica/KotlinFileStatistics.git
   cd KotlinFileStatistics
   ```

2. **Run Tests**:
   ```bash
   ./gradlew test
   ```

3. **Build and Run in IntelliJ Sandbox**:
   ```bash
   ./gradlew runIdea
   ```
   - This command launches a sandbox instance of IntelliJ IDEA with your plugin installed for testing purposes.
