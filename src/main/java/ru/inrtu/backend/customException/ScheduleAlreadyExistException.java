package ru.inrtu.backend.customException;

public class ScheduleAlreadyExistException extends Exception{

    public final String exceptionReason = "Schedule record already exists in database";
}
