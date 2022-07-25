package ru.inrtu.backend.customException;

public class TrajectoryAlreadyExistException extends Exception{

    public final String exceptionReason = "Trajectory record already exists in database";
}
