package com.example.tutorial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

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
