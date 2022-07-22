package ru.inrtu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inrtu.backend.customException.TrajectoryAlreadyExistException;
import ru.inrtu.backend.entity.Trajectory;
import ru.inrtu.backend.repository.TrajectoryRepository;

import java.util.List;

@Service
public class TrajectoryService {

    private TrajectoryRepository trajectoryRepository;

    @Autowired
    public TrajectoryService(TrajectoryRepository trajectoryRepository){
        this.trajectoryRepository = trajectoryRepository;
    }

    public Trajectory create(Trajectory trajectory) throws TrajectoryAlreadyExistException{
        Trajectory existingTrajectory = trajectoryRepository.findExistingInDB(
                trajectory.getDescription(), trajectory.getName());
        if (existingTrajectory == null){
            return trajectoryRepository.save(trajectory);
        }else{
            throw new TrajectoryAlreadyExistException();
        }
    }

    public Trajectory update(Trajectory trajectory){
        return trajectoryRepository.save(trajectory);
    }

    public List<Trajectory> getAll(){
        return trajectoryRepository.findAll();
    }

    public Trajectory get(Long id){
        return trajectoryRepository.getOne(id);
    }
}
