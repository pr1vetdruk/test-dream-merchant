package ru.privetdruk.dreammerchant.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.privetdruk.dreammerchant.bot.Bot;

@RestController
public class WebHookController {
    private final Bot bot;

    public WebHookController(Bot bot) {
        this.bot = bot;
    }

    @PostMapping(value = "/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }
}
