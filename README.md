# 🤖 Agentic Command Line Orchestrator

Welcome to **Agentic**! 🚀

This project is a Spring Boot-based command-line orchestrator for running AI-powered and script-driven tasks. It automates workflows by integrating with Copilot and custom scripts, making it easy to execute complex actions from the terminal.

## 🛠️ Features

- ⚡ **AI Orchestration**: Runs Copilot commands with custom prompts
- 📝 **Script Execution**: Executes shell scripts or commands
- 🗂️ **Automatic Folder Creation**: Sets up workspace in your home directory
- 🧩 **Modular Design**: Easily extend with new features

## 📦 Structure

```
pom.xml
src/
  main/
    java/
      io/github/akumosstl/agentic/
        AgenticApplication.java
        work/
          CopilotClient.java
          FolderCreator.java
          Orchestrator.java
          ProcessRunner.java
          ScriptClient.java
          ScriptRunner.java
  resources/
    application.properties
test/
  java/
    io/github/akumosstl/
```

## 🚀 Getting Started

1. **Build the project**:
   ```bash
   mvn clean install
   ```
2. **Run the application**:
   ```bash
   java -jar target/agentic-0.0.1-SNAPSHOT.jar
   ```

## 🧠 How It Works

- On startup, creates `.agentic` folder in your home directory
- Reads environment variables to decide whether to run Copilot or a script
- Executes commands and prints output in real time

## 🌟 Example Usage

Set environment variables and run:

```bash
set ACTION=path/to/feature.txt
java -jar target/agentic-0.0.1-SNAPSHOT.jar
```

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first.

## 📄 License

MIT

---

Made with ❤️ by [akumosstl](https://github.com/akumosstl)
