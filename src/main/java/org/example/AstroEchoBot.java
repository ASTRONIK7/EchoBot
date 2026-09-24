package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;



/**
 * Телеграм-бот, повторяющий отправленные ему текстовые сообщения (эхо-бот).
 */
public class AstroEchoBot extends TelegramLongPollingBot {

    private final String botToken;

    /**
     * Создает новый экземпляр бота с указанным токеном.
     *
     * @param botToken токен авторизации Telegram Bot API
     */
    public AstroEchoBot(String botToken) {
        this.botToken = botToken;
    }

    /**
     * Возвращает юзернейм бота.
     *
     * @return имя пользователя бота в Telegram
     */
    @Override
    public String getBotUsername() { return "MuseEchoBot"; }

    /**
     * Возвращает токен бота для подключения к API.
     *
     * @return токен бота
     */
    @Override
    public String getBotToken() { return botToken; }

    /**
     * Обрабатывает входящие обновления от Telegram.
     * Если обновление содержит текст, отправляет его обратно пользователю.
     *
     * @param update входящее обновление от Telegram API
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            MessageSender.send(this, update.getMessage().getChatId(), update.getMessage().getText());
        }
    }
}