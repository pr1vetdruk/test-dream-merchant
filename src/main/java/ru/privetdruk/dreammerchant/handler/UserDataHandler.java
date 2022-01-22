package ru.privetdruk.dreammerchant.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.privetdruk.dreammerchant.model.entity.User;
import ru.privetdruk.dreammerchant.model.enums.MessageEnum;
import ru.privetdruk.dreammerchant.model.enums.State;
import ru.privetdruk.dreammerchant.service.MessageService;

@Component
public class UserDataHandler implements MessageHandler {
    @Autowired
    private MessageService messageService;

    @Override
    public SendMessage handle(Message message, User user) {
        String text = message.getText();

        switch (user.getState()) {
            case FILLING_USER_DATA_LAST_NAME:
                user.setLastName(text);
                user.setState(State.FILLING_USER_DATA_FIRST_NAME);
                return messageService.configureMessage(message.getChatId(), MessageEnum.ENTER_YOUR_FIRST_NAME);
            case FILLING_USER_DATA_FIRST_NAME:
                user.setFirstName(text);
                user.setState(State.FILLING_USER_DATA_MIDDLE_NAME);
                return messageService.configureMessage(message.getChatId(), MessageEnum.ENTER_YOUR_MIDDLE_NAME);
            case FILLING_USER_DATA_MIDDLE_NAME:
                user.setMiddleName(text);
                user.setState(State.START);
                return messageService.configureMessage(
                        message.getChatId(),
                        String.format(MessageEnum.USER_INFO.getText(), user.getLastName(), user.getFirstName(), user.getMiddleName())
                );
            default:
                return messageService.configureMessage(message.getChatId(), MessageEnum.UNEXPECTED_ERROR);
        }
    }
}
