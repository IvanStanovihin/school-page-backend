package ru.inrtu.backend.enums;

import ru.inrtu.backend.entity.StudyActivity;

public enum ActivityType {

    Программа("Программа"),
    Курс("Курс"),
    Мероприятие("Мероприятие");

    private final String name;

    private ActivityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }


}
