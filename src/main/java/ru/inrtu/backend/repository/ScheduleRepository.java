package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inrtu.backend.entity.logic.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(nativeQuery = true, value = "select * from schedule s " +
            "WHERE s.start_event_date LIKE :startEventDate AND " +
            "s.end_event_date LIKE :endEventDate AND " +
            "s.study_activity_id=:studyActivityId")
    Schedule findExistingInDB(String startEventDate, String endEventDate, Long studyActivityId);
}
