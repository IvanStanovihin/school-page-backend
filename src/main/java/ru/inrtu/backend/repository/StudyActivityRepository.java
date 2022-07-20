package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inrtu.backend.entity.StudyActivity;

public interface StudyActivityRepository extends JpaRepository<StudyActivity, Long> {
}
