package ru.privetdruk.dreammerchant.model.enums;

public enum Button {
    CONTINUE("Продолжить", null),
    CANCEL("Отмена", null),
    USER_DATA("Ваши данные", Command.USER_INFO),
    BUY("Купить", Command.BUY);

    private final String text;
    private final Command command;

    Button(String text, Command command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public Command getCommand() {
        return command;
    }
}
