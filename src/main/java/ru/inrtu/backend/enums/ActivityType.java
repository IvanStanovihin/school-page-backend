package ru.inrtu.backend.enums;

public enum ActivityType {

    PROGRAMM("Программа"),
    COURSE("Курс"),
    EVENT("Мероприятие");

    private final String name;

    private ActivityType(String name){
        this.name = name;
    }
}
