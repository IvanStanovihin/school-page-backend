package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inrtu.backend.entity.ActivityHistory;

public interface ActivityHistoryRepository extends JpaRepository<ActivityHistory, Long>{

    @Query(nativeQuery = true, value = "select * from activity_history h WHERE " +
            "h.history_record_type like :historyRecordType AND h.study_activity_id=:studyActivityId " +
            "AND h.schoolchild_id=:schoolchildId")
    ActivityHistory findExistingInDB(String historyRecordType, Long studyActivityId, Long schoolchildId);
}
