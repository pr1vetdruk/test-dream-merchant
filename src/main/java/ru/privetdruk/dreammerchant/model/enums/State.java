package ru.privetdruk.dreammerchant.model.enums;

public enum State {
    FILLING_USER_DATA_FIRST_NAME(Event.FILLING_PROFILE, MessageEnum.ENTER_YOUR_FIRST_NAME),
    FILLING_USER_DATA_LAST_NAME(Event.FILLING_PROFILE, MessageEnum.ENTER_YOUR_LAST_NAME),
    FILLING_USER_DATA_MIDDLE_NAME(Event.FILLING_PROFILE, MessageEnum.ENTER_YOUR_MIDDLE_NAME),
    FILLING_USER_DATA_PASSPORT_NUMBER(Event.FILLING_PROFILE, MessageEnum.UNEXPECTED_ERROR),
    FILLING_USER_DATA_PASSPORT_SERIES(Event.FILLING_PROFILE, MessageEnum.UNEXPECTED_ERROR),
    VIEW_USER_INFO(Event.FILLING_PROFILE, MessageEnum.UNEXPECTED_ERROR),
    START(Event.MAIN_MENU, MessageEnum.ENTER_COMMAND);

    private final Event event;
    private final MessageEnum message;

    State(Event event, MessageEnum message) {
        this.event = event;
        this.message = message;
    }

    public Event getEvent() {
        return event;
    }

    public MessageEnum getMessage() {
        return message;
    }
}
