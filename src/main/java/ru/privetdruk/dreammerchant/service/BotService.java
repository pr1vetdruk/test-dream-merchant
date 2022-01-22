package ru.privetdruk.dreammerchant.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.privetdruk.dreammerchant.handler.MainMenuHandler;
import ru.privetdruk.dreammerchant.handler.MessageHandler;
import ru.privetdruk.dreammerchant.handler.UserDataHandler;
import ru.privetdruk.dreammerchant.model.entity.User;
import ru.privetdruk.dreammerchant.model.enums.Event;
import ru.privetdruk.dreammerchant.model.enums.State;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BotService {
    private final UserDataHandler userDataHandler;
    private final MainMenuHandler mainMenuHandler;

    private final Map<Long, User> users = new HashMap<>();
    private final Map<Event, MessageHandler> handlers;

    public BotService(@Lazy UserDataHandler userDataHandler,
                      @Lazy MainMenuHandler mainMenuHandler) {
        this.userDataHandler = userDataHandler;
        this.mainMenuHandler = mainMenuHandler;
        handlers = Map.of(
                Event.MAIN_MENU, mainMenuHandler,
                Event.FILLING_PROFILE, userDataHandler
        );
    }

    public SendMessage handleUpdate(Update update) {
        Message message = update.getMessage();
        CallbackQuery callbackQuery = update.getCallbackQuery();

        if (message == null || !message.hasText()) {
            if (callbackQuery == null) {
                return null;
            }

            message = callbackQuery.getMessage();
        }

        User user = findUserFromContext(message.getFrom().getId());

        return findHandler(user.getState()).handle(message, user);
    }

    public User updateUserState(Long userId, State state) {
        User user = users.getOrDefault(userId, new User());
        user.setState(state);
        users.put(userId, user);

        return user;
    }

    public User findUserFromContext(Long userId) {
        return Optional.ofNullable(users.get(userId))
                .orElseGet(() -> updateUserState(userId, State.START));
    }

    public MessageHandler findHandler(State state) {
        return handlers.get(state.getEvent());
    }
}
