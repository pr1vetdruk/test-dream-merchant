package ru.privetdruk.dreammerchant.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.privetdruk.dreammerchant.service.BotService;

@Component
public class Bot extends TelegramWebhookBot {
    private final BotService botService;

    private final String webHookPath;
    private final String username;
    private final String token;

    public Bot(BotService botService) {
        this.botService = botService;
        this.webHookPath = System.getenv("WEB_HOOK_PATH");
        this.username = System.getenv("BOT_USERNAME");
        this.token = System.getenv("BOT_TOKEN");
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return botService.handleUpdate(update);
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }
}
