
# Telegram Bot Backend

This is a Spring Boot backend service that receives Telegram bot messages via webhook.

## Steps to Run

1. Replace `<YOUR_TOKEN>` with your actual bot token from BotFather.
2. Start the application:
    ```
    ./mvnw spring-boot:run
    ```
3. Expose your local server using `ngrok`:
    ```
    ngrok http 8080
    ```
4. Set Telegram webhook:
    ```
    curl -X POST "https://api.telegram.org/bot<YOUR_TOKEN>/setWebhook?url=https://<your-ngrok-url>/telegram/webhook"
    ```

The bot will now forward messages to your backend.
