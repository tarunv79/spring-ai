# LLM Enabled Java Applications using Spring AI and Mistral-AI

In this tutorial, let's develop a simple Chat Client application using Spring AI and Mistral-AI language model on internet. 
If you know how to deal with Spring framework then using Spring AI will be a breeze for you.

> Goal: Create a minimal Spring Boot application that uses Spring AI to interact with Mistral AI by exposing a simple chat API.

---

## Table of Contents
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Clone the Project](#1-clone-the-project)
  - [Create a new Project](#1-create-a-new-project)
  - [Configure the Application](#2-configure-the-application)
  - [Write Simple Chat Client Code](#3-write-simple-chat-client-code)
  - [Build and Run the Project](#4-build-and-run-the-project)
  - [Test the Chat API](#5-test-the-chat-api)
- [Summary](#summary)
- [Resources](#resources)

---

## Tech Stack

- Java 17+
- Spring Boot 3.2+
- Spring AI 1.0.0-SNAPSHOT
- Mistral-AI

---

## Getting Started

### Prerequisites
You will need to create an API with Mistral AI to access Mistral AI language models.
Create an account at [Mistral AI registration page](https://auth.mistral.ai/ui/registration) and generate the token on the [API Keys page](https://console.mistral.ai/api-keys/).

### 1. Clone the Project

```bash
git clone https://github.com/tarunv79/spring-ai.git
``` 

<p><b>OR</b></p>

### 1. Create a new Project
A Spring Boot project using Spring Initializr (https://start.spring.io/) or your IDE.

### Selections:

- Project: Maven
- Language: Java
- Spring Boot 3.2+
- Enter your project metadata (package name, artifact name) as desired
- Java: 17+

### Dependencies:

- Spring Web: For creating REST endpoints.
- Mistral AI

### Check the pom.xml file
Ensure your pom.xml includes the necessary dependencies:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-mistral-ai</artifactId>
</dependency>
```
And also add following dependency Management
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-bom</artifactId>
            <version>1.0.0-SNAPSHOT</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### 2. Configure the Application
When using Mistral AI or even other LLMs in a Spring AI project, we need to add two properties in the application.properties file to run the maven build successfully.

```properties
spring.ai.mistralai.chat.api-key=<your-mistral-ai-api-key>
```

You can add additional properties to configure the Mistral AI client, such as the model name, temperature, etc. For example:
refer to the [Spring AI Mistral AI documentation](https://docs.spring.io/spring-ai/reference/api/chat/mistralai-chat.html) for more configuration options.

### 3. Write simple Chat Client Code
Add a new class `ChatController.java` in the `src/main/java/com/example/controller` package (or your chosen package name):

- Following code snippet creates a simple REST controller that exposes a `/chat` endpoint to interact with the Mistral AI model.</p>
- Mistral AI model in defined in `ChatService` class which is injected into the controller.</p>
- `@RequiredArgsConstructor` annotation from lombok is used to generate a constructor with required arguments, which is a simple way to inject dependencies in Spring.</p>

```java
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public String chat(@RequestParam String message) {
        return chatService.chat(message);
    }
}
```

2. Next create a service class `ChatService.java` in the same package or create a dedicated service package:

- Following code snippet defines a service that uses the `ChatModel` to send user input to the Mistral AI model and return the response.
- It uses `PromptTemplate` to create a prompt from the user input and then calls the model to get the response.
- User input is passed as a parameter to the `chat` method which comes from the HTTP request.
- The response is then returned as a string.

```java
@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatModel chatModel;

    public String chat(String userInput) {
        PromptTemplate promptTemplate = new PromptTemplate(userInput);
        Prompt prompt = promptTemplate.create();

        return chatModel.call(prompt).getResult().getOutput().getText();
    }
}
```

- `ChatModel` is a Spring AI abstraction that allows you to interact with various LLMs, including Mistral AI. The `call` method sends the prompt to the model and retrieves the response.
- Under the hood, Spring AI handles the communication with the Mistral AI API using the provided API key and model configuration.

### 4. Build and Run the Project

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run 

# If you encounter warnings about RMI, you can specify the hostname:
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Djava.rmi.server.hostname=localhost"
```

Alternatively, if you are using an IDE like IntelliJ or Eclipse, you can import the project and run it directly from there.

### 5. Test the Chat API

You can use `curl` or any API client (like Postman) to test the chat endpoint:

```bash

curl "http://localhost:8080/chat?message=How%20are%20you?"

# Here is the response you should expect:
# I'm functioning as intended, thank you for asking! I'm here and ready to assist you with any questions or topics you'd like to discuss. 
# How about you? How are you doing today?
```

---

## Summary

This project demonstrates a minimal, local-first setup for:

Running Spring Boot + Spring AI
Using a Mistral AI model for chat interactions
Exposing a basic /chat API for testing

---

## Resources
- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Spring Initializr](https://start.spring.io/)
- [Mistral AI Documentation](https://docs.mistral.ai/)
