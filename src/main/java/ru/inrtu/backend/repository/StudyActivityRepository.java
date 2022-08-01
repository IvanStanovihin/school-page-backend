package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inrtu.backend.entity.logic.StudyActivity;

public interface StudyActivityRepository extends JpaRepository<StudyActivity, Long> {

    @Query(nativeQuery = true,  value = "select * from study_activity s where" +
            "s.name like :name and s.start_date like :startDate")
    StudyActivity findExistingInDB(String name, String startDate);
}
