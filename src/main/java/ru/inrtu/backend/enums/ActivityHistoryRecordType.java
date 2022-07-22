package ru.inrtu.backend.enums;

public enum ActivityHistoryRecordType {

    REGISTERED("зарегистрирован"),
    IN_PROGRESS("посетил"),
    FINISHED("завершил");

    private ActivityHistoryRecordType(String name){
        this.name = name;
    }

    private final String name;

    public String getName(){
        return name;
    }


}
