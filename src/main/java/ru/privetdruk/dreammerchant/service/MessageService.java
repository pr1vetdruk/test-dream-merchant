package ru.privetdruk.dreammerchant.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.privetdruk.dreammerchant.model.enums.MessageEnum;

@Service
public class MessageService {
    public SendMessage configureMessage(Long chatId, MessageEnum messageEnum) {
        return new SendMessage(chatId.toString(), messageEnum.getText());
    }

    public SendMessage configureMessage(Long chatId, String message) {
        return new SendMessage(chatId.toString(), message);
    }
}
