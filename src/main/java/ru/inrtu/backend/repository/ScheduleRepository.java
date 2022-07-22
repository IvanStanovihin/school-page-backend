package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inrtu.backend.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(nativeQuery = true, value = "select * from schedule s" +
            " where s.date_of_event like :dateOfEvent and s.study_activity_id=:studyActivityId")
    Schedule findExistingInDB(String dateOfEvent, Long studyActivityId);
}
