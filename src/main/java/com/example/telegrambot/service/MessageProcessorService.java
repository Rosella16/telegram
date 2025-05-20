
package com.example.telegrambot.service;

import com.example.telegrambot.dto.TelegramMessage;
import com.example.telegrambot.model.TelegramMessageEntity;
import com.example.telegrambot.repository.TelegramMessageRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageProcessorService {
    private final TelegramMessageRepository telegramMessageRepository;
    public void processIncomingMessage(TelegramMessage telegramMessage) {
        var msg = telegramMessage.getMessage();
        if (msg != null) {

            String user = msg.getFrom().getUsername();

            String text = msg.getText();

            Long chatId = msg.getChat().getId();

//            LocalDateTime timestamp = LocalDateTime.ofInstant(
//                    Instant.ofEpochSecond(msg.getDate()),
//                    ZoneId.systemDefault()
//            );
            Integer unixTimestamp = msg.getDate(); // get from JSON
            LocalDateTime localDateTime = LocalDateTime.ofInstant(
                    Instant.ofEpochSecond(unixTimestamp),
                    ZoneId.systemDefault()
            );

            TelegramMessageEntity teleData = new TelegramMessageEntity();
            teleData.setChatId(chatId);
            teleData.setUsername(user);
            teleData.setMessageText(text);
            teleData.setDate(unixTimestamp); // raw integer timestamp
            teleData.setTimestamp(localDateTime); // human-readable

            telegramMessageRepository.save(teleData);


//            Long timestamp = msg.getD

            log.info("Here is he username: {}", user);
            log.info("Here is the chatId: {}", chatId);
            log.info("Here is the text: {}", text);
            log.info("Received from @{}: {}", user, text);


//            TelegramMessageEntity teleData = new TelegramMessageEntity();
//
//            teleData.setChatId(chatId);
//            teleData.setUsername(user);
//            teleData.setMessageText(text);
//            teleData.setTimestamp(LocalDateTime.now());
//
//            telegramMessageRepository.save(teleData);
//


//            TelegramMessageEntity entity = TelegramMessageEntity.builder()
//                    .chatId(chatId)
//                    .username(user)
//                    .messageText(text)
//                    .timestamp(LocalDateTime.now())
//                    .build();
//            telegramMessageRepository.save(entity);

                }
        }
    }

