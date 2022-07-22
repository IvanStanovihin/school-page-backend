package ru.inrtu.backend.customException;

public class TrajectoryNotFoundException extends Exception{

    public final String exceptionReason = "Object trajectory eas not found in database";
}
