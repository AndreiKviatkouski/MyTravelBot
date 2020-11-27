package by.kviatkouski.telegram.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

// Аннотация @Value позволяет задавать значение полю путем считывания из application.yaml

    @Value("TravelMarioBot")
    private String botUsername;

    @Value("1315845916:AAGLbMojFs7u84JVih06UcPi3xAncqFme_E")
    private String botToken;

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(new SendMessage().setChatId(update.getMessage().getChatId())
                    .setText("Hi!"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }
}