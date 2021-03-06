package ru.privetdruk.dreammerchant.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.privetdruk.dreammerchant.model.enums.Button;

@Service
public class KeyboardService {
    public InlineKeyboardButton createButton(Button cancel) {
        InlineKeyboardButton cancelButton = new InlineKeyboardButton(cancel.getText());
        cancelButton.setCallbackData(cancel.name());
        return cancelButton;
    }
}
