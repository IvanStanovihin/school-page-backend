package ru.inrtu.backend.enums;

public enum ActivityProgress {

    REGISTERED("Зарегистрирован"),
    IN_PROGRESS("В процессе прохождения"),
    FINISHED("Завершено");

    private ActivityProgress(String name){
        this.name = name;
    }

    private final String name;

}
