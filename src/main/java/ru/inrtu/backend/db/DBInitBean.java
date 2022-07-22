package ru.inrtu.backend.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inrtu.backend.customException.ActivityHistoryAlreadyExistException;
import ru.inrtu.backend.customException.ScheduleAlreadyExistException;
import ru.inrtu.backend.entity.*;
import ru.inrtu.backend.enums.ActivityHistoryRecordType;
import ru.inrtu.backend.enums.ActivityType;
import ru.inrtu.backend.service.ActivityHistoryService;
import ru.inrtu.backend.service.ScheduleService;
import ru.inrtu.backend.service.SchoolchildService;
import ru.inrtu.backend.service.StudyActivityService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Component
public class DBInitBean {


    private ScheduleService scheduleService;
    private SchoolchildService schoolchildService;
    private StudyActivityService studyActivityService;
    private ActivityHistoryService activityHistoryService;

    @Autowired
    public DBInitBean(SchoolchildService schoolchildService, ActivityHistoryService activityHistoryService,
                      StudyActivityService studyActivityService, ScheduleService scheduleService){
        this.scheduleService = scheduleService;
        this.schoolchildService = schoolchildService;
        this.activityHistoryService = activityHistoryService;
        this.studyActivityService = studyActivityService;
    }

    @PostConstruct
    public void initDataBase(){
        List<Schoolchild>allSchoolchildren = schoolchildService.getAll();
        allSchoolchildren.forEach(System.out::println);

        List<StudyActivity>allStudyActivities = studyActivityService.getAll();
        allStudyActivities.forEach(System.out::println);

        initActivityHistory(allStudyActivities, allSchoolchildren);
        initSchedule(allStudyActivities);
    }

    private void initActivityHistory(List<StudyActivity>allActivities, List<Schoolchild>allSchoolchildren){
        ActivityHistory historyRecord1 = new ActivityHistory(allSchoolchildren.get(0),
                allActivities.get(0), ActivityHistoryRecordType.REGISTERED.getName(), "20-07-2022");
        ActivityHistory historyRecord2 = new ActivityHistory(allSchoolchildren.get(0),
                allActivities.get(0), ActivityHistoryRecordType.IN_PROGRESS.getName(), "22-07-2022");
        ActivityHistory historyRecord3 = new ActivityHistory(allSchoolchildren.get(0),
                allActivities.get(0), ActivityHistoryRecordType.FINISHED.getName(), "25-07-2022");
        try {
            activityHistoryService.create(historyRecord1);
            activityHistoryService.create(historyRecord2);
            activityHistoryService.create(historyRecord3);
        }catch(ActivityHistoryAlreadyExistException ex){
            System.out.println("Activity History Record already exist! " + ex);
        }
    }

    private void initSchedule(List<StudyActivity>allActivities){
        StudyActivity activity1 = allActivities.get(0);
        Schedule schedule1 = new Schedule(activity1,
                "22-07-2022", "10:00", "12:00", "B100");
        Schedule schedule2 = new Schedule(activity1,
                "23-07-2022", "12:00", "14:00", "A100");
        Schedule schedule3 = new Schedule(activity1,
                "24-07-2022", "11:00", "13:00", "B204");
//        activity1.addSchedule(schedule1);
//        activity1.addSchedule(schedule2);
//        activity1.addSchedule(schedule3);
//        studyActivityService.update(activity1);
        Schedule scheduleForUpdate = new Schedule(4L, activity1, "22-07-2022", "10:00", "12:00", "В100" );
        scheduleService.update(scheduleForUpdate);
        try {
            scheduleService.create(schedule1);
            scheduleService.create(schedule2);
            scheduleService.create(schedule3);
        }catch (ScheduleAlreadyExistException ex){
            System.out.println(ex);
        }
        System.out.println("Schedule in get(0) activity: ");
        Set<Schedule> activitySchedule = activity1.getSchedule();
        activitySchedule.forEach(System.out::println);
    }
}
