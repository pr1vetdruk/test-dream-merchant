package ru.privetdruk.dreammerchant.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.privetdruk.dreammerchant.model.entity.User;

public interface MessageHandler {
    SendMessage handle(Message message, User user);
}
