package ru.privetdruk.dreammerchant.model.enums;

public enum Command {
    BUY("/купить", State.FILLING_USER_DATA_LAST_NAME),
    USER_INFO("/инфо", State.VIEW_USER_INFO),
    UNDEFINED("", null);

    private final String command;
    private final State initialState;

    Command(String command, State initialState) {
        this.command = command;
        this.initialState = initialState;
    }

    public static Command fromCommand(String code) {
        for (Command command : Command.values()) {
            if (command.command.equalsIgnoreCase(code)) {
                return command;
            }
        }

        return UNDEFINED;
    }

    public String getCommand() {
        return command;
    }

    public State getInitialState() {
        return initialState;
    }
}
