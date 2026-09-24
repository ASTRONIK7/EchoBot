package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Главный класс для запуска Telegram-бота.
 * Перед запуском необходимо установить переменную окружения:
 * {@code BOT_TOKEN} — токен бота, полученный от BotFather.
 */

public class Main {
    static void main() {

        final String BOT_TOKEN = System.getenv("BOT_TOKEN");

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new AstroEchoBot(BOT_TOKEN));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
