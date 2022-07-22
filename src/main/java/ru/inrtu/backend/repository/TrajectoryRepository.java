package ru.inrtu.backend.repository;

import org.postgresql.core.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inrtu.backend.entity.Trajectory;

public interface TrajectoryRepository extends JpaRepository<Trajectory, Long> {

    @Query(nativeQuery = true, value = "select * from trajectory t where t.description like :description " +
            "t.name like :name")
    Trajectory findExistingInDB(String description, String name);

}
