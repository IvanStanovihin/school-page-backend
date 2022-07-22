package ru.inrtu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inrtu.backend.customException.ScheduleAlreadyExistException;
import ru.inrtu.backend.entity.Schedule;
import ru.inrtu.backend.repository.ScheduleRepository;

import java.util.List;

@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule create(Schedule schedule) throws ScheduleAlreadyExistException{
        Schedule existingSchedule = scheduleRepository.findExistingInDB(
                schedule.getDateOfEvent(), schedule.getActivity().getId());
        if (existingSchedule == null){
            System.out.println("Existing schedule is NULL");
            return scheduleRepository.saveAndFlush(schedule);
        }else{
            System.out.println("Existing schedule is NOT NULL");
            throw new ScheduleAlreadyExistException();
        }
    }

    public Schedule update(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public void delete(Long id){
        scheduleRepository.deleteById(id);
    }

    public Schedule get(Long id){
        return scheduleRepository.getOne(id);
    }

    public List<Schedule> getAll(){
        return scheduleRepository.findAll();
    }

}
