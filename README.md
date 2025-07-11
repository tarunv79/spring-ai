# Spring AI Playground

This repository demonstrates work with **Spring AI** in different ways using different LLM providers.

### Goals:

- Introduce Spring AI with minimal code
- Show how to integrate different providers like **Ollama** and **Mistral** etc
- Keep each setup isolated in its own Git branch
- Build a strong foundation for more advanced AI-powered apps

---

## Branches

| Branch                                                                      | Description                                     |
|-----------------------------------------------------------------------------|-------------------------------------------------|
| [`basic-mistral`](https://github.com/tarunv79/spring-ai/tree/basic-mistral) | LLM Enabled Java Applications using Spring AI and Mistral-AI|
| [`basic-ollama`](https://github.com/tarunv79/spring-ai/tree/basic-ollama)   | Spring AI + Ollama (Mistral) - Minimal Chat API |
| `default`                                                                   | You are here – repo overview and branch guide   |

---

## Related Articles
[LLM Enabled Java Applications using Spring AI and Mistral-AI](https://medium.com/@tarun-vishwakarma/llm-enabled-java-applications-using-spring-ai-and-mistral-ai-3b6b4d6fe46a)


## My Other Repositories
### Want to work with Python and LLMs?
[https://github.com/tarunv79/llm-local](https://github.com/tarunv79/llm-local)

This repository contains examples for efficiently processing logs using a locally hosted Mistral LLM with LangChain. 
Repository demonstrates:
- setting up local LLMs - `Mistral` and `Phi` using `Ollama`
- basic chat API using `requests`
- using `LangChain` to create a prompt templates
- contextual prompting with `LangChain` and `Ollama`
- optimizing prompts
- tokenization and chunking

## Requirements (general)

- Java 17+
- Maven 3.9+
- Spring Boot 3.2+
- [Spring AI](https://docs.spring.io/spring-ai/reference/)
- Ollama (for local)
- Gemini API key (for Google Gemini)
...
---

## Coming Up

- Creating you own ChatModel with ChatClient
- Chat history/memory support
- Prompt templating

---

## Want to Contribute?

Open issues, ideas, or PRs are welcome.

---

## References
- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Ollama Documentation](https://ollama.com/docs)
- [Google Gemini Documentation](https://developers.google.com/gemini)