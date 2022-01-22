package ru.privetdruk.dreammerchant.model.enums;

public enum MessageEnum {
    ENTER_YOUR_FIRST_NAME("Введите своё имя:"),
    ENTER_YOUR_LAST_NAME("Введите свою фамилию:"),
    ENTER_YOUR_MIDDLE_NAME("Введите своё отчество:"),
    ENTER_COMMAND("Введите команду..."),
    YOU_ENTERED("Вы ввели:"),
    UNEXPECTED_ERROR("Извините, произошла непредвиденная ошибка :<"),
    UNKNOWN_COMMAND("Вы ввели неизвестную команду"),
    USER_INFO("Ваши данные\n> Фамилия: %s\n> Имя: %s\n> Отчество: %s");

    private final String text;

    MessageEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
