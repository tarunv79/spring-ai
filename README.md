# Spring AI + Ollama (Mistral) - Minimal Chat API

This is a **basic Spring Boot project** that introduces [Spring AI](https://docs.spring.io/spring-ai/reference/) using a **locally running Ollama model** (like `mistral`). It includes a `/chat` REST endpoint to interact with the AI model.

> Goal: Help beginners get started with Spring AI + local LLMs in a few simple steps.

---

## Tech Stack

- Java 17+
- Spring Boot 3.2+
- Spring AI 1.0.0-SNAPSHOT
- Ollama (running locally)
- Model used: `mistral` (but you can switch)

---

## Getting Started

### 1. Clone the Project

```bash
git clone https://github.com/tarunv79/spring-ai.git
```
### 2. Run Ollama (Assuming Ollama is installed)

```bash
ollama run mistral
```

You can verify it’s working at: http://localhost:11434

### 3. Build and Run the Project

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run 

# If you encounter warnings about RMI, you can specify the hostname:
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Djava.rmi.server.hostname=localhost"
```

Alternatively, if you are using an IDE like IntelliJ or Eclipse, you can import the project and run it directly from there.

### 4. Test the Chat API

You can use `curl` or any API client (like Postman) to test the chat endpoint:

```bash

curl "http://localhost:8080/chat?message=How%20are%20you?"

# Here is the response you should expect:
# I'm just a computer program, so I don't have feelings or consciousness. But I'm here to help you with your questions! Is there something specific you'd like to know about today?
# Also, if you're having a rough day and need someone to talk to, feel free to share what's on your mind. I'm here to listen without judgment.

```

## Summary

This project demonstrates a minimal, local-first setup for:

Running Spring Boot + Spring AI
Using a local LLM (Mistral via Ollama)
Exposing a basic /chat API for testing

## Resources
- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Ollama Documentation](https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html)
- [Spring Initializr](https://start.spring.io/)
