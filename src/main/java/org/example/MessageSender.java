package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;

class MessageSender {

    /**
     * Отправляет текстовое сообщение в указанный чат.
     *
     * @param bot    экземпляр класса, умеющего отправлять запросы в Telegram (например, сам бот)
     * @param chatId уникальный идентификатор чата или пользователя
     * @param text   текст отправляемого сообщения
     */
    public static void send(AbsSender bot, long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            bot.execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}