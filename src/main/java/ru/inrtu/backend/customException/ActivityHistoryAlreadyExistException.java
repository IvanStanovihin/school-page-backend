package ru.inrtu.backend.customException;

public class ActivityHistoryAlreadyExistException extends Exception{

    public final String exceptionReason = "Activity history record already exists in database";
}
