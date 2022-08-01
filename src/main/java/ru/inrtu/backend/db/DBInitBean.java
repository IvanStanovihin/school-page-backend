package ru.inrtu.backend.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.inrtu.backend.customException.ActivityHistoryAlreadyExistException;
import ru.inrtu.backend.customException.ScheduleAlreadyExistException;
import ru.inrtu.backend.entity.logic.*;
import ru.inrtu.backend.enums.ActivityHistoryRecordType;
import ru.inrtu.backend.service.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DBInitBean {


    private ScheduleService scheduleService;
    private TrajectoryService trajectoryService;
    private SchoolchildService schoolchildService;
    private StudyActivityService studyActivityService;
    private ActivityHistoryService activityHistoryService;

    @Autowired
    public DBInitBean(SchoolchildService schoolchildService, ActivityHistoryService activityHistoryService,
                      StudyActivityService studyActivityService, ScheduleService scheduleService,
                      TrajectoryService trajectoryService){
        this.scheduleService = scheduleService;
        this.trajectoryService = trajectoryService;
        this.schoolchildService = schoolchildService;
        this.studyActivityService = studyActivityService;
        this.activityHistoryService = activityHistoryService;
    }

    @PostConstruct
    public void initDataBase(){
        List<Schoolchild>allSchoolchildren = schoolchildService.getAll();
        allSchoolchildren.forEach(System.out::println);

        List<StudyActivity>allStudyActivities = studyActivityService.getAll();
        List<Trajectory>allTrajectories = trajectoryService.getAll();
        //Добавляем активностям траектории вручную, потому что в скриптах инициализации не видно idшников
        studyActivitiesSetTrajectory(allStudyActivities, allTrajectories);
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
            System.out.println("History record1: " + historyRecord1.getActivity().getId());
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
                "22-07-2022", "22-07-2022","10:00", "12:00", "B100");
        Schedule schedule2 = new Schedule(activity1,
                "23-07-2022", "23-07-2022", "12:00", "14:00", "A100");
        Schedule schedule3 = new Schedule(activity1,
                "24-07-2022", "24-07-2022", "11:00", "13:00", "B204");
        Schedule scheduleForUpdate = new Schedule(4L, activity1, "22-07-2022", "22-07-2022", "10:00", "12:00", "В100" );
        scheduleService.update(scheduleForUpdate);
        try {
            scheduleService.create(schedule1);
            scheduleService.create(schedule2);
            scheduleService.create(schedule3);
        }catch (ScheduleAlreadyExistException ex){
            System.out.println(ex);
        }
    }

    private void studyActivitiesSetTrajectory(List<StudyActivity>studyActivity,
                                                List<Trajectory>trajectories){
        //Добавление для первой активности 3х траекторий
        StudyActivity activity1 = studyActivity.get(0);
        activity1.addTrajectory(trajectories.get(0));
        activity1.addTrajectory(trajectories.get(1));
        activity1.addTrajectory(trajectories.get(2));
        studyActivityService.update(activity1);

        StudyActivity activity2 = studyActivity.get(1);
        activity2.addTrajectory(trajectories.get(0));
        activity2.addTrajectory(trajectories.get(1));
        studyActivityService.update(activity2);

        StudyActivity activity3 = studyActivity.get(2);
        activity3.addTrajectory(trajectories.get(2));
        studyActivityService.update(activity3);
    }
}
