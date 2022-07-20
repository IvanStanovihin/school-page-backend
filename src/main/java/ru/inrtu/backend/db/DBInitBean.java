package ru.inrtu.backend.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inrtu.backend.entity.ActivityHistory;
import ru.inrtu.backend.entity.Schoolchild;
import ru.inrtu.backend.entity.StudyActivity;
import ru.inrtu.backend.enums.ActivityProgress;
import ru.inrtu.backend.enums.ActivityType;
import ru.inrtu.backend.repository.ActivityHistoryRepository;
import ru.inrtu.backend.repository.StudyActivityRepository;
import ru.inrtu.backend.service.ActivityHistoryService;
import ru.inrtu.backend.service.SchoolchildService;
import ru.inrtu.backend.service.StudyActivityService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DBInitBean {


    private SchoolchildService schoolchildService;
    private StudyActivityService studyActivityService;
    private ActivityHistoryService activityHistoryService;

    @Autowired
    public DBInitBean(SchoolchildService schoolchildService, ActivityHistoryService activityHistoryService,
                      StudyActivityService studyActivityService){
        this.schoolchildService = schoolchildService;
        this.activityHistoryService = activityHistoryService;
        this.studyActivityService = studyActivityService;
    }

    @PostConstruct
    public void initDataBase(){
        System.out.println("TEST VALUE_OF: " + ActivityType.valueOf("Мероприятие"));
        List<Schoolchild>allSchoolchildren = schoolchildService.getAll();
        allSchoolchildren.forEach(System.out::println);

        List<StudyActivity>allStudyActivities = studyActivityService.getAll();
        allStudyActivities.forEach(System.out::println);

        initActivityHistory(allStudyActivities, allSchoolchildren);
    }

    private void initActivityHistory(List<StudyActivity>allActivities, List<Schoolchild>allSchoolchildren){
        ActivityHistory historyRecord1 = new ActivityHistory(allSchoolchildren.get(0),
                allActivities.get(0), ActivityProgress.REGISTERED, "20-07-2022");
        ActivityHistory historyRecord2 = new ActivityHistory(allSchoolchildren.get(0),
                allActivities.get(0), ActivityProgress.REGISTERED, "22-07-2022");
        ActivityHistory historyRecord3 = new ActivityHistory(allSchoolchildren.get(0),
                allActivities.get(0), ActivityProgress.REGISTERED, "25-07-2022");
        activityHistoryService.create(historyRecord1);
        activityHistoryService.create(historyRecord2);
        activityHistoryService.create(historyRecord3);
    }
}
