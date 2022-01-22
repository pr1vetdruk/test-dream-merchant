package ru.privetdruk.dreammerchant.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.privetdruk.dreammerchant.model.entity.User;
import ru.privetdruk.dreammerchant.model.enums.Button;
import ru.privetdruk.dreammerchant.model.enums.Command;
import ru.privetdruk.dreammerchant.model.enums.MessageEnum;
import ru.privetdruk.dreammerchant.service.KeyboardService;
import ru.privetdruk.dreammerchant.service.MessageService;

import java.util.List;

@Component
public class MainMenuHandler implements MessageHandler {
    private final KeyboardService keyboardService;
    private final MessageService messageService;

    private final InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();

    public MainMenuHandler(KeyboardService keyboardService, MessageService messageService) {
        this.keyboardService = keyboardService;
        this.messageService = messageService;
        initializeKeyboard();
    }

    private void initializeKeyboard() {
        keyboard.setKeyboard(List.of(List.of(
                keyboardService.createButton(Button.BUY),
                keyboardService.createButton(Button.USER_DATA)
        )));
    }

    @Override
    public SendMessage handle(Message message, User user) {
        Command command = Command.fromCommand(message.getText());

        switch (command) {
            case BUY:
                user.setState(command.getInitialState());
                return messageService.configureMessage(message.getChatId(), user.getState().getMessage());
            case USER_INFO:
                return messageService.configureMessage(
                        message.getChatId(),
                        String.format(MessageEnum.USER_INFO.getText(), user.getLastName(), user.getFirstName(), user.getMiddleName())
                );
            default:
                SendMessage sendMessage = messageService.configureMessage(message.getChatId(), MessageEnum.UNKNOWN_COMMAND);
                sendMessage.setReplyMarkup(keyboard);

                return sendMessage;
        }
    }
}
