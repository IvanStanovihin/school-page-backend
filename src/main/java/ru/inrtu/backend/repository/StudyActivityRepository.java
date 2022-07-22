package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inrtu.backend.entity.StudyActivity;

public interface StudyActivityRepository extends JpaRepository<StudyActivity, Long> {

    @Query(nativeQuery = true,  value = "select * from study_activity a where" +
            "a.name like :name and a.start_date like startDate")
    StudyActivity findExistingInDB(String name, String startDate);
}
