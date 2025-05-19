
package com.example.telegrambot.controller;

import com.example.telegrambot.dto.TelegramMessage;
import com.example.telegrambot.service.MessageProcessorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telegram")
@RequiredArgsConstructor
public class TelegramWebhookController {

    private final MessageProcessorService processorService;

//    @PostMapping("/telegram/webhook")
//    public ResponseEntity<String> receiveMessage(@RequestBody TelegramMessage telegramMessage) {
//        processorService.processIncomingMessage(telegramMessage);
//        return ResponseEntity.ok("Received");
//    }

@PostMapping("/webhook")
public ResponseEntity<String> receiveUpdate(@RequestBody String payload) {
    System.out.println("Received update: " + payload);
    try {

        ObjectMapper objectMapper = new ObjectMapper();

        TelegramMessage telegramMessage = objectMapper.readValue(payload, TelegramMessage.class);

        processorService.processIncomingMessage(telegramMessage);
        return ResponseEntity.ok("Saved");
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body("Failed to parse and save message");
    }}


}
