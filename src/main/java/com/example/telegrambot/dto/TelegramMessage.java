package com.example.telegrambot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramMessage {
    private Long update_id;
    private Message message;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message {
        private Long message_id;
        private From from;
        private Chat chat;
        private String text;
        private Integer date;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class From {
            private Long id;
            private String username;
            private String first_name;
            private String last_name;
            private Boolean is_bot;
            private String language_code;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Chat {
            private Long id;
            private String type;
            private String username;
            private String first_name;
            private String last_name;
        }
    }
}

