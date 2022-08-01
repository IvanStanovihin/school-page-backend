package ru.inrtu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inrtu.backend.customException.ActivityHistoryAlreadyExistException;
import ru.inrtu.backend.customException.ActivityHistoryNotExistException;
import ru.inrtu.backend.entity.logic.ActivityHistory;
import ru.inrtu.backend.repository.ActivityHistoryRepository;

import java.util.List;

@Service
public class ActivityHistoryService {

    private ActivityHistoryRepository activityHistoryRepository;

    @Autowired
    public ActivityHistoryService(ActivityHistoryRepository activityHistoryRepository){
        this.activityHistoryRepository = activityHistoryRepository;
    }

    public ActivityHistory get(Long id){
        return activityHistoryRepository.findById(id).orElseThrow();
    }

    public List<ActivityHistory>getAll(){
        return activityHistoryRepository.findAll();
    }

    public ActivityHistory create(ActivityHistory activityHistory) throws ActivityHistoryAlreadyExistException{
        ActivityHistory existingActivityHistory = activityHistoryRepository.findExistingInDB(activityHistory.getHistoryRecordType(),
                activityHistory.getActivity().getId(), activityHistory.getSchoolchild().getId());
        if (existingActivityHistory == null){
            return activityHistoryRepository.saveAndFlush(activityHistory);
        }else{
            throw new ActivityHistoryAlreadyExistException();
        }
    }

    public ActivityHistory update(ActivityHistory activityHistory) throws ActivityHistoryNotExistException{
        if (activityHistory.getId() != null){
            throw new ActivityHistoryNotExistException();
        }else {
            return activityHistoryRepository.save(activityHistory);
        }
    }

    public void delete(Long id){
        activityHistoryRepository.deleteById(id);
    }
}
