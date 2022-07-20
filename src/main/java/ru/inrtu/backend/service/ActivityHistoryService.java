package ru.inrtu.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inrtu.backend.entity.ActivityHistory;
import ru.inrtu.backend.repository.ActivityHistoryRepository;

@Service
public class ActivityHistoryService {

    private ActivityHistoryRepository activityHistoryRepository;

    @Autowired
    public ActivityHistoryService(ActivityHistoryRepository activityHistoryRepository){
        this.activityHistoryRepository = activityHistoryRepository;
    }

    public void create(ActivityHistory activityHistory){
        activityHistoryRepository.save(activityHistory);
    }
}
