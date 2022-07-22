package ru.inrtu.backend.customException;

public class TrajectoryAlreadyExistException extends Exception{

    public final String exceptionReason = "Trajectory with such fields already exists in database";
}
