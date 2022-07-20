package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inrtu.backend.entity.ActivityHistory;

public interface ActivityHistoryRepository extends JpaRepository<ActivityHistory, Long>{
}
