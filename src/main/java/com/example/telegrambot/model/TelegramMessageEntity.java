package com.example.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramMessageEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long chatId;
    private String username;
    private String messageText;
    private Integer date;
    private LocalDateTime timestamp;
}
