package ru.inrtu.backend.customException;

public class StudyActivityAlreadyExistException extends Exception{

    public final String exceptionReason = "Study activity record already exists in database";
}
