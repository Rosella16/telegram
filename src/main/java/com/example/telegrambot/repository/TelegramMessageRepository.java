package com.example.telegrambot.repository;

import com.example.telegrambot.dto.TelegramMessage;
import com.example.telegrambot.model.TelegramMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramMessageRepository extends JpaRepository<TelegramMessageEntity, Long> {

}
