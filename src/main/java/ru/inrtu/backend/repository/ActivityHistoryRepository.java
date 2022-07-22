package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inrtu.backend.entity.ActivityHistory;

public interface ActivityHistoryRepository extends JpaRepository<ActivityHistory, Long>{

    @Query(nativeQuery = true, value = "select * from activity_history h where" +
            "h.history_record_type like :historyRecordType and h.study_activity_id like :studyActivityId" +
            "and h.schoolchild_id like :schoolchildId")
    ActivityHistory finExistingInDB(String historyRecordType, Long studyActivityId, Long schoolchildId);
}
